package pl.strefakursow.elunchapp.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.elunchapp.DTO.DelivererDto;
import pl.strefakursow.elunchapp.DTO.LogginDataDto;
import pl.strefakursow.elunchapp.DTO.OrderDto;
import pl.strefakursow.elunchapp.DTO.PersonalDataDto;
import pl.strefakursow.elunchapp.service.DelivererService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping(path = "/api/deliverers", produces = MediaType.APPLICATION_JSON_VALUE)
public class DelivererController {
    interface DelivererListView extends DelivererDto.View.Basic, PersonalDataDto.View.Basic { }

    interface DelivererView extends DelivererDto.View.Extended, PersonalDataDto.View.Extended, LogginDataDto.View.Basic, OrderDto.View.Extended { }

    interface NewDelivererValidation extends Default, DelivererDto.NewDelivererValidation { }

    private final DelivererService delivererService;

    @Autowired
    public DelivererController(DelivererService delivererService) {
        this.delivererService = delivererService;
    }

    @JsonView(DelivererListView.class)
    @GetMapping
    public List<DelivererDto> get() {
        return delivererService.getAll();
    }

    @JsonView(DelivererView.class)
    @GetMapping("/{uuid}")
    public DelivererDto get(@PathVariable UUID uuid) {
        return delivererService.getByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    @Validated(DelivererDto.NewDelivererValidation.class)
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody @Valid DelivererDto json) {
        delivererService.put(uuid,json);
    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        delivererService.delete(uuid);
    }

}
