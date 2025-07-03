import java.util.*;

// Interface: Department
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

// Abstract Class: Employee
abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        setBaseSalary(baseSalary);
    }

    // Encapsulation
    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary cannot be negative.");
        }
        this.baseSalary = baseSalary;
    }

    protected void setDepartment(String department) {
        this.department = department;
    }

    protected String getDepartment() {
        return department;
    }

    // Concrete Method
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Department: " + department);
    }

    // Abstract Method
    public abstract double calculateSalary();
}

// FullTimeEmployee
class FullTimeEmployee extends Employee implements Department {
    private double fixedBonus;

    public FullTimeEmployee(String employeeId, String name, double baseSalary, double fixedBonus) {
        super(employeeId, name, baseSalary);
        this.fixedBonus = fixedBonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + fixedBonus;
    }

    @Override
    public void assignDepartment(String departmentName) {
        setDepartment(departmentName);
    }

    @Override
    public String getDepartmentDetails() {
        return "Full-Time Department: " + getDepartment();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Fixed Bonus: $" + fixedBonus);
        System.out.printf("Total Salary: $%.2f%n", calculateSalary());
        System.out.println(getDepartmentDetails());
    }
}

// PartTimeEmployee
class PartTimeEmployee extends Employee implements Department {
    private int workHours;
    private double hourlyRate;

    public PartTimeEmployee(String employeeId, String name, double hourlyRate, int workHours) {
        super(employeeId, name, 0); // base salary is calculated
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * workHours;
    }

    @Override
    public void assignDepartment(String departmentName) {
        setDepartment(departmentName);
    }

    @Override
    public String getDepartmentDetails() {
        return "Part-Time Department: " + getDepartment();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Work Hours: " + workHours);
        System.out.printf("Total Salary: $%.2f%n", calculateSalary());
        System.out.println(getDepartmentDetails());
    }
}

// Main Class
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees to add: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nAdding Employee " + (i + 1));
            System.out.print("Is this a Full-Time or Part-Time employee? (FT/PT): ");
            String type = sc.nextLine().trim().toUpperCase();

            System.out.print("Enter Employee ID: ");
            String empId = sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            if (type.equals("FT")) {
                System.out.print("Enter Base Salary: ");
                double baseSalary = sc.nextDouble();
                System.out.print("Enter Fixed Bonus: ");
                double bonus = sc.nextDouble();
                sc.nextLine(); // consume leftover newline

                FullTimeEmployee ft = new FullTimeEmployee(empId, name, baseSalary, bonus);
                System.out.print("Assign Department: ");
                String dept = sc.nextLine();
                ft.assignDepartment(dept);

                employees.add(ft);
            } 
            else if (type.equals("PT")) {
                System.out.print("Enter Hourly Rate: ");
                double hourlyRate = sc.nextDouble();
                System.out.print("Enter Work Hours: ");
                int hours = sc.nextInt();
                sc.nextLine(); // consume leftover newline

                PartTimeEmployee pt = new PartTimeEmployee(empId, name, hourlyRate, hours);
                System.out.print("Assign Department: ");
                String dept = sc.nextLine();
                pt.assignDepartment(dept);

                employees.add(pt);
            } 
            else {
                System.out.println("Invalid type. Skipping...");
            }
        }

        System.out.println("\n=== Employee Details ===");
        for (Employee emp : employees) {
            System.out.println("------------------------");
            emp.displayDetails();
        }

        sc.close();
    }
}
