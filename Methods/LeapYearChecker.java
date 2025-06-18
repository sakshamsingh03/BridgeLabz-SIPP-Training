import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Input a year from the user
        System.out.print("Enter a year: ");
        int year = input.nextInt();

        // Check if the year in the Gregorian calendar.
        if (year < 1582) {
            System.out.println("Leap year calculation is only valid for years 1582 and later.");
            input.close();
            return;
        }

        // Check if the year is a leap year
        if (isLeapYear(year)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }

        // Close the scanner
        input.close();
    }

    // Method to determine if a year is a leap year
    public static boolean isLeapYear(int year) {
        // A year is a leap year if it is divisible by 4,
        // but not divisible by 100, unless it is also divisible by 400.
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
