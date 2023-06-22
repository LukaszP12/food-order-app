package pl.strefakursow.elunchapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import java.util.UUID;

@GeneratePojoBuilder
public class OrderItemDto {

    public static class View {
        public interface Basic { }
        public interface Extended extends Basic { }
    }

    @JsonView(View.Basic.class)
    @NotNull
    private UUID uuid;

    @JsonView(View.Basic.class)
    @NotNull
    @Min(1)
    private Integer quantity;

    @JsonView(View.Basic.class)
    @NotNull
    private MenuItemDto menuItemDto;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public MenuItemDto getMenuItemDto() {
        return menuItemDto;
    }

    public void setMenuItemDto(MenuItemDto menuItemDto) {
        this.menuItemDto = menuItemDto;
    }
}
