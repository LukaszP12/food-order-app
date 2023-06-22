package pl.strefakursow.elunchapp.controller;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.elunchapp.DTO.DelivererDto;
import pl.strefakursow.elunchapp.DTO.OrderDto;
import pl.strefakursow.elunchapp.DTO.OrderStatusDto;
import pl.strefakursow.elunchapp.DTO.RestaurantDto;
import pl.strefakursow.elunchapp.DTO.UserDTO;
import pl.strefakursow.elunchapp.model.User;
import pl.strefakursow.elunchapp.service.DelivererService;
import pl.strefakursow.elunchapp.service.OrderService;
import pl.strefakursow.elunchapp.service.UserService;

import javax.transaction.Transactional;
import javax.validation.groups.Default;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Validated
@RestController
@RequestMapping(path = "/api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    interface OrderListView extends OrderDto.View.Basic, UserDTO.View.Extended, DelivererDto.View.Id, RestaurantDto.View.Id {
    }

    interface OrderView extends OrderDto.View.Extended, UserDTO.View.Extended, DelivererDto.View.Id, RestaurantDto.View.Id {
    }

    private final OrderService orderService;
    private final DelivererService delivererService;
    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;

    interface OrderDataUpdateValidation extends Default, OrderDto.OrderValidation {
    }

    interface OrderStatusValidation extends Default, OrderDto.OrderStatusValidation {
    }

    interface GiveOutValidation extends Default, OrderDto.OrderStatusValidation, OrderStatusDto.GiveOutStatusValidation {
    }

    interface DeliveryValidation extends Default, OrderDto.OrderStatusValidation, OrderStatusDto.DeliveryValidation {
    }

    @Autowired
    public OrderController(OrderService orderService,
                           DelivererService delivererService,
                           UserService userService,
                           ApplicationEventPublisher applicationEventPublisher) {
        this.orderService = orderService;
        this.delivererService = delivererService;
        this.userService = userService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @JsonView(OrderListView.class)
    @GetMapping
    public List<OrderDto> get() {
        return orderService.getAll();
    }

    @JsonView(OrderListView.class)
    @GetMapping(params = {"user"})
    public List<OrderDto> getByUser(@RequestParam("user") UUID userUuid) {
//        UserDTO user = userService.getByUuid(userUuid);
//        return user.getOrders();
        return null;
    }

    @JsonView(OrderListView.class)
    @GetMapping(params = {"deliverer"})
    public List<OrderDto> getByDeliverer(@RequestParam("deliverer") UUID delivererUuid) {
        DelivererDto deliverer = delivererService.getByUuid(delivererUuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return deliverer.getOrders();
    }

    @GetMapping("/{uuid}")
    public UserDTO get(@PathVariable UUID uuid) {
        return null;
    }

    @Transactional
    @Validated(OrderDataUpdateValidation.class)
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody UserDTO userDTO) {

    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {

    }

    @Transactional
    @Validated(OrderStatusValidation.class)
    @PatchMapping("/{uuid}/paid")
    public void patchIsPaid(@PathVariable UUID uuid) {
        OrderDto orderDto = orderService.getByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        orderService.setIsPaid(orderDto);
    }

    @Transactional
    @Validated(GiveOutValidation.class)
    @PatchMapping("/{uuid}/paid")
    public void patchIsGivenOut(@PathVariable UUID uuid, @RequestBody @Valid OrderStatusDto orderStatusJson) {
//        orderService.setIsGivenOut(uuid,orderStatusJson);
    }

    @Transactional
    @Validated(DeliveryValidation.class)
    @PatchMapping("/{uuid}/paid")
    public void patchIsDelivered(@PathVariable UUID uuid, @RequestBody @Valid OrderStatusDto orderStatusJson) {
//        orderService.setIsDelivered(uuid,orderStatusJson);
    }
}
