package pl.strefakursow.elunchapp.repo;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.strefakursow.elunchapp.model.Ingredient;

import java.util.Optional;
import java.util.UUID;

public interface IngredientRepo extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByUuid(@NotNull UUID uuid);
}
