package pl.strefakursow.elunchapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.elunchapp.DTO.OperationEvidenceDto;
import pl.strefakursow.elunchapp.DTO.OperationEvidenceDtoBuilder;
import pl.strefakursow.elunchapp.DTO.OrderDto;
import pl.strefakursow.elunchapp.DTO.OrderStatusDto;
import pl.strefakursow.elunchapp.DTO.UserDTO;
import pl.strefakursow.elunchapp.model.Deliverer;
import pl.strefakursow.elunchapp.model.DiscountCode;
import pl.strefakursow.elunchapp.model.MenuItem;
import pl.strefakursow.elunchapp.model.Order;
import pl.strefakursow.elunchapp.model.OrderBuilder;
import pl.strefakursow.elunchapp.model.OrderItem;
import pl.strefakursow.elunchapp.model.OrderItemBuilder;
import pl.strefakursow.elunchapp.model.OrderStatus;
import pl.strefakursow.elunchapp.model.OrderStatusBuilder;
import pl.strefakursow.elunchapp.model.Restaurant;
import pl.strefakursow.elunchapp.model.User;
import pl.strefakursow.elunchapp.model.enums.EvidenceType;
import pl.strefakursow.elunchapp.model.enums.PriceType;
import pl.strefakursow.elunchapp.repo.DelivererRepo;
import pl.strefakursow.elunchapp.repo.DiscountCodeRepo;
import pl.strefakursow.elunchapp.repo.MenuItemRepo;
import pl.strefakursow.elunchapp.repo.OrderItemRepo;
import pl.strefakursow.elunchapp.repo.OrderRepo;
import pl.strefakursow.elunchapp.repo.RestaurantRepo;
import pl.strefakursow.elunchapp.repo.UserRepo;
import pl.strefakursow.elunchapp.utils.ConverterUtils;

