package pl.strefakursow.elunchapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.elunchapp.model.enums.Archive;

import java.util.List;
import java.util.UUID;

@GeneratePojoBuilder
public class RestaurantDto {

    public static class View {
        public interface Basic {}
        public interface Extended extends Basic { }
    }

    @JsonView(View.Basic.class)
    @NotNull
    private UUID uuid;

    @NotBlank
    private String name;

    @NotNull
    @Embedded
    private LogginDataDto logginData;

    @NotNull
    @Embedded
    private CompanyDataDto companyDataDto;

    @NotNull
    @Size(max = 7)
    private List<OpenTimeDto> openTimeDtos;

    @NotNull
    @Size(max = 7)
    private List<OrderDto> orderDtos;

    @NotNull
    @Size(max = 7)
    private List<MenuItemDto> menuItemDtos;

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

    public LogginDataDto getLogginData() {
        return logginData;
    }

    public void setLogginData(LogginDataDto logginData) {
        this.logginData = logginData;
    }

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }

}
