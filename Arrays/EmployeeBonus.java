import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int EMPLOYEE_COUNT = 10;
        final double BONUS_RATE_LONG_SERVICE = 0.05; // 5% for more than 5 years
        final double BONUS_RATE_SHORT_SERVICE = 0.02; // 2% for less than or equal to 5 years

        // Arrays to store employee data
        double[] salaries = new double[EMPLOYEE_COUNT];
        double[] yearsOfService = new double[EMPLOYEE_COUNT];
        double[] bonuses = new double[EMPLOYEE_COUNT];
        double[] newSalaries = new double[EMPLOYEE_COUNT];

        // Variables to hold totals
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        // Input loop for employee data
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            while (true) {
                System.out.print("Enter salary for employee " + (i + 1) + ": ");
                salaries[i] = input.nextDouble();
                if (salaries[i] < 0) {
                    System.out.println("Invalid salary. Please enter a positive number.");
                    continue;
                }

                System.out.print("Enter years of service for employee " + (i + 1) + ": ");
                yearsOfService[i] = input.nextDouble();
                if (yearsOfService[i] < 0) {
                    System.out.println("Invalid years of service. Please enter a non-negative number.");
                    continue;
                }

                break;
            }
            totalOldSalary += salaries[i];
        }

        // Bonus calculation loop
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            if (yearsOfService[i] > 5) {
                bonuses[i] = salaries[i] * BONUS_RATE_LONG_SERVICE;
            } else {
                bonuses[i] = salaries[i] * BONUS_RATE_SHORT_SERVICE;
            }
            newSalaries[i] = salaries[i] + bonuses[i]; // Calculate new salary

            totalBonus += bonuses[i]; // Calculate total bonus
            totalNewSalary += newSalaries[i]; // Calculate new salary
        }
        // Output results
        System.out.printf("Total Bonus Payout: %.2f%n", totalBonus);
        System.out.printf("Total Old Salary: %.2f%n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f%n", totalNewSalary);
        System.out.println("Employee Bonuses and New Salaries:");
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.printf("Employee %d: Bonus = %.2f, New Salary = %.2f%n",
                    (i + 1), bonuses[i], newSalaries[i]);
        }

        // Close the input stream
        input.close();
    }
}