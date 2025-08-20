package com.TypeConverter;

public class StringToDouble implements Converter<String, Double> {
    @Override
    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        return sourceType == String.class && (targetType == Double.class  || targetType == double.class);
    }

    @Override
    public Double convert(String source) {
        return Double.parseDouble(source);
    }
}
