import java.util.Scanner;

public class PowerOfNumber {

	public static void main(String[] args) {
		// Taking the input from the user 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number and power to calculate the power of a number: ");
		int number = input.nextInt();
		int power = input.nextInt();
		int result = 1;
		for(int i = 1; i <= power; i++) {
			result *= number;
		}
		// Printing power of a number
		System.out.println(result);

	}

}
