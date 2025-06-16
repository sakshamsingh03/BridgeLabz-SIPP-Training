import java.util.Scanner;

public class YoungestAndTallest {

	public static void main(String[] args) {
		// Taking the input from the user 
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the age and height of Amar: ");
		int amarAge = input.nextInt();
		int amarHeight = input.nextInt();
		System.out.println("Enter the age and height of Akbar: ");
		int akbarAge = input.nextInt();
		int akbarHeight = input.nextInt();
		System.out.println("Enter the age and height of Anthony: ");
		int anthonyAge = input.nextInt();
		int anthonyHeight = input.nextInt();
		// Checking who is youngest
		if((amarAge < akbarAge) && (amarAge < anthonyAge)) {
			System.out.println("Amar is youngest.");
		} else if((akbarAge < amarAge) && (akbarAge < anthonyAge)) {
			System.out.println("Akbar is youngest.");
		} else {
			System.out.println("Anthony is youngest.");
		}
		// Checking who is tallest
		if((amarHeight > akbarHeight) && (amarHeight > anthonyHeight)) {
			System.out.println("Amar is tallest.");
		} else if((akbarHeight > amarHeight) && (akbarHeight > anthonyHeight)) {
			System.out.println("Akbar is tallest.");
		} else {
			System.out.println("Anthony is tallest.");
		}
		


	}

}
