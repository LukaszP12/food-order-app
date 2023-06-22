package pl.strefakursow.elunchapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.elunchapp.DTO.DishDto;
import pl.strefakursow.elunchapp.DTO.MenuItemDto;
import pl.strefakursow.elunchapp.DTO.RestaurantDto;
import pl.strefakursow.elunchapp.service.MenuItemService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/menu-items",produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuItemController {
    interface MenuItemListView extends MenuItemDto.View.Basic, RestaurantDto.View.Id { }
    interface MenuItemView extends MenuItemDto.View.Extended, RestaurantDto.View.Id, DishDto.View.Id { }

    private final MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping
    public List<MenuItemDto> get() {
        return null;
    }

    @GetMapping("/{uuid}")
    public MenuItemDto get(@PathVariable UUID uuid) {
        return null;
    }

    public void put(@PathVariable UUID uuid, @RequestBody MenuItemDto json) {

    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid){

    }
}
