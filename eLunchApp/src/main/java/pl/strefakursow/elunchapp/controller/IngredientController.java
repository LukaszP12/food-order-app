package pl.strefakursow.elunchapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.elunchapp.DTO.EmployeeDto;
import pl.strefakursow.elunchapp.DTO.IngredientDto;
import pl.strefakursow.elunchapp.DTO.LogginDataDto;
import pl.strefakursow.elunchapp.DTO.PersonalDataDto;
import pl.strefakursow.elunchapp.service.IngredientService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/ingredients", produces = MediaType.APPLICATION_JSON_VALUE)
public class IngredientController {
    interface IngredientListView extends EmployeeDto.View.Basic, PersonalDataDto.View.Basic { }

    interface IngredientView extends EmployeeDto.View.Extended, PersonalDataDto.View.Extended, LogginDataDto.View.Basic { }

    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<IngredientDto> get() {
        return null;
    }

    @GetMapping("/{uuid}")
    public IngredientDto get(@PathVariable UUID uuid) {
        return null;
    }

    public void put(@PathVariable UUID uuid, @RequestBody IngredientDto json) {

    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid){

    }
}
