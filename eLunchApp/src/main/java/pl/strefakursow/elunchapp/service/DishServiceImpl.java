package pl.strefakursow.elunchapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.strefakursow.elunchapp.DTO.DishDto;
import pl.strefakursow.elunchapp.repo.DishRepo;
import pl.strefakursow.elunchapp.repo.MenuItemRepo;
import pl.strefakursow.elunchapp.repo.ProductRepo;
import pl.strefakursow.elunchapp.utils.ConverterUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class DishServiceImpl implements DishService {
    private final DishRepo dishRepo;
    private final MenuItemRepo menuItemRepo;
    private final ProductRepo productRepo;

    @Autowired
    public DishServiceImpl(DishRepo dishRepo, MenuItemRepo menuItemRepo, ProductRepo productRepo) {
        this.dishRepo = dishRepo;
        this.menuItemRepo = menuItemRepo;
        this.productRepo = productRepo;
    }

    @Override
    public List<DishDto> getAll() {
        return deliveryAddressRepo.findAll().stream()
                .map(ConverterUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void put(UUID uuid, DishDto dishDto) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<DishDto> getByUuid(UUID uuid) {
        return Optional.empty();
    }
}
