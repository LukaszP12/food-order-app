package pl.strefakursow.elunchapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.elunchapp.DTO.UserDTO;
import pl.strefakursow.elunchapp.model.Deliverer;
import pl.strefakursow.elunchapp.model.User;
import pl.strefakursow.elunchapp.repo.UserRepo;
import pl.strefakursow.elunchapp.utils.ConverterUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepo.findAll().stream()
                .map(ConverterUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void put(UUID uuid, UserDTO userDTO) {

    }

    @Override
    public void delete(UUID uuid) {
        User user = userRepo.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        userRepo.delete(user);
    }

    @Override
    public User getByUuid(UUID uuid) {
        Optional<User> user = userRepo.findByUuid(uuid);
        return user.get();
    }

    @Override
    public void validateNewOperation(UUID uuid, UserDTO userDTO) {
        if (!Objects.equals(userDTO.getUuid(), uuid)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        userRepo.findByUuid(userDTO.getUuid())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
