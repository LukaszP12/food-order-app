package pl.strefakursow.elunchapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;

@Embeddable
@GeneratePojoBuilder
public class CompanyDataDto {

    public static class View {
        public interface Basic { }
        public interface Extended extends Basic { }
    }

    @JsonView(View.Basic.class)
    @NotNull
    private String name;

    @JsonView(View.Extended.class)
    @Embedded
    @NotNull
    private AddressDto addressDto;

    @JsonView(View.Extended.class)
    @NotNull
    private String NIP;

    @JsonView(View.Extended.class)
    @NotNull
    private String REGON;

    @JsonView(View.Extended.class)
    @NotNull
    private String phone;

    @JsonView(View.Extended.class)
    @NotNull
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDto getAddress() {
        return addressDto;
    }

    public void setAddress(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getREGON() {
        return REGON;
    }

    public void setREGON(String REGON) {
        this.REGON = REGON;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
