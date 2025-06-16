import java.util.Scanner;

public class BonusOfEmployee {

	public static void main(String[] args) {
		// Taking the number input from the user 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the salary and year of service: ");
		double salary = input.nextDouble();
		double year = input.nextDouble();
		if(year > 5) {
			// Calculating bonus amount
			double bonus = (salary * (5d/100d));
			// Printing result
			System.out.println("The bonus amount is: " + bonus);
		}

	}

}
