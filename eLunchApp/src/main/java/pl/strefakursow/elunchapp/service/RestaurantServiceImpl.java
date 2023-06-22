package pl.strefakursow.elunchapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.elunchapp.DTO.RestaurantDto;
import pl.strefakursow.elunchapp.model.Restaurant;
import pl.strefakursow.elunchapp.model.User;
import pl.strefakursow.elunchapp.repo.RestaurantRepo;
import pl.strefakursow.elunchapp.utils.ConverterUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepo restaurantRepo;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepo restaurantRepo) {
        this.restaurantRepo = restaurantRepo;
    }

    @Override
    public List<RestaurantDto> getAll() {
        return restaurantRepo.findAll().stream()
                .map(ConverterUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void put(UUID uuid, RestaurantDto restaurantDto) {

    }

    @Override
    public void delete(UUID uuid) {
        Restaurant restaurant = restaurantRepo.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        restaurantRepo.delete(restaurant);
    }

    @Override
    public Optional<RestaurantDto> getByUuid(UUID uuid) {
        return Optional.empty();
    }
}
