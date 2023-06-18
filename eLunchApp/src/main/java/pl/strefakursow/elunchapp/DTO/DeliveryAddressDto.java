package pl.strefakursow.elunchapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.elunchapp.model.User;

import javax.annotation.Nullable;
import java.util.UUID;

@GeneratePojoBuilder
public class DeliveryAddressDto {

    public static class View {
        public interface Basic { }
        public interface Extended extends Basic { }
    }

    @JsonView(View.Basic.class)
    @NotNull
    private UUID uuid;

    @JsonView(View.Basic.class)
    @Nullable
    private String description;

    @JsonView(View.Extended.class)
    @NotNull
    private String street;

    @JsonView(View.Extended.class)
    @NotNull
    private String streetNumber;

    @JsonView(View.Extended.class)
    @NotNull
    private String localNumber;

    @JsonView(View.Extended.class)
    @NotNull
    private String postcode;

    @JsonView(View.Extended.class)
    @NotNull
    private String city;

    @JsonView(View.Extended.class)
    @NotNull
    private String borough;

    @JsonView(View.Extended.class)
    @NotNull
    private String county;

    @JsonView(View.Extended.class)
    @Nullable
    private String state;

    @JsonView(View.Basic.class)
    @NotNull
    private User user;

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Nullable
    public String getState() {
        return state;
    }

    public void setState(@Nullable String state) {
        this.state = state;
    }
}
