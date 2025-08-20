import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EmployeeAnnotation {
    String fieldName();
    String type();
}
