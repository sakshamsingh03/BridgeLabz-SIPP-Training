import java.util.Scanner;

public class OddEvenForIteration {

	public static void main(String[] args) {
		// Taking the number input from the user 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int number = input.nextInt();
		if(number > 0) {
			for(int i = 1; i <= number; i++) {
				if(i % 2 == 0) {
					System.out.println("Number is even: " + i);
				} else {
					System.out.println("Number is odd: " + i);
				}
			}
		}

	}

}
