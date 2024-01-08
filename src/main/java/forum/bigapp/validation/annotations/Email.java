package forum.bigapp.validation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java. lang.annotation.RetentionPolicy;
import java.lang.annotation. Target;
import forum.bigapp.validation.EmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
    String message() default "Invalid format email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
