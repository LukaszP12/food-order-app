package pl.strefakursow.elunchapp.DTO;

import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.elunchapp.model.enums.Archive;

import javax.annotation.Nullable;
import java.util.List;

@GeneratePojoBuilder
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
