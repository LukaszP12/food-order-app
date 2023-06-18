package pl.strefakursow.elunchapp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.elunchapp.model.enums.Archive;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

@GeneratePojoBuilder
public class RestaurantDto {

    public static class View {
        public interface Id {}
        public interface Basic extends Id {}
        public interface Extended extends Basic { }
    }
    public interface DataUpdateValidation {}

    @JsonView(View.Id.class)
    @NotNull
    private UUID uuid;

    @JsonView(View.Basic.class)
    @NotBlank
    private String name;

    @JsonView(View.Basic.class)
    @NotNull
    @Embedded
    private LogginDataDto logginDataDto;

    @JsonView(View.Extended.class)
    @NotNull
    @Embedded
    private CompanyDataDto companyDataDto;

    @JsonView(View.Extended.class)
    @NotNull
    @Size(max = 7)
    private List<OpenTimeDto> openTimeDtos;

    @JsonView(View.Extended.class)
    @Size(max = 7)
    @Nullable
    @Null(groups = DataUpdateValidation.class)
    private List<OrderDto> orderDtos;

    @JsonView(View.Extended.class)
    @Nullable
    @Null(groups = DataUpdateValidation.class)
    @Size(max = 7)
    private List<MenuItemDto> menuItemDtos;

    @JsonIgnore
    @NotNull
    private List<DiscountCodeDto> discountCodeDtos;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Archive archive;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LogginDataDto getLogginDataDto() {
        return logginDataDto;
    }

    public void setLogginDataDto(LogginDataDto logginDataDto) {
        this.logginDataDto = logginDataDto;
    }

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }

}
