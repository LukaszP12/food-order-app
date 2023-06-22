package pl.strefakursow.elunchapp.service;

import pl.strefakursow.elunchapp.DTO.DelivererDto;
import pl.strefakursow.elunchapp.DTO.IngredientDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IngredientService {
    List<IngredientDto> getAll();

    void put(UUID uuid, IngredientDto ingredientDto);

    void delete(UUID uuid);

    Optional<IngredientDto> getByUuid(UUID uuid);
}
