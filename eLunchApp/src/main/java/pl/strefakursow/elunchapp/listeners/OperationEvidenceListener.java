package pl.strefakursow.elunchapp.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import pl.strefakursow.elunchapp.DTO.UserDTO;
import pl.strefakursow.elunchapp.events.OperationEvidenceCreator;
import pl.strefakursow.elunchapp.model.OperationEvidence;
import pl.strefakursow.elunchapp.model.User;
import pl.strefakursow.elunchapp.repo.UserRepo;
import pl.strefakursow.elunchapp.service.OperationEvidenceService;
import pl.strefakursow.elunchapp.utils.ConverterUtils;

import java.math.BigDecimal;

@Component
public class OperationEvidenceListener {

    private final OperationEvidenceService operationEvidenceService;
    private final UserRepo userRepo;

    @Autowired
    public OperationEvidenceListener(OperationEvidenceService operationEvidenceService, UserRepo userRepo) {
        this.operationEvidenceService = operationEvidenceService;
        this.userRepo = userRepo;
    }

    @EventListener
    public void onAddOperation(OperationEvidenceCreator operationEvidenceCreator) {
        UserDTO userDTO = operationEvidenceCreator.getUserDTO();
        OperationEvidence operationEvidence = ConverterUtils.convert(userDTO.getOperationEvidences().stream().findFirst().orElseThrow());
        User user = userRepo.findByUuid(userDTO.getUuid()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        operationEvidence.setUser(user);

        validateAccountBalanceAfterOperation(operationEvidence);
        operationEvidenceService.add(operationEvidence);
    }

    private void validateAccountBalanceAfterOperation(OperationEvidence operationEvidence) {
        BigDecimal accountBalanceAfterOperation = operationEvidenceService.getAccountBalanceAfterOperation(operationEvidence);
        if (accountBalanceAfterOperation.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

}

