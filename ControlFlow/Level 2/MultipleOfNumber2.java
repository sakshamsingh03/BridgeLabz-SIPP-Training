import java.util.Scanner;

public class MultipleOfNumber2 {

	public static void main(String[] args) {
		// Taking the input from the user 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number between 1 to 100: ");
		int number = input.nextInt();
		int counter = number-1;
		while(counter >= 1) {
			if((number) % counter == 0) {
				System.out.println(counter);
			}
			counter--;
		}
	}

}
