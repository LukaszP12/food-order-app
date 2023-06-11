package pl.strefakursow.elunchapp.DTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.elunchapp.model.enums.VatTax;

import java.math.BigDecimal;
import java.util.List;

@GeneratePojoBuilder
public class MenuItemDto {

    @NotBlank
    private String name;

    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @NotNull
    private BigDecimal nettoPrice;

    @NotNull
    @Enumerated(EnumType.STRING)
    private VatTax vatTax;

    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @NotNull
    private BigDecimal bruttoPrice;

    @NotNull
    @Size(min = 1)
    @ManyToMany
    private List<DishDto> dishDtos;

    @NotNull
    private RestaurantDto restaurantDto;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getNettoPrice() {
        return nettoPrice;
    }

    public void setNettoPrice(BigDecimal nettoPrice) {
        this.nettoPrice = nettoPrice;
    }

    public VatTax getVatTax() {
        return vatTax;
    }

    public void setVatTax(VatTax vatTax) {
        this.vatTax = vatTax;
    }

    public BigDecimal getBruttoPrice() {
        return bruttoPrice;
    }

    public void setBruttoPrice(BigDecimal bruttoPrice) {
        this.bruttoPrice = bruttoPrice;
    }

    public List<DishDto> getDishes() {
        return dishDtos;
    }

    public void setDishes(List<DishDto> dishDtos) {
        this.dishDtos = dishDtos;
    }

    public RestaurantDto getRestaurant() {
        return restaurantDto;
    }

    public void setRestaurant(RestaurantDto restaurantDto) {
        this.restaurantDto = restaurantDto;
    }
}
