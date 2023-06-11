package pl.strefakursow.elunchapp.validator;

import pl.strefakursow.elunchapp.model.PeriodTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PeriodTimeConstraintValidator implements ConstraintValidator<PeriodTimeConstraint, PeriodTime> {

    @Override
    public void initialize(PeriodTimeConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(PeriodTime periodTime, ConstraintValidatorContext constraintValidatorContext) {
        try {
            return periodTime.getBegin() == null || periodTime.getEnd() == null || periodTime.getBegin().isBefore(periodTime.getEnd());
        } catch (Exception e) {
            return false;
        }
    }
}
