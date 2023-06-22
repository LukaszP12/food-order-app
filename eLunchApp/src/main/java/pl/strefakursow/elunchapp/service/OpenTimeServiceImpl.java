package pl.strefakursow.elunchapp.service;

import org.springframework.stereotype.Service;
import pl.strefakursow.elunchapp.DTO.OpenTimeDto;
import pl.strefakursow.elunchapp.repo.OpenTimeRepo;
import pl.strefakursow.elunchapp.repo.RestaurantRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OpenTimeServiceImpl implements OpenTimeService {
    private final OpenTimeRepo openTimeRepo;
    private final RestaurantRepo restaurantRepo;

    public OpenTimeServiceImpl(OpenTimeRepo openTimeRepo, RestaurantRepo restaurantRepo) {
        this.openTimeRepo = openTimeRepo;
        this.restaurantRepo = restaurantRepo;
    }

    @Override
    public List<OpenTimeDto> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, OpenTimeDto openTimeDto) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<OpenTimeDto> getByUuid(UUID uuid) {
        return Optional.empty();
    }
}
