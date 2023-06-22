package pl.strefakursow.elunchapp.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.elunchapp.DTO.DeliveryAddressDto;
import pl.strefakursow.elunchapp.DTO.DiscountCodeDto;
import pl.strefakursow.elunchapp.DTO.LogginDataDto;
import pl.strefakursow.elunchapp.DTO.OperationEvidenceDto;
import pl.strefakursow.elunchapp.DTO.PersonalDataDto;
import pl.strefakursow.elunchapp.DTO.UserDTO;
import pl.strefakursow.elunchapp.model.User;
import pl.strefakursow.elunchapp.service.UserService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping(path = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    interface UserListValidation extends UserDTO.View.Basic, PersonalDataDto.View.Basic {}
    interface UserView extends UserDTO.View.Basic,PersonalDataDto.View.Extended, LogginDataDto.View.Basic,
            DeliveryAddressDto.View.Basic, OperationEvidenceDto.View.Extended, DiscountCodeDto.View.Extended {}

    interface DataUpdateValidation extends Default, UserDTO.DataUpdateValidation {}
    interface NewOperationValidation extends Default, UserDTO.NewOperationValidation {}

    private final UserService userService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public UserController(UserService userService, ApplicationEventPublisher applicationEventPublisher) {
        this.userService = userService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping
    public List<UserDTO> get() {
        return userService.getAll();
    }

    @JsonView(UserView.class)
    @GetMapping("/{uuid}")
    public UserDTO get(@PathVariable UUID uuid) {
//        UserDTO userDTO = userService.getByUuid(uuid);
        return null;
    }

    @Transactional
    @Validated(DataUpdateValidation.class)
    @PutMapping("/{uuid}")
    public void put(@PathVariable UUID uuid, @RequestBody @Valid UserDTO json) {
        userService.put(uuid,json);
    }

    @Transactional
    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable UUID uuid) {
        userService.delete(uuid);
    }

    @Transactional
    @Validated(NewOperationValidation.class)
    @PostMapping("/{uuid}/new-operation")
    public void postOperation(@PathVariable UUID uuid, @RequestBody @Valid UserDTO json){
        userService.validateNewOperation(uuid,json);
    }

    @JsonView(UserView.class)
    @GetMapping("/{uuid}/delivery-address")
    public UserDTO getUserAddresses(@PathVariable UUID uuid){
//        UserDTO userDTO = userService.getByUuid(uuid)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//        return userDTO.getDeliveryAddress();
        return null;
    }
}
