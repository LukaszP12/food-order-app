package pl.strefakursow.elunchapp.repo;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.strefakursow.elunchapp.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> findByUuid(@NotNull UUID uuid);
}
