package pl.strefakursow.elunchapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.elunchapp.DTO.IngredientDto;
import pl.strefakursow.elunchapp.model.Ingredient;
import pl.strefakursow.elunchapp.model.Order;
import pl.strefakursow.elunchapp.repo.IngredientRepo;
import pl.strefakursow.elunchapp.utils.ConverterUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepo ingredientRepo;

    @Autowired
    public IngredientServiceImpl(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public List<IngredientDto> getAll() {
        return ingredientRepo.findAll().stream()
                .map(ConverterUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void put(UUID uuid, IngredientDto ingredientDto) {

    }

    @Override
    public void delete(UUID uuid) {
        Ingredient ingredient = ingredientRepo.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        ingredientRepo.delete(ingredient);
    }

    @Override
    public Optional<IngredientDto> getByUuid(UUID uuid) {
        return ingredientRepo.findByUuid(uuid).map(ConverterUtils::convert);
    }
}
