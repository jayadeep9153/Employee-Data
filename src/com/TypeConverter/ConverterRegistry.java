package com.TypeConverter;
import java.util.*;

public class ConverterRegistry {
    static List<Converter<?, ?>> converters = new ArrayList<>();

    static{
        converters.add(new StringToInteger());
        converters.add(new StringToLong());
        converters.add(new StringToFloat());
        converters.add(new StringToDouble());
        converters.add(new StringToBoolean());
    }

    @SuppressWarnings("unchecked")
    public static <Source, Target> Converter<Source, Target> getConverter(Class<Source> sourceType, Class<Target> targetType){
        for(int i=0; i<converters.size();i++){
            Converter converter = converters.get(i);
            if(converter.canConvert(sourceType, targetType)){
                return (Converter<Source, Target>) converter;
            }
        }
        return null;
    }
}
