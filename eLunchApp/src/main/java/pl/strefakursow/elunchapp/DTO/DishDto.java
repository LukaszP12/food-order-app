package pl.strefakursow.elunchapp.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class DishDto {

    @NotNull
    @Min(1)
    private Integer quantity;

    @NotNull
    private ProductDto productDto;

    @Nullable
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
