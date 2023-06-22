package pl.strefakursow.elunchapp.service;

import pl.strefakursow.elunchapp.DTO.DelivererDto;
import pl.strefakursow.elunchapp.DTO.DiscountCodeDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DiscountCodeService {
    List<DiscountCodeDto> getAll();

    void put(UUID uuid, DiscountCodeDto discountCodeDto);

    void delete(UUID uuid);

    Optional<DiscountCodeDto> getByUuid(UUID uuid);
}
