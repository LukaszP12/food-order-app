package pl.strefakursow.elunchapp.repo;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.strefakursow.elunchapp.model.OrderItem;

import java.util.Optional;
import java.util.UUID;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
    Optional<OrderItem> findByUuid(@NotNull UUID uuid);
}
