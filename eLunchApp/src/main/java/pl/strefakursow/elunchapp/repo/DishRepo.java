package pl.strefakursow.elunchapp.repo;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.strefakursow.elunchapp.model.Dish;

import java.util.Optional;
import java.util.UUID;

public interface DishRepo extends JpaRepository<Dish, Long> {
    Optional<Dish> findByUuid(@NotNull UUID uuid);
}
