// Base class
class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: $" + salary);
    }
}

// Subclass: Manager
class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

// Subclass: Developer
class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Subclass: Intern
class Intern extends Employee {
    String schoolName;

    Intern(String name, int id, double salary, String schoolName) {
        super(name, id, salary);
        this.schoolName = schoolName;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("School Name: " + schoolName);
    }
}

// Main class to test
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee e1 = new Manager("Alice", 101, 90000, 5);
        Employee e2 = new Developer("Bob", 102, 80000, "Java");
        Employee e3 = new Intern("Charlie", 103, 20000, "State University");

        System.out.println("--- Employee Details ---");
        e1.displayDetails();
        System.out.println();
        e2.displayDetails();
        System.out.println();
        e3.displayDetails();
    }
}
