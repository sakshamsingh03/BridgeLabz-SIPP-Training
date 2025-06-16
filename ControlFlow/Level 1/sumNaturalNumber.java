import java.util.Scanner;

public class sumNaturalNumber {

	public static void main(String[] args) {
		// Taking the number input from the user 
		Scanner input = new Scanner(System.in);
		int sum1 = 0;
		System.out.println("Enter the number: ");
		int number = input.nextInt();
		if(number > 0) {
			int sum2 = number * (number + 1) / 2;
			for(int i = number; i > 0; i--){
				sum1 += i;
			}
			if(sum1 == sum2) {
				System.out.println("The given number is a natural number and its sum is: " + sum1);
			} else {
				System.out.println("The given number is not a natural number.");
			}
		} else {
			System.out.println("The given number is not a natural number.");
		}

	}

}
