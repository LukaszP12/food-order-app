package pl.strefakursow.elunchapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.elunchapp.DTO.DiscountCodeDto;
import pl.strefakursow.elunchapp.DTO.RestaurantDto;
import pl.strefakursow.elunchapp.DTO.UserDTO;
import pl.strefakursow.elunchapp.model.DiscountCode;
import pl.strefakursow.elunchapp.model.DiscountCodeBuilder;
import pl.strefakursow.elunchapp.model.Restaurant;
import pl.strefakursow.elunchapp.model.User;
import pl.strefakursow.elunchapp.repo.DiscountCodeRepo;
import pl.strefakursow.elunchapp.repo.RestaurantRepo;
import pl.strefakursow.elunchapp.repo.UserRepo;
import pl.strefakursow.elunchapp.utils.ConverterUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DiscountCodeServiceImpl implements DiscountCodeService {
    private final DiscountCodeRepo discountCodeRepo;
    private final UserRepo userRepo;
    private final RestaurantRepo restaurantRepo;

    @Autowired
    public DiscountCodeServiceImpl(DiscountCodeRepo discountCodeRepo, UserRepo userRepo, RestaurantRepo restaurantRepo) {
        this.discountCodeRepo = discountCodeRepo;
        this.userRepo = userRepo;
        this.restaurantRepo = restaurantRepo;
    }

    @Override
    public List<DiscountCodeDto> getAll() {
        return discountCodeRepo.findAll().stream()
                .map(ConverterUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void put(UUID uuid, DiscountCodeDto discountCodeDto) {
        if (!Objects.equals(discountCodeDto.getUuid(), uuid)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        List<User> users = new ArrayList<>();
        if (discountCodeDto.getUsersDto() != null) {
            for (UserDTO userDTO : discountCodeDto.getUsersDto()) {
                User user = userRepo.findByUuid(userDTO.getUuid())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
                users.add(user);
            }
        }

        List<Restaurant> restaurants = new ArrayList<>();
        if (discountCodeDto.getRestaurants() != null) {
            for (RestaurantDto restaurantDto : discountCodeDto.getRestaurants()) {
                Restaurant restaurant = restaurantRepo.findByUuid(restaurantDto.getUuid())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
                restaurants.add(restaurant);
            }
        }

        DiscountCode discountCode = discountCodeRepo.findByUuid(discountCodeDto.getUuid())
                .orElseGet(() -> newDiscountCode(uuid));

        discountCode.setCode(discountCodeDto.getCode());
        discountCode.setDiscount(discountCodeDto.getDiscount());
        discountCode.setDiscountUnit(discountCodeDto.getDiscountUnit());
        discountCode.setPeriod(discountCodeDto.getPeriod());
        discountCode.setUsers(users);
        discountCode.setRestaurants(restaurants);

        if (discountCode.getId() == null) {
            discountCodeRepo.save(discountCode);
        }
    }

    @Override
    public void delete(UUID uuid) {
        DiscountCode discountCode = discountCodeRepo.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        discountCodeRepo.delete(discountCode);
    }

    @Override
    public Optional<DiscountCodeDto> getByUuid(UUID uuid) {
        return discountCodeRepo.findByUuid(uuid).map(ConverterUtils::convert);
    }

    private DiscountCode newDiscountCode(UUID uuid) {
        return new DiscountCodeBuilder().withUuid(uuid).build();
    }
}
