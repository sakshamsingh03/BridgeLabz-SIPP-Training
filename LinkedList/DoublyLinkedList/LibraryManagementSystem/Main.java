
public class Main {
	public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        // Adding sample books
        library.addAtBeginning("1984", "George Orwell", "Dystopian", 101, true);
        library.addAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", 102, true);
        library.addAtEnd("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 103, false);
        library.addAtPosition(2, "Brave New World", "Aldous Huxley", "Science Fiction", 104, true);

        // Display books
        library.displayForward();
        library.displayReverse();

        // Search by author
        System.out.println("\nSearching books by 'George Orwell':");
        library.searchBook("George Orwell");

        // Update availability
        System.out.println("\nUpdating availability of Book ID 103:");
        library.updateAvailability(103, true);
        library.displayForward();

        // Remove a book by Book ID
        System.out.println("\nRemoving book with ID 104:");
        library.removeByBookId(104);
        library.displayForward();

        // Count total books
        System.out.println("\nCounting total books in the library:");
        library.countBooks();
    }
}