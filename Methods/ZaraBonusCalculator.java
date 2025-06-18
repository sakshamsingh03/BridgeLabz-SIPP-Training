import java.util.Random;

public class ZaraBonusCalculator {

    // Step 1: Generate 2D array with old salary and years of service
    public static double[][] generateEmployeeData(int numEmployees) {
        Random rand = new Random();
        double[][] employeeData = new double[numEmployees][2]; // [salary, yearsOfService]

        for (int i = 0; i < numEmployees; i++) {
            int salary = rand.nextInt(50000) + 50000; // 5-digit salary from 50000 to 99999
            int years = rand.nextInt(11);             // 0 to 10 years of service
            employeeData[i][0] = salary;
            employeeData[i][1] = years;
        }
        return employeeData;
    }

    // Step 2: Calculate new salary and bonus
    public static double[][] calculateNewSalaryAndBonus(double[][] employeeData) {
        int numEmployees = employeeData.length;
        double[][] updatedData = new double[numEmployees][2]; // [newSalary, bonusAmount]

        for (int i = 0; i < numEmployees; i++) {
            double salary = employeeData[i][0];
            int years = (int) employeeData[i][1];

            double bonusPercent = (years > 5) ? 0.05 : 0.02;
            double bonus = salary * bonusPercent;
            double newSalary = salary + bonus;

            updatedData[i][0] = newSalary;
            updatedData[i][1] = bonus;
        }

        return updatedData;
    }

    // Step 3: Display results in a tabular format and total summaries
    public static void displayEmployeeBonusTable(double[][] oldData, double[][] newData) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;

        System.out.printf("%-10s %-12s %-15s %-15s %-10s\n",
                "EmpID", "OldSalary", "YearsOfService", "NewSalary", "Bonus");
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < oldData.length; i++) {
            double oldSalary = oldData[i][0];
            int years = (int) oldData[i][1];
            double newSalary = newData[i][0];
            double bonus = newData[i][1];

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonus += bonus;

            System.out.printf("%-10d ₹%-11.2f %-15d ₹%-14.2f ₹%-10.2f\n",
                    (i + 1), oldSalary, years, newSalary, bonus);
        }

        System.out.println("--------------------------------------------------------------");
        System.out.printf("Total      ₹%-11.2f %-15s ₹%-14.2f ₹%-10.2f\n",
                totalOldSalary, "", totalNewSalary, totalBonus);
    }

    // Main method
    public static void main(String[] args) {
        int numEmployees = 10;

        double[][] employeeData = generateEmployeeData(numEmployees);
        double[][] updatedData = calculateNewSalaryAndBonus(employeeData);
        displayEmployeeBonusTable(employeeData, updatedData);
    }
}
