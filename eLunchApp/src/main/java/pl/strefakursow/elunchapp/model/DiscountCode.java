package pl.strefakursow.elunchapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.elunchapp.DTO.PeriodDTO;
import pl.strefakursow.elunchapp.model.enums.DiscountUnit;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@GeneratePojoBuilder
@Entity
public class DiscountCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private UUID uuid;

    @NotBlank
    private String code;

    @Column(scale = 2, precision = 12)
    @Digits(integer = 10, fraction = 2)
    @Min(0)
    @NotNull
    private BigDecimal discount; // 152.25

    @NotNull
    @Enumerated(EnumType.STRING)
    private DiscountUnit discountUnit;

    @NotNull
    private PeriodDTO period;

    @Nullable
    @ManyToMany(mappedBy = "discountCodes")
    private List<User> users;

    @Nullable
    @ManyToMany(mappedBy = "discountCodes")
    private List<Restaurant> restaurants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public PeriodDTO getPeriod() {
        return period;
    }

    public void setPeriod(PeriodDTO period) {
        this.period = period;
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
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(@Nullable List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
