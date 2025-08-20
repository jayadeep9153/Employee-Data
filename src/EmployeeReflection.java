import java.lang.*;
import java.lang.reflect.*;

public class EmployeeReflection {
    public static void main(String[] args){
        Class<?> employee = Employee.class;

        System.out.println("Employee class properties");
        System.out.println("-------------------------");
        Field[] fields = employee.getDeclaredFields();
        for(Field field : fields){
            String modifier = Modifier.toString(field.getModifiers());
            String type = field.getType().getSimpleName();
            String name = field.getName();
            System.out.println(modifier + " " + type  + " " + name);
        }

        System.out.println();

        System.out.println("Employee class methods");
        System.out.println("----------------------");
        Method[] employeeMethods = employee.getDeclaredMethods();
        for(Method method : employeeMethods){
            String modifier = Modifier.toString(method.getModifiers());
            String type = method.getReturnType().getSimpleName();
            String name = method.getName();
            Parameter[] parameters = method.getParameters();
            StringBuilder parameter = new StringBuilder();
//            for(int i=0; i<parameters.length; i++){
//                Parameter parameterString = parameters[i];
//                String parameterName = parameterString.getName();
//                String parameterType = parameterString.getType().getSimpleName();
//
//                parameter.append(parameterType + " " + parameterName);
//            }

            for(Parameter parameterString : parameters){
                String parameterType = parameterString.getType().getSimpleName();
                String parameterName = parameterString.getName();

                parameter.append(parameterType).append(" ").append(parameterName);
            }

//            for(Parameter parameter : parameters){
//                System.out.println(modifier + " " + type + " " + name + " " +
//                                    "(" +  parameter.getType().getSimpleName() +
//                                    " " + parameter.getName() + ")");
//            }
            System.out.println(modifier + " " + type   + " " + name + "(" + parameter + ")");
        }
    }
}
