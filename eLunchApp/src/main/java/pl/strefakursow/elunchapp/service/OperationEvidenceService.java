package pl.strefakursow.elunchapp.service;

import pl.strefakursow.elunchapp.model.OperationEvidence;
import pl.strefakursow.elunchapp.model.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface OperationEvidenceService {
    List<OperationEvidence> getAll();

    void add(OperationEvidence operationEvidence);

    void delete(OperationEvidence operationEvidence);

    BigDecimal getUserAccountBalance(User user);

    BigDecimal getAccountBalanceAfterOperation(OperationEvidence operationEvidence);
}
