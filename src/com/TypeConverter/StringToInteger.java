    package com.TypeConverter;

    public class StringToInteger implements Converter<String, Integer> {

        public boolean canConvert(Class<?> sourceType, Class<?> targetType){
            return sourceType == String.class &&  (targetType == Integer.class ||targetType == int.class);
        }

        @Override
        public Integer convert(String source) {
            return Integer.parseInt(source);
        }
    }
