package pl.strefakursow.elunchapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.strefakursow.elunchapp.model.OperationEvidence;
import pl.strefakursow.elunchapp.model.User;

import java.math.BigDecimal;

public interface OperationEvidenceRepo extends JpaRepository<OperationEvidence, Long> {

    @Query("SELECT COALESCE(SUM(CASE " +
            "WHEN e.type = pl.strefakursow.elunchapp.model.enums.EvidenceType.DEPOSIT THEN e.amount" +
            "WHEN e.type = pl.strefakursow.elunchapp.model.enums.EvidenceType.WITHDRAW " +
            "or e.type = pl.strefakursow.elunchapp.model.enums.EvidenceType.PAYMENT THEN -e.amount" +
            "ELSE 0 " +
            "END" +
            "),0) from OperationEvidence e where e.user = :user")
    BigDecimal getUserAccountBalance(@Param("user") User user);

}
