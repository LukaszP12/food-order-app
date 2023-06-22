package pl.strefakursow.elunchapp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.elunchapp.model.enums.Archive;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

@GeneratePojoBuilder
public class UserDTO {

    public static class View {
        public interface Id {}
        public interface Basic extends Id {}
        public interface Extended extends Basic { }
    }
    public interface DataUpdateValidation {}
    public interface NewOperationValidation {}

    @JsonView(View.Id.class)
    @NotNull
    private UUID uuid;

    @JsonView(View.Basic.class)
    @NotNull
    @Embedded
    private PersonalDataDto personalData;

    @JsonView(View.Extended.class)
    @Nullable
    private List<DeliveryAddressDto> deliveryAddress;

    @JsonView(View.Extended.class)
    @NotNull
    @Embedded
    private LogginDataDto logginData;

    @JsonIgnore
    @Nullable
    @Null(groups = DataUpdateValidation.class)
    private List<OrderDto> orders;

    @JsonView(View.Extended.class)
    @NotNull
    @Size(max = 0,groups = DataUpdateValidation.class)
    @Size(min = 1,max = 1,groups = NewOperationValidation.class)
    private List<OperationEvidenceDto> operationEvidences;

    @JsonView(View.Extended.class)
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
        return deliveryAddress;
    }

    public void setAddresses(@Nullable List<DeliveryAddressDto> addresses) {
        this.deliveryAddress = addresses;
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
