package pl.strefakursow.elunchapp.DTO;

import jakarta.persistence.Embeddable;
import pl.strefakursow.elunchapp.validator.PeriodTimeConstraint;

import javax.annotation.Nullable;
import java.time.LocalTime;

@PeriodTimeConstraint
@Embeddable
public class PeriodTimeDto {

    @Nullable
    private LocalTime begin;

    @Nullable
    private LocalTime end;

    @Nullable
    public LocalTime getBegin() {
        return begin;
    }

    public void setBegin(@Nullable LocalTime begin) {
        this.begin = begin;
    }

    @Nullable
    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(@Nullable LocalTime end) {
        this.end = end;
    }
}
