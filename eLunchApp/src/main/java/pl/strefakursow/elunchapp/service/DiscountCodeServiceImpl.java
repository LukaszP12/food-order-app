package pl.strefakursow.elunchapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.elunchapp.DTO.DiscountCodeDto;
import pl.strefakursow.elunchapp.model.DeliveryAddress;
import pl.strefakursow.elunchapp.repo.DiscountCodeRepo;
import pl.strefakursow.elunchapp.repo.RestaurantRepo;
import pl.strefakursow.elunchapp.repo.UserRepo;
import pl.strefakursow.elunchapp.utils.ConverterUtils;

import java.util.List;
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
        return deliveryAddressRepo.findAll().stream()
                .map(ConverterUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void put(UUID uuid, DiscountCodeDto discountCodeDto) {

    }

    @Override
    public void delete(UUID uuid) {
        DeliveryAddress deliveryAddress = deliveryAddressRepo.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        deliveryAddressRepo.delete(deliveryAddress);
    }

    @Override
    public Optional<DiscountCodeDto> getByUuid(UUID uuid) {
        return discountCodeRepo.findByUuid(uuid).map(ConverterUtils::convert);
    }
}
