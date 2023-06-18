package pl.strefakursow.elunchapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
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
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.elunchapp.model.User;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@GeneratePojoBuilder
public class OrderDto {

    public static class View {
        public interface Basic { }
        public interface Extended extends View.Basic { }
    }
    public interface OrderValidation {}
    public interface OrderStatusValidation {}

    @JsonView(View.Basic.class)
    @NotNull
    private UUID uuid;

    @JsonView(View.Extended.class)
    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @Null(groups = OrderValidation.class)
    @NotNull
    private BigDecimal nettoPrice;

    @JsonView(View.Extended.class)
    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @NotNull
    private BigDecimal bruttoPrice;

    @JsonView(View.Extended.class)
    @Nullable
    private DiscountCodeDto discountCodeDto;

    @JsonView(View.Extended.class)
    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @NotNull
    private BigDecimal amountToPayBrutto;

    @JsonView(View.Extended.class)
    @Nullable
    private String note;

    @JsonView(View.Basic.class)
    @Null(groups = OrderValidation.class)
    @NotNull(groups = OrderStatusValidation.class)
    @Embedded
    private OrderStatusDto orderStatusDto;

    @JsonView(View.Extended.class)
    @NotNull
    private DeliveryAddressDto deliveryAddressDto;

    @JsonView(View.Extended.class)
    @NotNull
    @Size(min = 1)
    private List<OrderTimeDto> orderTimeDtos;

    @JsonView(View.Basic.class)
    @NotNull
    private UserDTO user;

    @JsonView(View.Basic.class)
    @NotNull
    private DelivererDto delivererDto;

    @JsonView(View.Basic.class)
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
