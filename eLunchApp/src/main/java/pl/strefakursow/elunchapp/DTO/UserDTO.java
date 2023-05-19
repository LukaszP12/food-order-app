package pl.strefakursow.elunchapp.DTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import pl.strefakursow.elunchapp.model.DeliveryAddress;
import pl.strefakursow.elunchapp.model.DiscountCode;
import pl.strefakursow.elunchapp.model.LogginData;
import pl.strefakursow.elunchapp.model.OperationEvidence;
import pl.strefakursow.elunchapp.model.Order;
import pl.strefakursow.elunchapp.model.PersonalData;
import pl.strefakursow.elunchapp.model.enums.Archive;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

@Entity
public class UserDTO {

    @NotNull
    @Embedded
    private PersonalDataDto personalData;

    @Nullable
    private List<DeliveryAddressDto> addresses;

    @NotNull
    @Embedded
    private LogginDataDto logginData;

    @Nullable
    private List<OrderDto> orders;

    @NotNull
    private List<OperationEvidenceDto> operationEvidences;

    @Nullable
    private List<DiscountCodeDto> discountCodes;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Archive archive;

    public PersonalDataDto getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalDataDto personalData) {
        this.personalData = personalData;
    }

    @Nullable
    public List<DeliveryAddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(@Nullable List<DeliveryAddressDto> addresses) {
        this.addresses = addresses;
    }

    public LogginDataDto getLogginData() {
        return logginData;
    }

    public void setLogginData(LogginDataDto logginData) {
        this.logginData = logginData;
    }

    @Nullable
    public List<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(@Nullable List<OrderDto> orders) {
        this.orders = orders;
    }

    public List<OperationEvidenceDto> getOperationEvidences() {
        return operationEvidences;
    }

    public void setOperationEvidences(List<OperationEvidenceDto> operationEvidences) {
        this.operationEvidences = operationEvidences;
    }

    @Nullable
    public List<DiscountCodeDto> getDiscountCodes() {
        return discountCodes;
    }

    public void setDiscountCodes(@Nullable List<DiscountCodeDto> discountCodes) {
        this.discountCodes = discountCodes;
    }

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }
}
