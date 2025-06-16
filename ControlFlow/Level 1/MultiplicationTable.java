import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {
		// Taking the number input from the user 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number between 6 to 9: ");
		int number = input.nextInt();
		for(int i = 1; i <= 10; i++) {
			System.out.println(number + " * " + i + " = " + number*i );
		}

	}

}
