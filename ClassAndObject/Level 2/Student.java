import java.util.Scanner;
public class Student {
    private String name;
    private int rollNumber;
    private double marks;
    // Constructor
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    // Method to calculate grade based on marks
    public String calculateGrade() {
        if (marks >= 90) {
            return "0";
        } else if (marks >= 80) {
            return "A+";
        } else if (marks >= 70) {
            return "A";
        } else if (marks >= 60) {
            return "B+";
        } else if (marks >= 50) {
            return "B";
        } else {
            return "F";
        }
    }
    // Method to display student details and grade
    public void displayReport() {
        System.out.println("\nStudent Report:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        System.out.print("Enter marks (0 - 100): ");
        double marks = scanner.nextDouble();
        Student student = new Student(name, rollNumber, marks);
        student.displayReport();
    }
}