
import java.util.Scanner;

public class SortEmployeeIDs {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     // Input: Number of Employees and their IDs
     System.out.print("Enter the number of employees: ");
     int n = sc.nextInt();

     int[] employeeIDs = new int[n];
     System.out.println("Enter the Employee IDs:");
     for (int i = 0; i < n; i++) {
         employeeIDs[i] = sc.nextInt();
     }

     // Sort using Insertion Sort
     insertionSort(employeeIDs);

     // Display sorted IDs
     System.out.println("Employee IDs sorted in ascending order:");
     for (int id : employeeIDs) {
         System.out.print(id + " ");
     }
 }

 // Insertion Sort Method
 public static void insertionSort(int[] arr) {
     int n = arr.length;

     // Start from second element as first element is considered sorted
     for (int i = 1; i < n; i++) {
         int key = arr[i];
         int j = i - 1;

         // Move elements greater than key to one position ahead
         while (j >= 0 && arr[j] > key) {
             arr[j + 1] = arr[j];
             j--;
         }

         // Insert key at correct position
         arr[j + 1] = key;
     }
 }
}