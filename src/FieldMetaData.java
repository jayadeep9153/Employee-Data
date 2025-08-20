public class FieldMetaData {
    private Class<?> returnType;
    private Object value;

    public FieldMetaData(Class<?> returnType, Object value){
        this.returnType = returnType;
        this.value = value;
    }

    public Class<?> getReturnType() {
        return returnType;
    }

    public void setReturnType(Class<?> returnType) {
        this.returnType = returnType;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
