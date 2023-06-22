package pl.strefakursow.elunchapp.service;

import pl.strefakursow.elunchapp.DTO.OpenTimeDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OpenTimeService {
    List<OpenTimeDto> getAll();

    void put(UUID uuid, OpenTimeDto openTimeDto);

    void delete(UUID uuid);

    Optional<OpenTimeDto> getByUuid(UUID uuid);
}
