package com.TypeConverter;

public class StringToLong implements Converter<String, Long> {

    @Override
    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        return sourceType == String.class && (targetType == Long.class  || targetType == long.class);
    }

    @Override
    public Long convert(String source) {
        return Long.parseLong(source);
    }
}
