public class Main {
	public static void main(String[] args) {
        MovieManagement system = new MovieManagement();

        // Adding sample movies
        system.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        system.addAtBeginning("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        system.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        system.addAtPosition(2, "Pulp Fiction", "Quentin Tarantino", 1994, 8.9);

        // Display movies
        system.displayForward();
        system.displayReverse();

        // Search by director
        System.out.println("\nSearching for movies directed by 'Christopher Nolan':");
        system.searchMovie("Christopher Nolan");

        // Update movie rating
        System.out.println("\nUpdating rating for 'Inception':");
        system.updateRating("Inception", 9.0);
        system.displayForward();

        // Remove movie by title
        System.out.println("\nRemoving 'Pulp Fiction':");
        system.removeByTitle("Pulp Fiction");
        system.displayForward();
    }
}