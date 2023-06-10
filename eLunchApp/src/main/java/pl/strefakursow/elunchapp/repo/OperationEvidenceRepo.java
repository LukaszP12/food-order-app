package pl.strefakursow.elunchapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.strefakursow.elunchapp.model.OperationEvidence;

public interface OperationEvidenceRepo extends JpaRepository<OperationEvidence, Long> {
}
