import java.util.Scanner;

public class TotalIncome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get salary input
        System.out.print("Enter your salary (INR): ");
        double salary = sc.nextDouble();
        
        // Get bonus input
        System.out.print("Enter your bonus (INR): ");
        double bonus = sc.nextDouble();
        
        // Calculate total income
        double totalIncome = salary + bonus;
        
        // Display results
        System.out.printf("The salary is INR %,.2f and the bonus is INR %,.2f.%n", salary, bonus);
        System.out.printf("Hence Total Income is INR %,.2f", totalIncome);
        
    }
}