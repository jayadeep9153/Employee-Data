package com.TypeConverter;

public class StringToFloat implements Converter<String, Float> {
    @Override
    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        return sourceType == String.class && (targetType == Float.class || targetType == float.class);
    }

    @Override
    public Float convert(String source) {
        return Float.parseFloat(source);
    }
}
