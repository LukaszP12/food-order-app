package pl.strefakursow.elunchapp.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.elunchapp.DTO.DelivererDto;
import pl.strefakursow.elunchapp.DTO.OrderDto;
import pl.strefakursow.elunchapp.model.Deliverer;
import pl.strefakursow.elunchapp.model.Order;
import pl.strefakursow.elunchapp.repo.DelivererRepo;
import pl.strefakursow.elunchapp.repo.OrderRepo;
import pl.strefakursow.elunchapp.utils.ConverterUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@CacheConfig(cacheNames = "deliverers")
public class DelivererServiceImpl implements DelivererService {
    private final DelivererRepo delivererRepo;
    private final OrderRepo orderRepo;

    public DelivererServiceImpl(DelivererRepo delivererRepo, OrderRepo orderRepo) {
        this.delivererRepo = delivererRepo;
        this.orderRepo = orderRepo;
    }

    @Cacheable(cacheNames = "deliverers")
    @Override
    public List<DelivererDto> getAll() {
        return delivererRepo.findAll().stream()
                .map(ConverterUtils::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void put(UUID uuid, DelivererDto delivererDto) {
        if (!Objects.equals(delivererDto.getUuid(), uuid)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

//        Deliverer deliverer = delivererRepo.findByUuid(delivererDto.getUuid())
//                .orElseGet(() -> newDeliverer(delivererDto.getUuid()));

        List<Order> orders = new ArrayList<>();
        if (delivererDto.getOrders() != null) {
            for (OrderDto o : delivererDto.getOrders()) {
                Order order = orderRepo.findByUuid(o.getUuid())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
                orders.add(order);
            }
        }

//        deliverer.setPersonalData(convert(delivererDto.getPersonalData()));
//        deliverer.setLoginData(convert(delivererDto.getLoginData()));
//        deliverer.setArchive(convert(delivererDto.getArchive()));
//        deliverer.setOrders(orders);
//
//        if (deliverer.getId() == null){
//            delivererRepo.save(deliverer);
//        }
    }

    @CacheEvict(cacheNames = "deliverers",allEntries = true)
    @Override
    public void delete(UUID uuid) {
        Deliverer deliverer = delivererRepo.findByUuid(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        delivererRepo.delete(deliverer);
    }

    @Override
    public Optional<DelivererDto> getByUuid(UUID uuid) {
        return delivererRepo.findByUuid(uuid).map(ConverterUtils::convert);
    }
}
