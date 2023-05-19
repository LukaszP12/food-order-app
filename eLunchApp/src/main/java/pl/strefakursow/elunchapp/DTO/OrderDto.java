package pl.strefakursow.elunchapp.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import pl.strefakursow.elunchapp.model.User;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class OrderDto {

    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @NotNull
    private BigDecimal nettoPrice;

    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @NotNull
    private BigDecimal bruttoPrice;

    @Nullable
    private DiscountCodeDto discountCodeDto;

    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @NotNull
    private BigDecimal amountToPayBrutto;

    @Nullable
    @Lob
    private String note;

    @NotNull
    @Embedded
    private OrderStatusDto orderStatusDto;

    @NotNull
    @Size(min = 1)
    @OneToMany(mappedBy = "order")
    private List<OrderTimeDto> orderTimeDtos;

    @NotNull
    private User user;

    @NotNull
    private DelivererDto delivererDto;

    @NotNull
    private RestaurantDto restaurantDto;

    public BigDecimal getNettoPrice() {
        return nettoPrice;
    }

    public void setNettoPrice(BigDecimal nettoPrice) {
        this.nettoPrice = nettoPrice;
    }

    public BigDecimal getBruttoPrice() {
        return bruttoPrice;
    }

    public void setBruttoPrice(BigDecimal bruttoPrice) {
        this.bruttoPrice = bruttoPrice;
    }
}
