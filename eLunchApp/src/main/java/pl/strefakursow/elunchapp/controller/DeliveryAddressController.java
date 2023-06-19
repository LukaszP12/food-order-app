package pl.strefakursow.elunchapp.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.strefakursow.elunchapp.DTO.DelivererDto;
import pl.strefakursow.elunchapp.DTO.DeliveryAddressDto;
import pl.strefakursow.elunchapp.DTO.UserDTO;
import pl.strefakursow.elunchapp.service.DeliveryAddressService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/delivery-address", produces = MediaType.APPLICATION_JSON_VALUE)
public class DeliveryAddressController {

    interface DeliveryAddressListView extends DeliveryAddressDto.View.Basic, UserDTO.View.Basic {}
    interface DeliveryAddressView extends DeliveryAddressDto.View.Extended, UserDTO.View.Id {}

    private final DeliveryAddressService deliveryAddressService;

    @Autowired
    public DeliveryAddressController(DeliveryAddressService deliveryAddressService) {
        this.deliveryAddressService = deliveryAddressService;
    }

    @JsonView(DeliveryAddressListView.class)
    @GetMapping
    public List<DeliveryAddressDto> get() {
        return deliveryAddressService.getAll();
    }

    @JsonView(DeliveryAddressView.class)
    @GetMapping("/{uuid}")
    public DeliveryAddressDto get(@PathVariable UUID uuid) {
        return null;
    }

    @Transactional
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody DeliveryAddressDto json) {

    }

    @Transactional
    @PutMapping("/{uuid}")
    public void getById(@PathVariable("uuid") UUID uuid, @RequestBody DelivererDto delivererDto) {

    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void getById(@PathVariable("uuid") UUID uuid) {
        deliveryAddressService.delete(uuid);
    }
}
