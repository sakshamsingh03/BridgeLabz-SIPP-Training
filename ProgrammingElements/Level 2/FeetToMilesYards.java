import java.util.Scanner;

public class FeetToMilesYards {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double feet;

        System.out.print("Enter distance in feet: ");
        feet = input.nextDouble();

        double yards = feet / 3;
        double miles = yards / 1760;

        System.out.println("The distance is " + feet + " feet, which is " + yards + " yards and " + miles + " miles");

        input.close();
    }
}
