import java.io.IOException;
import java.util.*;

public class Main {

    private static final String VIEW_EMPLOYEE = "View Employee";
    private static final String ADD_EMPLOYEE = "Add Employee";
    private static final String DELETE_EMPLOYEE = "Delete Employee";
    private static final String EXIT = "Exit";

    public static void main(String[] args) throws IOException {
        EmployeeReader reader = new EmployeeReader();
        EmployeeDisplayer displayer = new EmployeeDisplayer();
        EmployeeFileManager employeeManager = new EmployeeFileManager();

        Menu menu = new Menu(
            VIEW_EMPLOYEE,
            ADD_EMPLOYEE,
            DELETE_EMPLOYEE,
            EXIT
        );

        String selectedOption;

        do {
            selectedOption = menu.displayMenu();
            switch (selectedOption) {
                case VIEW_EMPLOYEE ->{
                    List<Employee> empData = employeeManager.getAll();
                    ObjectDisplayer.display(empData);
                }
                case ADD_EMPLOYEE -> {
                    Employee emp = reader.read();
                    if (emp != null) {
                        employeeManager.addEmployee(emp);
                        System.out.println("Employee added successfully");
                    }
                }
                case DELETE_EMPLOYEE -> {
                    if(employeeManager.getAll().isEmpty())  {
                        System.err.println("Employee list is empty");
                        continue;
                    }
                    System.out.print("Enter ID of employee to delete: ");
                    Scanner sc = new Scanner(System.in);
                    try {
                        int id = Integer.parseInt(sc.nextLine());
                        employeeManager.removeEmployee(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        } while (!selectedOption.equals(EXIT));

        System.out.println("Program exited.");
    }
}
