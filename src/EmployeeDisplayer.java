import java.util.*;

public class EmployeeDisplayer {
    public void displayEmployee(List<Employee> empData) {
        if (empData == null || empData.isEmpty()) {
            System.out.println("No employees found");
            return;
        }

        System.out.printf("%-5s%-18s%-5s%-10s%n", "ID", "Name", "Age", "Department");
        System.out.println("------------------------------------------");
        for (Employee emp : empData) {
            System.out.printf("%-5d%-18s%-5d%-10s%n",
                    emp.getId(),
                    emp.getName(),
                    emp.getAge(),
                    emp.getDepartment());
        }
    }
}
