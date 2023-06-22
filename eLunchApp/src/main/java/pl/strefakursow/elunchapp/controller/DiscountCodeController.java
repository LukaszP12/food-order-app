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
import pl.strefakursow.elunchapp.DTO.DiscountCodeDto;
import pl.strefakursow.elunchapp.DTO.PeriodDTO;
import pl.strefakursow.elunchapp.service.DiscountCodeService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/discount-codes", produces = MediaType.APPLICATION_JSON_VALUE)
public class DiscountCodeController {
    interface DiscountCodeListView extends DiscountCodeDto.View.Basic, PeriodDTO.View.Basic { }
    interface DiscountCodeView extends DiscountCodeDto.View.Extended, PeriodDTO.View.Basic { }

    private final DiscountCodeService discountCodeService;

    @Autowired
    public DiscountCodeController(DiscountCodeService discountCodeService) {
        this.discountCodeService = discountCodeService;
    }

    @JsonView(DiscountCodeListView.class)
    @GetMapping
    public List<DiscountCodeDto> get() {
        return discountCodeService.getAll();
    }

    @JsonView(DiscountCodeView.class)
    @GetMapping("/{uuid}")
    public DiscountCodeDto get(@PathVariable UUID uuid) {
        return discountCodeService.getByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody @Valid DiscountCodeDto json) {
        discountCodeService.put(uuid,json);
    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        discountCodeService.delete(uuid);
    }
}
