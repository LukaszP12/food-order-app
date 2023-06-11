package pl.strefakursow.elunchapp.repo;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.strefakursow.elunchapp.model.MenuItem;

import java.util.Optional;
import java.util.UUID;

public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {
    Optional<MenuItem> findByUuid(@NotNull UUID uuid);
}
