package pl.strefakursow.elunchapp.service;

import pl.strefakursow.elunchapp.DTO.DeliveryAddressDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DeliveryAddressService {
    List<DeliveryAddressDto> getAll();

    void put(UUID uuid, DeliveryAddressDto deliveryAddressDto);

    void delete(UUID uuid);

    Optional<DeliveryAddressDto> getByUuid(UUID uuid);
}
