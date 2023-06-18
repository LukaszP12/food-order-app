package pl.strefakursow.elunchapp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Embeddable;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.elunchapp.validator.PeriodTimeConstraint;

import javax.annotation.Nullable;
import java.time.LocalTime;

@PeriodTimeConstraint
@Embeddable
@GeneratePojoBuilder
public class PeriodTimeDto {

    public static class View {
        public interface Basic { }
    }

    @JsonView(View.Basic.class)
    @Nullable
    private LocalTime begin;

    @JsonView(View.Basic.class)
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
