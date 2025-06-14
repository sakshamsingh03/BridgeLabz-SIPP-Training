import java.util.Scanner;

public class Swapping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        
        // Swap the numbers using a temporary variable
        int temp = number1;
        number1 = number2;
        number2 = temp;
        
        // Display results
        System.out.println("The swapped numbers are " + number1 + " and " + number2);

    }
}