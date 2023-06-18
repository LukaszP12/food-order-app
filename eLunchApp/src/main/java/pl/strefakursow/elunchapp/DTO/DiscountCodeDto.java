package pl.strefakursow.elunchapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.elunchapp.model.User;
import pl.strefakursow.elunchapp.model.enums.DiscountUnit;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@GeneratePojoBuilder
public class DiscountCodeDto {

    public static class View {
        public interface Basic { }
        public interface Extended extends Basic { }
    }

    @JsonView(View.Basic.class)
    @NotNull
    private UUID uuid;

    @JsonView(View.Basic.class)
    @NotBlank
    private String code;

    @JsonView(View.Extended.class)
    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @NotNull
    private BigDecimal discount; // 152.25

    @JsonView(View.Extended.class)
    @NotNull
    @Enumerated(EnumType.STRING)
    private DiscountUnit discountUnit;

    @JsonView(View.Basic.class)
    @NotNull
    @Embedded
    private PeriodDto period;

    @JsonView(View.Extended.class)
    @Nullable
    private List<UserDTO> users;

    @JsonView(View.Extended.class)
    @Nullable
    private List<RestaurantDto> restaurantDtos;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public DiscountUnit getDiscountUnit() {
        return discountUnit;
    }

    public void setDiscountUnit(DiscountUnit discountUnit) {
        this.discountUnit = discountUnit;
    }

    @Nullable
    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(@Nullable List<UserDTO> users) {
        this.users = users;
    }

    @Nullable
    public List<RestaurantDto> getRestaurants() {
        return restaurantDtos;
    }

    public void setRestaurants(@Nullable List<RestaurantDto> restaurantDtos) {
        this.restaurantDtos = restaurantDtos;
    }
}
