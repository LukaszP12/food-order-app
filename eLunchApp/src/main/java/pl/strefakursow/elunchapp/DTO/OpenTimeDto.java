package pl.strefakursow.elunchapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.elunchapp.model.enums.DayOfWeek;

import java.util.UUID;

@GeneratePojoBuilder
public class OpenTimeDto {

    public static class View {
        public interface Basic { }
        public interface Extended extends Basic { }
    }

    @JsonView(View.Basic.class)
    @NotNull
    private UUID uuid;

    @JsonView(View.Extended.class)
    @NotNull
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @JsonView(View.Extended.class)
    @NotNull
    @Enumerated(EnumType.STRING)
    private PeriodTimeDto periodTimeDto;

    @JsonView(View.Extended.class)
    @NotNull
    private RestaurantDto restaurantDto;

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public PeriodTimeDto getPeriodTime() {
        return periodTimeDto;
    }

    public void setPeriodTime(PeriodTimeDto periodTimeDto) {
        this.periodTimeDto = periodTimeDto;
    }

    public RestaurantDto getRestaurant() {
        return restaurantDto;
    }

    public void setRestaurant(RestaurantDto restaurantDto) {
        this.restaurantDto = restaurantDto;
    }

}
