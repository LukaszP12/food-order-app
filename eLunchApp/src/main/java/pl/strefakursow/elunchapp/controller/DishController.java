package pl.strefakursow.elunchapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.elunchapp.DTO.DelivererDto;
import pl.strefakursow.elunchapp.DTO.DiscountCodeDto;
import pl.strefakursow.elunchapp.DTO.DishDto;
import pl.strefakursow.elunchapp.DTO.MenuItemDto;
import pl.strefakursow.elunchapp.DTO.PeriodDTO;
import pl.strefakursow.elunchapp.DTO.ProductDto;
import pl.strefakursow.elunchapp.model.Dish;
import pl.strefakursow.elunchapp.service.DiscountCodeService;
import pl.strefakursow.elunchapp.service.DishService;

import javax.transaction.Transactional;
import javax.validation.groups.Default;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/dishes", produces = MediaType.APPLICATION_JSON_VALUE)
public class DishController {
    interface DishListView extends DishDto.View.Basic {}
    interface DishView extends DishDto.View.Extended, ProductDto.View.Extended, MenuItemDto.View.Basic {}

    private final DishService dishService;

    interface DishDataUpdateValidation extends Default,DishDto.DataUpdateValidation {}

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public List<DishDto> get() {
        return null;
    }

    @GetMapping("/{uuid}")
    public DishDto get(@PathVariable UUID uuid) {
        return null;
    }

    @Transactional
    @Validated(DishDataUpdateValidation.class)
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody DishDto dishDto) {

    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {

    }
}
