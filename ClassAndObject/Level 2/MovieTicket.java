import java.util.Scanner;
public class MovieTicket {
    private String movieName;
    private String seatNumber;
    private double price;
    // Method to book a ticket
    public void bookTicket(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked successfully!");
    }
    // Method to display ticket details
    public void displayTicket() {
        System.out.println("\n--- Ticket Details ---");
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.printf("Price: ₹%.2f\n", price);
    }
    // Main method to test the system
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieTicket ticket = new MovieTicket();
        System.out.print("Enter movie name: ");
        String movie = scanner.nextLine();
        System.out.print("Enter seat number (e.g., A12): ");
        String seat = scanner.nextLine();
        System.out.print("Enter ticket price: ");
        double price = scanner.nextDouble();
        ticket.bookTicket(movie, seat, price);
        ticket.displayTicket();
    }
}