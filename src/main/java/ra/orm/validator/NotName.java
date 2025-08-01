package ra.orm.validator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NotNameConstraintValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotName {
    String message() default "Tên không được là Nguyễn Văn A";

    Class<?>[] groups() default {};

    Class<? extends javax.validation.Payload>[] payload() default {};
}
