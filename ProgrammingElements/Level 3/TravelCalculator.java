import java.util.Scanner;

public class TravelCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get personal details
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter starting city: ");
        String fromCity = sc.nextLine();
        
        System.out.print("Enter via city: ");
        String viaCity = sc.nextLine();
        
        System.out.print("Enter destination city: ");
        String toCity = sc.nextLine();
        
        // Get distance inputs
        System.out.print("Enter distance from " + fromCity + " to " + viaCity + " (miles): ");
        double fromToVia = sc.nextDouble();
        
        System.out.print("Enter distance from " + viaCity + " to " + toCity + " (miles): ");
        double viaToFinalCity = sc.nextDouble();
        
        // Get time inputs
        System.out.print("Enter time taken from " + fromCity + " to " + viaCity + " (minutes): ");
        int timeFromToVia = sc.nextInt();
        
        System.out.print("Enter time taken from " + viaCity + " to " + toCity + " (minutes): ");
        int timeViaToFinalCity = sc.nextInt();
        
        // Calculate totals (converting miles to km)
        double totalDistanceKm = (fromToVia + viaToFinalCity) * 1.60934;
        int totalTimeMinutes = timeFromToVia + timeViaToFinalCity;
        
        // Display results
        System.out.printf("The Total Distance travelled by %s from %s to %s via %s is %.2f km " +
                         "and the Total Time taken is %d minutes",
                         name, fromCity, toCity, viaCity, totalDistanceKm, totalTimeMinutes);
 
    }
}