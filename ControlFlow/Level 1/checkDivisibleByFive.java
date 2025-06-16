import java.util.Scanner;

public class checkDivisibleByFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int number = input.nextInt();
		boolean state = number % 5 == 0;
		System.out.println("Is the number " + number + " divisible by 5? " + state);

	}

}
