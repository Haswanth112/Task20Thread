import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmployeeManagementSystem {
    private List<Employee> employees;

    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void deleteEmployee(int employeeId) {
        employees.removeIf(e -> e.getId() == employeeId);
    }

    public List<Employee> listEmployees() {
        return employees;
    }

    public Optional<Employee> findEmployeeById(int employeeId) {
        return employees.stream()
                .filter(e -> e.getId() == employeeId)
                .findFirst();
    }

    public List<Employee> searchEmployeesByName(String name) {
        return employees.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Employee> sortEmployeesById() {
        return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getId))
                .collect(Collectors.toList());
    }

    public List<Employee> sortEmployeesByName() {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }
}

public class EmployeeSearch{
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. List Employees");
            System.out.println("4. Search Employees by Name");
            System.out.println("5. Sort Employees by ID");
            System.out.println("6. Sort Employees by Name");
            System.out.println("7 Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter employee name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    ems.addEmployee(new Employee(id, name));
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    ems.deleteEmployee(deleteId);
                    System.out.println("Employee deleted successfully");
                    break;

                case 3:
                    System.out.println("List of Employees:");
                    ems.listEmployees().forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Enter employee name to search: ");
                    scanner.nextLine();
                    String searchName = scanner.nextLine();
                    ems.searchEmployeesByName(searchName).forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Sort Employees by ID:");
                    ems.sortEmployeesById().forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("Sort Employees by Name:");
                    ems.sortEmployeesByName().forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
