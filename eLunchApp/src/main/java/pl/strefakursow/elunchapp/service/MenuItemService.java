package pl.strefakursow.elunchapp.service;

import pl.strefakursow.elunchapp.DTO.MenuItemDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MenuItemService {
    List<MenuItemDto> getAll();

    void put(UUID uuid, MenuItemDto menuItemDto);

    void delete(UUID uuid);

    Optional<MenuItemDto> getByUuid(UUID uuid);
}
