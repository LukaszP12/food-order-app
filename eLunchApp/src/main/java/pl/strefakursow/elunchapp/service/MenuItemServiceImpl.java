package pl.strefakursow.elunchapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.strefakursow.elunchapp.DTO.MenuItemDto;
import pl.strefakursow.elunchapp.repo.DishRepo;
import pl.strefakursow.elunchapp.repo.MenuItemRepo;
import pl.strefakursow.elunchapp.repo.RestaurantRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MenuItemServiceImpl implements MenuItemService {
    private final MenuItemRepo menuItemRepo;
    private final RestaurantRepo restaurantRepo;
    private final DishRepo dishRepo;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepo menuItemRepo, RestaurantRepo restaurantRepo, DishRepo dishRepo) {
        this.menuItemRepo = menuItemRepo;
        this.restaurantRepo = restaurantRepo;
        this.dishRepo = dishRepo;
    }

    @Override
    public List<MenuItemDto> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, MenuItemDto menuItemDto) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<MenuItemDto> getByUuid(UUID uuid) {
        return Optional.empty();
    }
}