import javax.activation.UnsupportedDataTypeException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImp implements OrderService {
    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final RestaurantRepo restaurantRepo;
    private final DelivererRepo delivererRepo;
    private final MenuItemRepo menuItemRepo;
    private final DiscountCodeRepo discountCodeRepo;
    private final OrderItemRepo orderItemRepo;
    private final OrderItemService orderItemService;

    @Autowired
    public OrderServiceImp(OrderRepo orderRepo,
                           UserRepo userRepo, RestaurantRepo restaurantRepo,
                           DelivererRepo delivererRepo,
                           MenuItemRepo menuItemRepo,
                           DiscountCodeRepo discountCodeRepo,
                           OrderItemRepo orderItemRepo, OrderItemService orderItemService) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.restaurantRepo = restaurantRepo;
        this.delivererRepo = delivererRepo;
        this.menuItemRepo = menuItemRepo;
        this.discountCodeRepo = discountCodeRepo;
        this.orderItemRepo = orderItemRepo;
        this.orderItemService = orderItemService;
    }

    @Override
    public List<OrderDto> getAll() {
        return orderRepo.findAll().stream()
                .map(ConverterUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void put(UUID uuid, OrderDto orderDto) {
        if (!Objects.equals(orderDto.getUuid(), uuid)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        User user = userRepo.findByUuid(orderDto.getUser().getUuid())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Restaurant restaurant = restaurantRepo.findByUuid(orderDto.getRestaurantDto().getUuid())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Deliverer deliverer = delivererRepo.findByUuid(orderDto.getDelivererDto().getUuid())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Order order = orderRepo.findByUuid(orderDto.getUuid())
                .orElseGet(() -> newOrder(uuid, user, restaurant));

        if (!Objects.equals(order.getUser().getUuid(), orderDto.getUser().getUuid())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if (!Objects.equals(order.getRestaurant(), orderDto.getRestaurantDto().getUuid())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if (order.getOrderStatus().getDeliveryTime() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        List<OrderItem> orderItems = putOrderItems(orderDto);
        DiscountCode discountCode = putDiscountCode(orderDto);

        BigDecimal orderNettoPrice;
        BigDecimal orderBruttoPrice;
        BigDecimal amountToPayBrutto;
        try {
            orderNettoPrice = orderItemService.calculatePrice(orderItems, BigDecimal.ZERO, PriceType.NETTO);
            orderBruttoPrice = orderItemService.calculatePrice(orderItems, BigDecimal.ZERO, PriceType.BRUTTO);
            amountToPayBrutto = orderItemService.applyDiscount(discountCode, orderBruttoPrice);
        } catch (UnsupportedDataTypeException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        order.setNote(orderDto.getNote());
        order.setNettoPrice(orderNettoPrice);
        order.setBruttoPrice(orderBruttoPrice);
        order.setAmountToPayBrutto(amountToPayBrutto);
        order.setDiscountCode(discountCode);
        order.setOrderItems(orderItems);
        order.setDeliverer(deliverer);

        if (order.getId() == null) {
            orderRepo.save(order);
        }
    }

    private DiscountCode putDiscountCode(OrderDto orderDto) {
        DiscountCode discountCode = null;
        if (orderDto.getDiscountCodeDto() != null) {
            discountCode = discountCodeRepo.findByUuid(orderDto.getDiscountCodeDto().getUuid())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

            if (discountCode.getRestaurants() != null) {
                discountCode.getRestaurants().stream()
                        .filter(r -> r.getUuid().equals(orderDto.getRestaurantDto().getUuid()))
                        .findFirst()
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
            }
            if (discountCode.getUsers() != null) {
                discountCode.getUsers().stream()
                        .filter(u -> u.getUuid().equals(orderDto.getUser().getUuid()))
                        .findFirst()
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
            }
        }
        return discountCode;
    }

    private List<OrderItem> putOrderItems(OrderDto orderDto) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItem orderItemDto : orderDto.getOrderItems()) {
            MenuItem menuItem = menuItemRepo.findByUuid(orderItemDto.getMenuItem().getUuid())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

            OrderItem orderItem = orderItemRepo.findByUuid(orderDto.getUuid())
                    .orElseGet(() -> newOrderItem(orderDto.getUuid()));
            orderItem.setQuantity(orderItemDto.getQuantity());
            orderItem.setMenuItem(menuItem);
            if (orderItem.getId() == null) {
                orderItemRepo.save(orderItem);
            }
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    private OrderItem newOrderItem(UUID uuid) {
        return new OrderItemBuilder()
                .withUuid(uuid)
                .build();
    }

    private Order newOrder(UUID uuid, User user, Restaurant restaurant) {

        return new OrderBuilder()
                .withUuid(uuid)
                .withUser(user)
                .withOrderStatus(newOrderStatus())
                .withRestaurant(restaurant)
                .build();
    }

    private OrderStatus newOrderStatus() {
        return new OrderStatusBuilder()
                .withOrderTime(Instant.now())
                .withIsPaid(false)
                .build();
    }

    @Override
    public void delete(UUID uuid) {
        Order order = orderRepo.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        orderRepo.delete(order);
    }

    @Override
    public Optional<OrderDto> getByUuid(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public void setIsPaid(OrderDto orderDto) {
        Order order = orderRepo.findByUuid(orderDto.getUuid())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (!order.getOrderStatus().getIsPaid()) {
            order.getOrderStatus().setIsPaid(true);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void setIsGivenOut(UUID uuid, OrderStatusDto orderStatusDto) {
        Order order = orderRepo.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (!order.getOrderStatus().getIsPaid() || orderStatusDto.getDeliveryTime() != null) {
            new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        order.getOrderStatus().setGiveOutTime(orderStatusDto.getGiveOutTime());
    }

    @Override
    public void setIsDelivered(UUID uuid, OrderStatusDto orderStatusDto) {
        Order order = orderRepo.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (!order.getOrderStatus().getIsPaid() || order.getOrderStatus().getGiveOutTime() == null) {
            new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        order.getOrderStatus().setDeliveryTime(orderStatusDto.getDeliveryTime());
    }

    @Override
    public UserDTO newOperationForPaidOrder(OrderDto orderDto) {
        User user = userRepo.findByUuid(orderDto.getUuid())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        UserDTO userDTO = ConverterUtils.convert(user);
        userDTO.setOperationEvidences(List.of(newEvidenceForOrderPayment(orderDto)));
        return userDTO;
    }

    private OperationEvidenceDto newEvidenceForOrderPayment(OrderDto orderDto) {
        return new OperationEvidenceDtoBuilder()
                .withDate(Instant.now())
                .withUser(orderDto.getUser())
                .withAmount(orderDto.getAmountToPayBrutto())
                .withEvidenceType(EvidenceType.PAYMENT)
                .build();
    }

}
