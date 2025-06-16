import java.util.Scanner;

public class PowerOfNumber2 {

	public static void main(String[] args) {
		// Taking the input from the user 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number and power to calculate the power of a number: ");
		int number = input.nextInt();
		int power = input.nextInt();
		int result = 1;
		int counter = 0;
		while(counter < power) {
			result *= number;
			counter++;
		}
		// Printing power of a number
		System.out.println(result);

	}

}
