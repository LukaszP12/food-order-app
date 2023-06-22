package pl.strefakursow.elunchapp.repo;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.strefakursow.elunchapp.model.Restaurant;

import java.util.Optional;
import java.util.UUID;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByUuid(@NotNull UUID uuid);
}
