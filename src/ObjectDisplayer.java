import java.util.*;
import java.lang.reflect.*;

public class ObjectDisplayer {
    public static void display(List<?> objects){
        if(objects == null || objects.isEmpty()){
            System.out.println("Empty List");
            return;
        }

        Class<?> classMethods = objects.get(0).getClass();
        Method[] methods = classMethods.getDeclaredMethods();

        List<Method> annotatedMethods = new ArrayList<>();
        List<String> headers = new ArrayList<>();

        for(Method method : methods){
            if(method.isAnnotationPresent(EmployeeAnnotation.class)){
                EmployeeAnnotation employeeAnnotation = method.getAnnotation(EmployeeAnnotation.class);
                headers.add(employeeAnnotation.fieldName());
                annotatedMethods.add(method);
            }
        }

        for (String header : headers) {
            System.out.printf("%-17s", header);
        }

        System.out.println();

        System.out.println();

        for (Object obj : objects) {
            for (Method method : annotatedMethods) {
                try {
                    Object value = method.invoke(obj);
                    System.out.printf("%-17s", value);
                } catch (Exception e) {
                    System.out.println("Employee class methods1" +
                            " error");
                }
            }
            System.out.println();
        }
    }
}
