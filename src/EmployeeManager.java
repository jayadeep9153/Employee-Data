import java.util.*;

public class EmployeeManager {

    private List<Employee> employees = new ArrayList<Employee>();
    private int lastId = 1;

    public List<Employee> getAll() {
        return Collections.unmodifiableList(employees);
    }


    public Employee getEmployee(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                return employees.get(i);
            }
        }
        return null;
    }

    public void addEmployee(Employee employee) {
        employee.setId(lastId++);
        employees.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employee = getEmployee(id);
        if(employee != null) {
            employees.remove(employee);
            System.out.println("Employee with id " + id + " removed");
        }
        else {
            throw new IllegalArgumentException("Employee with id " + id + " does not exist");
        }
    }
}
