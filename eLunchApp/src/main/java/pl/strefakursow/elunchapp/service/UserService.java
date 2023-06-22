package pl.strefakursow.elunchapp.service;

import pl.strefakursow.elunchapp.DTO.UserDTO;
import pl.strefakursow.elunchapp.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDTO> getAll();

    void put(UUID uuid, UserDTO userDTO);

    void delete(UUID uuid);

    User getByUuid(UUID uuid);

    void validateNewOperation(UUID uuid, UserDTO userDTO);
}
