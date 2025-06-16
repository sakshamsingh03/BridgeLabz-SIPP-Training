import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// Taking the number input from the user 
		Scanner input = new Scanner(System.in);
		int factorial = 1;
		System.out.println("Enter the number: ");
		int number = input.nextInt();
		// Checking number is positive or negative
		if(number > 0) {
			// Calculating factorial
			while(number > 0) {
				factorial *= number;
				number--;
			}
			// Printing result
			System.out.println("Factorial: " + factorial);
		} else if(number == 0) {
			System.out.println("Factorial: " + number);
		}else {
			System.out.println("The number entered is not positive.");
		}

	}

}
