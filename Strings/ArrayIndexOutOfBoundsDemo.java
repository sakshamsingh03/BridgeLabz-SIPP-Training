import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    // Method that generates ArrayIndexOutOfBoundsException without handling
   // public static void generateException(String[] names) {
        // This will throw an ArrayIndexOutOfBoundsException
    //    System.out.println("Accessing invalid index: " + names[names.length]);
  //  }

    // Method that handles the exception using try-catch block
    public static void handleException(String[] names) {
        try {
            // Intentionally accessing an invalid index
            System.out.println("Accessing invalid index: " + names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: Index exceeds array bounds.");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
		finally{
			System.out.println("finally");
		}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for array size
        System.out.print("Enter number of names: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        // Creating and populating the array
        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }

        // Call the method that generates the exception (wrapped in try-catch to avoid crash)
        try {
            String s=names[names.length];
        } 
		catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception in generateException: " + e.getMessage());
        }
		finally{
			System.out.println("finally");
		}

        // Call the method that handles the exception
        handleException(names);
    }
}