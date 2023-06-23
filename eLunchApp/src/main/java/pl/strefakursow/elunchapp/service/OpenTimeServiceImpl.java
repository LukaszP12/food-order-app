package pl.strefakursow.elunchapp.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.elunchapp.DTO.OpenTimeDto;
import pl.strefakursow.elunchapp.model.OpenTime;
import pl.strefakursow.elunchapp.model.OpenTimeBuilder;
import pl.strefakursow.elunchapp.model.Restaurant;
import pl.strefakursow.elunchapp.repo.OpenTimeRepo;
import pl.strefakursow.elunchapp.repo.RestaurantRepo;
import pl.strefakursow.elunchapp.utils.ConverterUtils;

import java.util.List;
import java.util.Objects;
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
        if (!Objects.equals(openTimeDto.getUuid(), uuid)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Restaurant restaurant = restaurantRepo.findByUuid(openTimeDto.getRestaurantDto().getUuid())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        OpenTime openTime = openTimeRepo.findByUuid(openTimeDto.getUuid())
                .orElseGet(() -> newOpenTime(uuid, restaurant));

        if (!Objects.equals(openTime.getRestaurant().getUuid(), openTimeDto.getRestaurantDto().getUuid())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        openTime.setDayOfWeek(openTimeDto.getDayOfWeek());
        openTime.setPeriodTime(ConverterUtils.convert(openTimeDto.getPeriodTimeDto()));

        if (openTime.getId() == null) {
            openTimeRepo.save(openTime);
        }
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<OpenTimeDto> getByUuid(UUID uuid) {
        return Optional.empty();
    }

    private OpenTime newOpenTime(UUID uuid, Restaurant restaurant) {
        return new OpenTimeBuilder()
                .withUuid(uuid)
                .withRestaurant(restaurant)
                .build();
    }
}
