
import java.util.Scanner;

public class SortExamScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of students and their exam scores
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        int[] scores = new int[n];
        System.out.println("Enter the exam scores of " + n + " students:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        // Sort using Selection Sort
        selectionSort(scores);

        // Display sorted scores
        System.out.println("Exam scores sorted in ascending order:");
        for (int score : scores) {
            System.out.print(score + " ");
        }

        // Close the scanner
        sc.close();
    }

    // Selection Sort Method
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the minimum element in unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}