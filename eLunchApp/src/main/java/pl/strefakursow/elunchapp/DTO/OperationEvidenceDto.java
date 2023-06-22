package pl.strefakursow.elunchapp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.elunchapp.model.User;
import pl.strefakursow.elunchapp.model.enums.EvidenceType;

import java.math.BigDecimal;
import java.time.Instant;

@GeneratePojoBuilder
public class OperationEvidenceDto {

    public static class View {
        public interface Basic { }
        public interface Extended extends Basic { }
    }

    @JsonView(View.Basic.class)
    @NotNull
    private Instant date;

    @JsonView(View.Basic.class)
    @NotNull
    @Enumerated(EnumType.STRING)
    private EvidenceType evidenceType;

    @JsonView(View.Extended.class)
    @NotNull
    @Digits(integer = 10, fraction = 2)
    @Min(0)
    private BigDecimal amount;

    @JsonIgnore
    @NotNull
    private UserDTO user;

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public EvidenceType getEvidenceType() {
        return evidenceType;
    }

    public void setEvidenceType(EvidenceType evidenceType) {
        this.evidenceType = evidenceType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
