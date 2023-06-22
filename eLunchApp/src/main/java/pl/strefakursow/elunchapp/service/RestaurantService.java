package pl.strefakursow.elunchapp.service;

import pl.strefakursow.elunchapp.DTO.RestaurantDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestaurantService {
    List<RestaurantDto> getAll();

    void put(UUID uuid, RestaurantDto restaurantDto);

    void delete(UUID uuid);

    Optional<RestaurantDto> getByUuid(UUID uuid);
}
