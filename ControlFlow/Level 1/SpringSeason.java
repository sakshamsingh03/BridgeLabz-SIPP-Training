import java.util.Scanner;

public class SpringSeason {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the month and day: ");
		int month = input.nextInt();
		int day = input.nextInt();
		// Check the Season is Spring or Not
		if((month >= 3 && day >= 20) && (month <= 7  && day <= 20)){
			System.out.println("Its a Spring Season");
		} else {
			System.out.println("Not a Spring Season");
		}

	}

}
