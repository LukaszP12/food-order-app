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
import pl.strefakursow.elunchapp.DTO.CompanyDataDto;
import pl.strefakursow.elunchapp.DTO.DishDto;
import pl.strefakursow.elunchapp.DTO.IngredientDto;
import pl.strefakursow.elunchapp.DTO.LogginDataDto;
import pl.strefakursow.elunchapp.DTO.OpenTimeDto;
import pl.strefakursow.elunchapp.DTO.ProductDto;
import pl.strefakursow.elunchapp.DTO.RestaurantDto;
import pl.strefakursow.elunchapp.service.DishService;
import pl.strefakursow.elunchapp.service.RestaurantService;

import javax.transaction.Transactional;
import javax.validation.groups.Default;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping(path = "/api/restaurant", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {
    interface RestaurantListView extends RestaurantDto.View.Basic { }
    interface RestaurantView extends RestaurantDto.View.Extended, LogginDataDto.View.Basic, CompanyDataDto.View.Extended, OpenTimeDto.View.Extended { }

    private final RestaurantService restaurantService;

    interface DataUpdateValidation extends Default, RestaurantDto.DataUpdateValidation {}

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<RestaurantDto> get() {
        return null;
    }

    @GetMapping("/{uuid}")
    public RestaurantDto get(@PathVariable UUID uuid) {
        return null;
    }

    @Transactional
    @Validated(DataUpdateValidation.class)
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody RestaurantDto restaurantDto) {

    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {

    }
}
