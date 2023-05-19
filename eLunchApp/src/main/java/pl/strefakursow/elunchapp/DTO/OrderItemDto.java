package pl.strefakursow.elunchapp.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OrderItemDto {

    @NotNull
    @Min(1)
    private Integer quantity;

    @NotNull
    private MenuItemDto menuItemDto;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public MenuItemDto getMenuItem() {
        return menuItemDto;
    }

    public void setMenuItem(MenuItemDto menuItemDto) {
        this.menuItemDto = menuItemDto;
    }
}
