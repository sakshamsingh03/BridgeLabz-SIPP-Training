import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        CinemaManager cm = new CinemaManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Movie\n2. Search Movie\n3. Display All\n4. Report\n5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter movie title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter showtime (HH:MM): ");
                        String time = sc.nextLine();
                        cm.addMovie(title, time);
                        break;
                    case 2:
                        System.out.print("Enter keyword to search: ");
                        String keyword = sc.nextLine();
                        cm.searchMovie(keyword);
                        break;
                    case 3:
                        cm.displayAllMovies();
                        break;
                    case 4:
                        System.out.println("Movie Report:");
                        String[] report = cm.generateReport();
                        for (String line : report) {
                            System.out.println(line);
                        }
                        break;
                    case 5:
                        System.out.println("Exiting.");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (InvalidTimeFormatException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Error: Attempted to access invalid index.");
            }
        }
    }
}