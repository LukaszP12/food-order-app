package pl.strefakursow.elunchapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.elunchapp.DTO.DeliveryAddressDto;
import pl.strefakursow.elunchapp.model.DeliveryAddress;
import pl.strefakursow.elunchapp.repo.DeliveryAddressRepo;
import pl.strefakursow.elunchapp.repo.UserRepo;
import pl.strefakursow.elunchapp.utils.ConverterUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    private final DeliveryAddressRepo deliveryAddressRepo;
    private UserRepo userRepo;

    @Autowired
    public DeliveryAddressServiceImpl(DeliveryAddressRepo deliveryAddressRepo, UserRepo userRepo) {
        this.deliveryAddressRepo = deliveryAddressRepo;
        this.userRepo = userRepo;
    }

    @Cacheable(cacheNames = "delivereryAddresses")
    @Override
    public List<DeliveryAddressDto> getAll() {
        return deliveryAddressRepo.findAll().stream()
                .map(ConverterUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void put(UUID uuid, DeliveryAddressDto deliveryAddressDto) {

    }

    @CacheEvict(cacheNames = "delivereryAddresses", allEntries = true)
    @Override
    public void delete(UUID uuid) {
        DeliveryAddress deliveryAddress = deliveryAddressRepo.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        deliveryAddressRepo.delete(deliveryAddress);
    }

    @Override
    public Optional<DeliveryAddressDto> getByUuid(UUID uuid) {
        return Optional.empty();
    }
}
