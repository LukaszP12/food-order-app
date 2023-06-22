package pl.strefakursow.elunchapp.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.elunchapp.DTO.DishDto;
import pl.strefakursow.elunchapp.DTO.MenuItemDto;
import pl.strefakursow.elunchapp.DTO.OpenTimeDto;
import pl.strefakursow.elunchapp.DTO.RestaurantDto;
import pl.strefakursow.elunchapp.service.OpenTimeService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/open-times", produces = MediaType.APPLICATION_JSON_VALUE)
public class OpenTimeController {
    interface OpenTimeListView extends OpenTimeDto.View.Basic {
    }

    interface OpenTimeView extends OpenTimeDto.View.Extended, RestaurantDto.View.Id {
    }

    private final OpenTimeService openTimeService;

    @Autowired
    public OpenTimeController(OpenTimeService openTimeService) {
        this.openTimeService = openTimeService;
    }

    @JsonView(OpenTimeListView.class)
    @GetMapping
    public List<OpenTimeDto> get() {
        return openTimeService.getAll();
    }

    @Transactional
    @GetMapping
    public void post(@RequestBody List<@Valid OpenTimeDto> openTimeJson) {
        for (OpenTimeDto openTimeDto : openTimeJson){
            put(openTimeDto.getUuid(),openTimeDto);
        }
    }

    @JsonView(OpenTimeView.class)
    @GetMapping("{uuid}")
    public OpenTimeDto get(@PathVariable UUID uuid) {
        return openTimeService.getByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody OpenTimeDto json) {
        openTimeService.put(uuid, json);
    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        openTimeService.delete(uuid);
    }
}
