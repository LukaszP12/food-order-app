package pl.strefakursow.elunchapp.service;

import pl.strefakursow.elunchapp.DTO.OrderTimeDto;
import pl.strefakursow.elunchapp.model.DiscountCode;
import pl.strefakursow.elunchapp.model.OrderItem;
import pl.strefakursow.elunchapp.model.enums.PriceType;

import javax.activation.UnsupportedDataTypeException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderTimeService {
    List<OrderTimeDto> getAll();

    void put(UUID uuid, OrderTimeDto orderTimeDto);

    void delete(UUID uuid);

    Optional<OrderTimeDto> getByUuid(UUID uuid);

    BigDecimal calculatePrice(List<OrderItem> orderItemsList, BigDecimal startPrice, PriceType priceType) throws UnsupportedDataTypeException;

    BigDecimal applyDiscount(DiscountCode discountCode, BigDecimal orderBruttoPrice) throws UnsupportedDataTypeException;
}
