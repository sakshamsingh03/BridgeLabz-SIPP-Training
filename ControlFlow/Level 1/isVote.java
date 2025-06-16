import java.util.Scanner;

public class isVote {

	public static void main(String[] args) {
		// Taking the number input from the user 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the age: ");
		int age = input.nextInt();
		if(age >= 18) {
			System.out.println("The person's age is " + age + " and can vote.");
		} else {
			System.out.println("The person's age is " + age + " and cannot vote.");
		}

	}

}
