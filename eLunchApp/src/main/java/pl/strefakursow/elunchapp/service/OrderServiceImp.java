package pl.strefakursow.elunchapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.elunchapp.DTO.OrderDto;
import pl.strefakursow.elunchapp.DTO.OrderStatusDto;
import pl.strefakursow.elunchapp.DTO.UserDTO;
import pl.strefakursow.elunchapp.model.Order;
import pl.strefakursow.elunchapp.repo.DelivererRepo;
import pl.strefakursow.elunchapp.repo.DiscountCodeRepo;
import pl.strefakursow.elunchapp.repo.MenuItemRepo;
import pl.strefakursow.elunchapp.repo.OrderItemRepo;
import pl.strefakursow.elunchapp.repo.OrderRepo;
import pl.strefakursow.elunchapp.repo.RestaurantRepo;
import pl.strefakursow.elunchapp.repo.UserRepo;
import pl.strefakursow.elunchapp.utils.ConverterUtils;

import java.util.List;
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

    @Autowired
    public OrderServiceImp(OrderRepo orderRepo,
                           UserRepo userRepo, RestaurantRepo restaurantRepo,
                           DelivererRepo delivererRepo,
                           MenuItemRepo menuItemRepo,
                           DiscountCodeRepo discountCodeRepo,
                           OrderItemRepo orderItemRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.restaurantRepo = restaurantRepo;
        this.delivererRepo = delivererRepo;
        this.menuItemRepo = menuItemRepo;
        this.discountCodeRepo = discountCodeRepo;
        this.orderItemRepo = orderItemRepo;
    }

    @Override
    public List<OrderDto> getAll() {
        return orderRepo.findAll().stream()
                .map(ConverterUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void put(UUID uuid, OrderDto orderDto) {

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

    }

    @Override
    public UserDTO newOperationForPaidOrder(OrderDto orderDto) {
        return null;
    }

    @Override
    public void setIsDelivered(OrderDto orderDto, OrderStatusDto orderStatusDto) {

    }

    @Override
    public void setIsGivenOut(OrderDto orderDto, OrderStatusDto orderStatusDto) {

    }

}
