import java.util.Scanner;

class Height {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 

        double hcm;
        System.out.print("Enter your height in cm: ");
        hcm = input.nextDouble(); // Take input

        double totalinchs = hcm / 2.54; // Convert cm to inches
        int feet = (int) (totalinchs / 12); // Convert inches to feet
        double inchs = totalinchs % 12; // Remaining inches

        System.out.println("Your Height in cm is " + hcm + 
            " while in feet is " + feet + 
            " and inches is " + String.format("%.2f", inchs));
    }
}
