import java.util.Scanner;

public class VowelConsonantCounter {

    // 1. Method to determine if a character is a vowel, consonant, or not a letter
    public static String getCharType(char ch) {
        int ascii = (int) ch;

        // Convert uppercase to lowercase
        if (ascii >= 65 && ascii <= 90) {
            ch = (char)(ascii + 32); // Convert to lowercase
        }

        // Check if it is a letter
        if (ch >= 'a' && ch <= 'z') {
            // Check for vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // 2. Method to count vowels and consonants using charAt()
    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            String type = getCharType(ch);

            if (type.equals("Vowel")) vowels++;
            else if (type.equals("Consonant")) consonants++;
        }

        return new int[]{vowels, consonants};
    }

    // 3. Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Count vowels and consonants
        int[] counts = countVowelsAndConsonants(input);

        // Output
        System.out.println("\n--- Result ---");
        System.out.println("Vowels     : " + counts[0]);
        System.out.println("Consonants : " + counts[1]);
    }
}