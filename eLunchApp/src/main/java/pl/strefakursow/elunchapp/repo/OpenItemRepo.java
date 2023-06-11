package pl.strefakursow.elunchapp.repo;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.strefakursow.elunchapp.model.OpenTime;

import java.util.Optional;
import java.util.UUID;

public interface OpenItemRepo extends JpaRepository<OpenTime, Long> {
    Optional<OpenTime> findByUuid(@NotNull UUID uuid);
}
