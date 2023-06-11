package pl.strefakursow.elunchapp.repo;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.strefakursow.elunchapp.model.DiscountCode;

import java.util.Optional;
import java.util.UUID;

public interface DiscountCodeRepo extends JpaRepository<DiscountCode, Long> {
    Optional<DiscountCode> findByUuid(@NotNull UUID uuid);
}
