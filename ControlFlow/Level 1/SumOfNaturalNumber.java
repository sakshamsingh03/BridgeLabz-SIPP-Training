import java.util.Scanner;

public class SumOfNaturalNumber {

	public static void main(String[] args) {
		// Taking the number input from the user 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int number = input.nextInt();
		int sum = 0;
		// Checking if the number is natural or not
		if(number > 0) {
			for(int i = number; i > 0; i--) {
				sum += i;
			}
			System.out.println("The sum of " + number + " natural numbers is " + sum);
		} else {
			System.out.println("The number " + number + " is not a natural number");
		}

	}

}
