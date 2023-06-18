package pl.strefakursow.elunchapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.checkerframework.framework.qual.NoDefaultQualifierForUse;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

@GeneratePojoBuilder
public class DishDto {

    public static class View {
        public interface Basic { }
        public interface Extended extends Basic { }
    }
    public interface DataUpdateValidation {}

    @JsonView(View.Basic.class)
    @NotNull
    private UUID uuid;

    @JsonView(View.Extended.class)
    @NotNull
    @Min(1)
    private Integer quantity;

    @JsonView(View.Extended.class)
    @NotNull
    private ProductDto productDto;

    @JsonView(View.Extended.class)
    @Nullable
    @Null(groups = DataUpdateValidation.class)
    private List<MenuItemDto> menuItemDtos;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductDto getProduct() {
        return productDto;
    }

    public void setProduct(ProductDto productDto) {
        this.productDto = productDto;
    }

    @Nullable
    public List<MenuItemDto> getMenuItems() {
        return menuItemDtos;
    }

    public void setMenuItems(@Nullable List<MenuItemDto> menuItemDtos) {
        this.menuItemDtos = menuItemDtos;
    }
}
