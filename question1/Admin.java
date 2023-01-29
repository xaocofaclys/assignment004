package question1;
import java.util.*;
public class Admin {
    public static void main(String[] args) {
        EmployeeManagement emgt = new EmployeeManagement();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Insert an employee");
            System.out.println("2. Update an employee");
            System.out.println("3. Delete an employee");
            System.out.println("4. Search for an employee");
            System.out.println("5. Display all employees");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    emgt.insertEmployee();
                    break;
                case 2:
                    emgt.updateEmployee();
                    break;
                case 3:
                    emgt.deleteEmployee();
                    break;
                case 4:
                    emgt.searchEmployee();
                    break;
                case 5:
                    emgt.displayAllEmployees();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        
    }
}
