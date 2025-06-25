import java.util.*;
public class Employee {
    private String name;
    private int id;
    private double salary;

    // Constructor
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: ₹" + salary);
    }

    // Main method to test the class
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee Name: " );
		String s=sc.nextLine();
		System.out.println("Enter Employee Salary: ₹");
		double sal=sc.nextDouble();
		System.out.println("Enter Employee ID: ");
		int eid=sc.nextInt();
        Employee emp = new Employee(s, eid, sal);

        emp.displayDetails();
    }
}