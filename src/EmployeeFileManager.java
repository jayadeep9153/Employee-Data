import java.io.*;
import java.util.*;

public class EmployeeFileManager{

    private List<Employee> employees = new ArrayList<>();
    private int lastId = 1;


    public EmployeeFileManager(){
        this.loadEmployees();
    }


    private void loadEmployees() {
//        List<Employee> employees = new ArrayList<>();
        try (FileInputStream fileInput = new FileInputStream("employee-data.ser");
             ObjectInputStream objInput = new ObjectInputStream(fileInput)){
            if(objInput.available() != -1) {
                this.employees = (List<Employee>) objInput.readObject();
            }

        }
        catch(EOFException e) {
            // expected
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
                throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveEmployees()  {
        try (FileOutputStream fileInput = new FileOutputStream("employee-data.ser");
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileInput)){
            objectOutput.writeObject(employees);
        } catch(IOException ioe){
            System.err.println("Error saving employees: " + ioe.getMessage());
        }
    }

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
        saveEmployees();
    }

    public void removeEmployee(int id) {
        Employee employee = getEmployee(id);
        if(employee != null) {
            employees.remove(employee);
            System.out.println("Employee with id " + id + " removed");
            saveEmployees();
        }
        else {
            throw new IllegalArgumentException("Employee with id " + id + " does not exist");
        }
    }
}
