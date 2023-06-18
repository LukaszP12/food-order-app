package pl.strefakursow.elunchapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.elunchapp.model.enums.Archive;

import java.util.UUID;

@GeneratePojoBuilder
public class EmployeeDto {

    public static class View {
        public interface Id { }
        public interface Basic extends Id { }
        public interface Extended extends Basic { }
    }

    @JsonView(View.Basic.class)
    @NotNull
    private UUID uuid;

    @NotNull
    @Embedded
    private PersonalDataDto personalDataDto;

    @NotNull
    @Embedded
    private LogginDataDto loginData;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Archive archive;

    public PersonalDataDto getPersonalData() {
        return personalDataDto;
    }

    public void setPersonalData(PersonalDataDto personalDataDto) {
        this.personalDataDto = personalDataDto;
    }

    public LogginDataDto getLoginData() {
        return loginData;
    }

    public void setLoginData(LogginDataDto loginData) {
        this.loginData = loginData;
    }

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }
}
