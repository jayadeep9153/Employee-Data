package com.TypeConverter;

public class StringToBoolean implements Converter<String, Boolean> {
    @Override
    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        return sourceType == String.class && (targetType == Boolean.class || targetType == boolean.class);
    }

    @Override
    public Boolean convert(String source) {
        return Boolean.parseBoolean(source);
    }
}
