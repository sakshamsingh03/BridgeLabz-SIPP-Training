import java.util.Scanner;

public class FizzBuzz2 {

	public static void main(String[] args) {
		// Taking the number input from the user 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int number = input.nextInt();
		if(number > 0) {
			while(number > 0) {
				if((number % 3 == 0) && (number % 5 == 0)) {
					System.out.println("FizzBuzz");
				} else if(number % 3 == 0) {
					System.out.println("Fizz");
				} else if(number % 5 == 0) {
					System.out.println("Buzz");
				} else {
					System.out.println(number);
				}
				number--;
			}
		}

	}

}
