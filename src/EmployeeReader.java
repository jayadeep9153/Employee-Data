import java.util.Scanner;

public class EmployeeReader {
    private Scanner sc = new Scanner(System.in);

    public Employee read() {
        try {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            return new Employee(0, name, age, department);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numbers for ID and Age.");
            return null;
        }
    }
}
