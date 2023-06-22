package pl.strefakursow.elunchapp.service;

import pl.strefakursow.elunchapp.DTO.DelivererDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DelivererService {
    List<DelivererDto> getAll();

    void put(UUID uuid, DelivererDto delivererDto);

    void delete(UUID uuid);

    Optional<DelivererDto> getByUuid(UUID uuid);
}
