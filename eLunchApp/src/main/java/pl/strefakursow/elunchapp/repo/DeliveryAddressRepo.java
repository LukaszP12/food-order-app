package pl.strefakursow.elunchapp.repo;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.strefakursow.elunchapp.model.DeliveryAddress;

import java.util.Optional;
import java.util.UUID;

public interface DeliveryAddressRepo extends JpaRepository<DeliveryAddress, Long> {
    Optional<DeliveryAddress> findByUuid(@NotNull UUID uuid);
}
