package pl.strefakursow.elunchapp.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import javax.annotation.Nullable;
import java.util.List;

@GeneratePojoBuilder
public class ProductDto {

    public static class View {
        public interface Basic { }
        public interface Extended extends ProductDto.View.Basic { }
    }

    @NotBlank
    private String name;

    @NotNull
    private List<IngredientDto> ingredientDtos;

    @Nullable
    private DishDto dishDto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredientDto> getIngredients() {
        return ingredientDtos;
    }

    public void setIngredients(List<IngredientDto> ingredientDtos) {
        this.ingredientDtos = ingredientDtos;
    }

    @Nullable
    public DishDto getDish() {
        return dishDto;
    }

    public void setDish(@Nullable DishDto dishDto) {
        this.dishDto = dishDto;
    }
}
