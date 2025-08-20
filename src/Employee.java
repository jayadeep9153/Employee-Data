import java.io.Serial;
import java.io.Serializable;

public class Employee implements Serializable {

    private int id;
    private String name;
    private int age;
    private String department;

    @Serial
    private static final long serialVersionUID = 1L;

    private User user;
    private Address address;

    public Employee() {
    }

    public Employee(int id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public void setId(int id) {
        this.id = id;
    }

    @EmployeeAnnotation(fieldName = "Id", type = "int")
    public int getId() {
        return this.id;
    }

    @EmployeeAnnotation(fieldName = "Name", type = "string")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @EmployeeAnnotation(fieldName = "Age", type = "int")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @EmployeeAnnotation(fieldName = "Department", type = "string")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + age + " " + department + " ";
    }
}
