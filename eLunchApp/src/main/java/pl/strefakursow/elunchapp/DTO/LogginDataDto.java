package pl.strefakursow.elunchapp.DTO;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import net.karneim.pojobuilder.GeneratePojoBuilder;

@Embeddable
@GeneratePojoBuilder
public class LogginDataDto {

    @Size(min = 3)
    private String string;

    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$")
    private String password;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
