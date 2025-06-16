import java.util.Scanner;

public class GreatestFactor2 {

	public static void main(String[] args) {
		// Taking the input from the user 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int greatestFactor = 1;
		int number = input.nextInt();
		int counter = number-1;
		while(counter > 1) {
			if(number % counter == 0) {
				greatestFactor = counter;
				break;
			}
			counter--;
		}
		System.out.println("Greatest Factor: " + greatestFactor);

	}

}
