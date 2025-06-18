import java.util.*;

class BMICalculator {

    // Method to calculate and classify BMI
    public static String calculateBMI(double weight, double heightInCm) {
        double heightInMeters = heightInCm / 100.0;
        double bmi = weight / (heightInMeters * heightInMeters);

        if (bmi <= 18.4) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 39.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Weight (in kg): ");
        double weight = sc.nextDouble();

        System.out.print("Height (in cm): ");
        double height = sc.nextDouble();

        String result = calculateBMI(weight, height);
        System.out.println("BMI Category: " + result);
    }
}
