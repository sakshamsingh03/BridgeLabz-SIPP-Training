public class EmployeeRecords {
    public int employeeID;
    protected String department;
    private double salary;

    public EmployeeRecords(int id, String dept, double salary) {
        this.employeeID = id;
        this.department = dept;
        this.salary = salary;
    }

    public void updateSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    public Manager(int id, String dept, double salary) {
        super(id, dept, salary);
    }

    public void showDetails() {
        System.out.println("ID: " + employeeID + ", Dept: " + department);
    }
}
