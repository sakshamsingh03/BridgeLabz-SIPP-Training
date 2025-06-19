import java.util.Scanner;
public class VowelConsonantChecker {
    public static String checkCharType(char ch) {
        int ascii = (int) ch;
        if (ascii >= 65 && ascii <= 90) {
            ch = (char) (ascii + 32);
        }
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "Vowel";
        }
        else if (ch >= 'a' && ch <= 'z') {
            return "Consonant";
        } else {
            return "Not a Letter";
        }
    }
    
    public static String[][] analyzeString(String text) {
        int len = text.length(); // .length() is okay here for loop bounds
        String[][] result = new String[len][2];

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharType(ch);
        }

        return result;
    }
    public static void displayResult(String[][] data) {
        System.out.printf("%-10s | %-15s\n", "Character", "Type");
        System.out.println("---------------------------");
        for (String[] row : data) {
            System.out.printf("%-10s | %-15s\n", row[0], row[1]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String[][] result = analyzeString(input);
        displayResult(result);
    }
}