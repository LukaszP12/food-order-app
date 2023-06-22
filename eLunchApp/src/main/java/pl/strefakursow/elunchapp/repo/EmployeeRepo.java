package pl.strefakursow.elunchapp.repo;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.strefakursow.elunchapp.model.Employee;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Optional<Employee> findByUuid(@NotNull UUID uuid);
}
