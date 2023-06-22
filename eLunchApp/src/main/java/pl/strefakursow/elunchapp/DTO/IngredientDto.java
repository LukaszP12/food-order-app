package pl.strefakursow.elunchapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import java.util.UUID;

@GeneratePojoBuilder
public class IngredientDto {

    public static class View {
        public interface Basic {}
    }

    @JsonView(View.Basic.class)
    @NotNull
    private UUID uuid;

    @NotBlank
    private String name;

    @NotNull
    private Boolean isAllergen;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAllergen() {
        return isAllergen;
    }

    public void setAllergen(Boolean allergen) {
        isAllergen = allergen;
    }
}
