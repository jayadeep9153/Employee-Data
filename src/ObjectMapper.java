import java.util.*;
import java.lang.reflect.*;
import com.TypeConverter.*;

public class ObjectMapper {
    public static <T> T mapToObject(Map<String, Object> data, Class<T> clazz) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();
        for(Map.Entry<String, Object> entry : data.entrySet()) {
            populateField(instance, entry.getKey(), entry.getValue());
        }
        return instance;
    }

    public static void populateField(Object obj, String key, Object value) throws Exception{
        if(key.contains(".")){
            String[] parts = key.split("\\.", 2);
            FieldMetaData newData = getFieldValue(obj, parts[0]);
            if(newData != null){
                Object nestedData = newData.getValue();
                if(nestedData == null){
                    nestedData = newData.getReturnType().getDeclaredConstructor().newInstance();
                    setFieldValue(obj, parts[0], nestedData);
                }
                populateField(nestedData, parts[1], value);
            }
            else {
                throw new IllegalArgumentException(parts[0] + " is not a valid field name in " + obj.getClass().getName());
            }
        }
        else {
            setFieldValue(obj, key, value);
        }
    }

    public static void setFieldValue(Object instance, String key, Object value) throws Exception {
        Class<?> clazz = instance.getClass();

        String setterName = "set" + key.substring(0, 1).toUpperCase() + key.substring(1);
        boolean mapDone = false;

        for(Method m : clazz.getDeclaredMethods()){
            if(m.getName().equals(setterName)){
                Class<?> targetType = m.getParameterTypes()[0];

                Converter converter = ConverterRegistry.getConverter(value.getClass(), targetType);
                Object finalValue = (converter != null) ? converter.convert(value) : value;

                m.invoke(instance, finalValue);
                mapDone = true;
            }
        }

        if(!mapDone){
            try{
                Field field = clazz.getDeclaredField(key);
                field.setAccessible(true);
                Class<?> targetType = field.getType();

                Converter converter = ConverterRegistry.getConverter(value.getClass(), targetType);
                Object finalValue = (converter != null) ? converter.convert(value) : value;

                field.set(instance, finalValue);
            } catch(NoSuchFieldException e){
                System.out.println("No such field");
            }
        }
    }

    public static FieldMetaData getFieldValue(Object obj, String key) throws Exception {
        String getterName = "get" + key.substring(0, 1).toUpperCase() + key.substring(1);

        for(Method m : obj.getClass().getDeclaredMethods()){
            if(m.getName().equals(getterName)){
                Class<?> returnType = m.getReturnType();
                Object value = m.invoke(obj);

                return new FieldMetaData(returnType, value);
            }
        }

        try {
            Field field = obj.getClass().getDeclaredField(key);
            field.setAccessible(true);
            Object value = field.get(obj);

            FieldMetaData newData = new FieldMetaData(field.getType(), value);
            return newData;
        } catch(NoSuchFieldException e){
            System.out.println("No such field");
        }
        return null;
    }

//    public static <T> void setNestedComponents(T instance, Map<String, Object> data, Class<T> clazz) throws Exception {
//        for(Map.Entry<String, Object> entry : data.entrySet()){
//            String key = entry.getKey();
//            Object value = entry.getValue();
//
//            if(key.contains(".")){
//                String[] parts = key.split("\\.");
//
//                Object currentObj = instance;
//                Class<?> currentClass = clazz;
//
//                for(int i=0; i<parts.length-1; i++){
//                    String part = parts[i];
//                    Field field = currentClass.getDeclaredField(part);
//                    field.setAccessible(true);
//
//                    Object nestedObject = field.get(currentObj);
//
//                    if(nestedObject == null){
//                        nestedObject = field.getType().getDeclaredConstructor().newInstance();
//                        field.set(currentObj, nestedObject);
//                    }
//
//                    currentObj = nestedObject;
//                    currentClass = field.getType();
//                }
//            }
//        }
//    }
}
