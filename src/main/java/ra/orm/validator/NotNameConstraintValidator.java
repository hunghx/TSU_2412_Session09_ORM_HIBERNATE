package ra.orm.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNameConstraintValidator implements ConstraintValidator<NotName, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s == null || !s.equalsIgnoreCase("Nguyễn Văn A");
    }
}
