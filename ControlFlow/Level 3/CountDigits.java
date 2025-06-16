import java.util.Scanner;

public class CountDigits {

	public static void main(String[] args) {
		// Taking input from the user
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int number = input.nextInt();
		int count = 0;
		while(number != 0) {
			number = number / 10;
			count++;
		}
		System.out.println("The number of digits in the given number is: " + count);

	}

}
