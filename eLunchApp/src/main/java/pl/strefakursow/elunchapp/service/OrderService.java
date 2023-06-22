package pl.strefakursow.elunchapp.service;

import pl.strefakursow.elunchapp.DTO.OrderDto;
import pl.strefakursow.elunchapp.DTO.OrderStatusDto;
import pl.strefakursow.elunchapp.DTO.UserDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    List<OrderDto> getAll();

    void put(UUID uuid, OrderDto orderDto);

    void delete(UUID uuid);

    Optional<OrderDto> getByUuid(UUID uuid);

    void setIsPaid(OrderDto orderDto);

    void setIsDelivered(OrderDto orderDto, OrderStatusDto orderStatusDto);

    void setIsGivenOut(OrderDto orderDto, OrderStatusDto orderStatusDto);

    UserDTO newOperationForPaidOrder(OrderDto orderDto);
}
