package pl.strefakursow.elunchapp.DTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pl.strefakursow.elunchapp.model.User;
import pl.strefakursow.elunchapp.model.enums.DiscountUnit;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.List;

public class DiscountCodeDto {

    @NotBlank
    private String code;

    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @NotNull
    private BigDecimal discount; // 152.25

    @NotNull
    @Enumerated(EnumType.STRING)
    private DiscountUnit discountUnit;

    @Nullable
    private List<User> users;

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
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(@Nullable List<User> users) {
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
