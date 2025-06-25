import java.util.Scanner;
public class Circle {
    private double radius;
    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }
    // Method to calculate area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    // Method to calculate circumference
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
    public void displayDetails() {
        System.out.printf("Radius: %.2f\n", radius);
        System.out.printf("Area: %.2f\n", calculateArea());
        System.out.printf("Circumference: %.2f\n", calculateCircumference());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double inputRadius = scanner.nextDouble();
        Circle circle = new Circle(inputRadius);
        circle.displayDetails();
    }
}