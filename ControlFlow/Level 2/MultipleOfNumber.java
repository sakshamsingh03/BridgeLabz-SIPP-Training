import java.util.Scanner;

public class MultipleOfNumber {

	public static void main(String[] args) {
		// Taking the input from the user 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number between 1 to 100: ");
		int number = input.nextInt();
		for(int i = number; i >= 1; i--) {
			if((number) % i == 0) {
				System.out.println(i);
			}
		}
	}

}
