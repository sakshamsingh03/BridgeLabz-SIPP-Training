import java.util.Scanner;

public class checkNumber {

	public static void main(String[] args) {
		// Taking the number input from the user 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int number = input.nextInt();
		// Check number is negative, positive or zero
		if(number < 0) {
			System.out.println("Negative");
		} else if(number > 0) {
			System.out.println("Positive");
		} else {
			System.out.println("Zero");
		}

	}

}
