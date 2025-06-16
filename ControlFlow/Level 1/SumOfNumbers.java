import java.util.Scanner;

public class SumOfNumbers {

	public static void main(String[] args) {
		// Taking the number input from the user 
		Scanner input = new Scanner(System.in);
		double total = 0.0;
		System.out.println("Enter the number: ");
		double number = input.nextDouble();
		while(number > 0) {
			total += number;
			number = input.nextDouble();
			
		}
		System.out.println(total);

	}

}
