package pl.strefakursow.elunchapp.DTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.elunchapp.model.enums.DayOfWeek;

@GeneratePojoBuilder
public class OpenTimeDto {

    @NotNull
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PeriodTimeDto periodTimeDto;

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
