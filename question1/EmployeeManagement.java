package question1;
import java.util.*;
public class EmployeeManagement {
    ArrayList<Employee> employees;
    Scanner scanner = new Scanner(System.in);
    public EmployeeManagement() {
        employees = new ArrayList<Employee>();
    }

    public void insertEmployee() {

        System.out.println("Enter the number of employes you want to create :- ");
        int nm = scanner.nextInt();
        for(int i=0;i<nm;i++){
            System.out.println("Enter employee id: ");
            int id = scanner.nextInt();
            System.out.println("Enter employee name: ");
            String name = scanner.next();
            System.out.println("Enter employee Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Enter employee department: ");
            String department = scanner.next();
            Employee employee = new Employee(id,name,department,salary);
            employees.add(employee);
            System.out.println("Employee added successfully!");
        }
    }

    public void updateEmployee() {
        int id;
        String name;
        String department;
        double salary;
        System.out.println("Enter the id of the employee whose record you want to update :- ");
        id = scanner.nextInt();

        System.out.println("Enter employee name: ");
        name = scanner.next();
        System.out.println("Enter employee Salary: ");
        salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter employee department: ");
        department = scanner.nextLine();

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(name);
                employee.setDepartment(department);
                employee.setSalary(salary);
                System.out.println("Employee updated successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void deleteEmployee() {
        System.out.println("Enter the id of the employee who you want to delete :- ");
        int id = scanner.nextInt();
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            Employee employee = it.next();
            if (employee.getId() == id) {
                it.remove();
                System.out.println("Employee deleted successfully!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void searchEmployee() {
        System.out.println("Enter the id of the employee you want to search :- ");
        int id = scanner.nextInt();
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void displayAllEmployees() {
        Iterator<Employee> it = employees.iterator();
        while(it.hasNext()){
            Employee employee = it.next();
            System.out.println(employee.toString());
        }
    }
}
