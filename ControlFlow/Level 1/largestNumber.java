import java.util.Scanner;

public class largestNumber {

	public static void main(String[] args) {
		// Taking three numbers input from the user 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter three numbers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();
		// Checking that which of the number is largest
		boolean check1 = (number1 > number2 && number1 > number3);
		boolean check2 = (number2 > number1 && number2 > number3);
		boolean check3 = (number3 > number2 && number3 > number1);
		// Printing the results
		System.out.println("Is the first number the largest? " + check1);
		System.out.println("Is the second number the largest? " + check2);
		System.out.println("Is the third number the largest? " + check3);

	}

}
