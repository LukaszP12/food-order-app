package pl.strefakursow.elunchapp.DTO;

import jakarta.persistence.Embeddable;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import pl.strefakursow.elunchapp.validator.PeriodConstraint;

import javax.annotation.Nullable;
import java.time.LocalDateTime;

@PeriodConstraint
@Embeddable
@GeneratePojoBuilder
public class PeriodDTO {

    public static class View {
        public interface Basic { }
        public interface Extended extends PeriodDTO.View.Basic { }
    }

    @Nullable
    private LocalDateTime begin;

    @Nullable
    private LocalDateTime end;

    @Nullable
    public LocalDateTime getBegin() {
        return begin;
    }

    public void setBegin(@Nullable LocalDateTime begin) {
        this.begin = begin;
    }

    @Nullable
    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(@Nullable LocalDateTime end) {
        this.end = end;
    }
}
