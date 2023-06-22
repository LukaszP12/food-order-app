package pl.strefakursow.elunchapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.elunchapp.DTO.ProductDto;
import pl.strefakursow.elunchapp.model.Product;
import pl.strefakursow.elunchapp.repo.DishRepo;
import pl.strefakursow.elunchapp.repo.IngredientRepo;
import pl.strefakursow.elunchapp.repo.ProductRepo;
import pl.strefakursow.elunchapp.utils.ConverterUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final IngredientRepo ingredientRepo;
    private final DishRepo dishRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, IngredientRepo ingredientRepo, DishRepo dishRepo) {
        this.productRepo = productRepo;
        this.ingredientRepo = ingredientRepo;
        this.dishRepo = dishRepo;
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepo.findAll().stream()
                .map(ConverterUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void put(UUID uuid, ProductDto productDto) {

    }

    @Override
    public void delete(UUID uuid) {
        Product product = productRepo.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        productRepo.delete(product);
    }

    @Override
    public Optional<ProductDto> getByUuid(UUID uuid) {
        return productRepo.findByUuid(uuid).map(ConverterUtils::convert);
    }
}
