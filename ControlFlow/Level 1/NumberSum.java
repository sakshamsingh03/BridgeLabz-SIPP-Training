import java.util.Scanner;

public class NumberSum {

	public static void main(String[] args) {
		// Taking the number input from the user 
		Scanner input = new Scanner(System.in);
		double total = 0.0;
		System.out.println("Enter the number: ");
		double number = input.nextDouble();
		// Calculating the sum of the numbers entered by the user
		// Exit the loop when user enters 0 or negative number
		while(true) {
			if(number == 0 || number < 0) {
				break;
			}
			total += number;
			number = input.nextDouble();
			
		}
		// Printing the sum of the numbers entered by the user
		System.out.println(total);

	}

}
