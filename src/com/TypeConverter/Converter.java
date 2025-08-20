package com.TypeConverter;

public interface Converter<Source, Target> {
    Target convert(Source source);

    boolean canConvert(Class<?> sourceType, Class<?> targetType);
}
