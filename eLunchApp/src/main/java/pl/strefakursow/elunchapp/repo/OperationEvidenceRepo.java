package pl.strefakursow.elunchapp.repo;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.strefakursow.elunchapp.model.OperationEvidence;

import java.util.Optional;
import java.util.UUID;

public interface OperationEvidenceRepo extends JpaRepository<OperationEvidence, Long> {
    Optional<OperationEvidence> findByUuid(@NotNull UUID uuid);
}
