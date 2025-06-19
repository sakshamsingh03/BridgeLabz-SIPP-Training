import java.util.Scanner;

public class StringSplitter {

    // 1. Method to calculate string length without using .length()
    public static int getLength(String str) {
        char[] arr = str.toCharArray();
        int count = 0;
        for (char ch : arr) {
            count++;
        }
        return count;
    }

    // 2. Method to count number of words (separated by single spaces)
    public static int countWords(String text) {
        int count = 0;
        boolean inWord = false;
        int len = getLength(text);

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            if (ch != ' ' && !inWord) {
                count++;
                inWord = true;
            } else if (ch == ' ') {
                inWord = false;
            }
        }
        return count;
    }

    // 3. Method to split the string into words using charAt()
    public static String[] manualSplit(String text) {
        int len = getLength(text);
        int wordCount = countWords(text);
        String[] words = new String[wordCount];

        int index = 0;
        String currentWord = "";

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);

            if (ch != ' ') {
                currentWord += ch;
            } else {
                if (!currentWord.equals("")) {
                    words[index++] = currentWord;
                    currentWord = "";
                }
            }
        }

        if (!currentWord.equals("")) {
            words[index] = currentWord;
        }

        return words;
    }

    // 4. Method to compare two string arrays
    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }

        return true;
    }

    // 5. Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // Built-in split()
        String[] builtIn = input.trim().split("\\s+");

        // Manual split
        String[] manual = manualSplit(input);

        // Compare and display
        System.out.println("\nBuilt-in Split:");
        for (String word : builtIn) {
            System.out.println("- " + word);
        }

        System.out.println("\nManual Split:");
        for (String word : manual) {
            System.out.println("- " + word);
        }

        boolean isSame = compareArrays(builtIn, manual);
        System.out.println("\nAre both split results equal? " + isSame);
    }
}