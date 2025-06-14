import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double base, height;

        System.out.print("Enter base in inches: ");
        base = input.nextDouble();

        System.out.print("Enter height in inches: ");
        height = input.nextDouble();

        double areaInInches = 0.5 * base * height;
        double areaInCm = areaInInches * 6.4516; // 1 square inch = 6.4516 cm²

        System.out.println("Area of triangle is " + areaInInches + " square inches and " + areaInCm + " square centimeters");

        input.close();
    }
}
