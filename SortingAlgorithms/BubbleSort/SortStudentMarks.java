
import java.util.Scanner;

public class SortStudentMarks {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     // Input: Number of students and their marks
     System.out.print("Enter the number of students: ");
     int n = sc.nextInt();

     int[] marks = new int[n];
     System.out.println("Enter the marks of " + n + " students:");
     for (int i = 0; i < n; i++) {
         marks[i] = sc.nextInt();
     }

     // Sort the marks using Bubble Sort
     bubbleSort(marks);

     // Display sorted marks
     System.out.println("Student marks sorted in ascending order:");
     for (int mark : marks) {
         System.out.print(mark + " ");
     }
 }

 // Bubble Sort Method
 public static void bubbleSort(int[] arr) {
     int n = arr.length;
     boolean swapped;

     // Outer loop for each pass
     for (int i = 0; i < n - 1; i++) {
         swapped = false;

         // Inner loop to compare and swap
         for (int j = 0; j < n - i - 1; j++) {
             if (arr[j] > arr[j + 1]) {
                 // Swap
                 int temp = arr[j];
                 arr[j] = arr[j + 1];
                 arr[j + 1] = temp;
                 swapped = true;
             }
         }

         // If no swaps occurred, array is sorted
         if (!swapped) {
             break;
         }
     }
 }
}