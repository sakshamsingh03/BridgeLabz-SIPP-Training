import java.util.Scanner;

public class RunningRoundsCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double TARGET_DISTANCE = 5000; // 5 km in meters
        
        // Get triangle sides input
        System.out.print("Enter length of side 1 (in meters): ");
        double side1 = sc.nextDouble();
        
        System.out.print("Enter length of side 2 (in meters): ");
        double side2 = sc.nextDouble();
        
        System.out.print("Enter length of side 3 (in meters): ");
        double side3 = sc.nextDouble();
        
        // Calculate perimeter of the triangle
        double perimeter = side1 + side2 + side3;
        
        // Calculate number of rounds needed to complete 5 km
        double rounds = TARGET_DISTANCE / perimeter;
        
        // Round up to the nearest whole number since partial rounds don't count
        int fullRounds = (int) Math.ceil(rounds);
        
        // Display results
        System.out.printf("The total number of rounds the athlete will run is %d to complete 5 km", fullRounds);
        
    }
}