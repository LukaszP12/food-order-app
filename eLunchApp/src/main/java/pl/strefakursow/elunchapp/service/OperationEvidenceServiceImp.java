package pl.strefakursow.elunchapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.strefakursow.elunchapp.model.OperationEvidence;
import pl.strefakursow.elunchapp.model.User;
import pl.strefakursow.elunchapp.repo.OperationEvidenceRepo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OperationEvidenceServiceImp implements OperationEvidenceService {
    private final OperationEvidenceRepo operationEvidenceRepo;

    @Autowired
    public OperationEvidenceServiceImp(OperationEvidenceRepo operationEvidenceRepo) {
        this.operationEvidenceRepo = operationEvidenceRepo;
    }

    @Override
    public List<OperationEvidence> getAll() {
        return operationEvidenceRepo.findAll();
    }

    @Override
    public void add(OperationEvidence operationEvidence) {
        operationEvidenceRepo.save(operationEvidence);
    }

    @Override
    public void delete(OperationEvidence operationEvidence) {
        operationEvidenceRepo.delete(operationEvidence);
    }

    @Override
    public BigDecimal getUserAccountBalance(User user) {
        return operationEvidenceRepo.getUserAccountBalance(user);
    }

    @Override
    public BigDecimal getAccountBalanceAfterOperation(OperationEvidence operationEvidence) {
        BigDecimal balanceBefore = getUserAccountBalance(operationEvidence.getUser());
        BigDecimal balanceAfter = null;

        switch (operationEvidence.getEvidenceType()) {
            case WITHDRAW:
            case PAYMENT:
                balanceAfter = balanceBefore.subtract(operationEvidence.getAmount());
                break;
            case DEPOSIT:
                balanceAfter = balanceBefore.add(operationEvidence.getAmount());
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return balanceAfter;
    }
}
