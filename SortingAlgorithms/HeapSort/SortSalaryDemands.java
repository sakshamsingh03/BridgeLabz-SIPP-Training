
import java.util.Scanner;

public class SortSalaryDemands {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     // Input: Number of applicants and their expected salary demands
     System.out.print("Enter the number of job applicants: ");
     int n = sc.nextInt();

     double[] salaries = new double[n];
     System.out.println("Enter the expected salary demands of " + n + " applicants:");
     for (int i = 0; i < n; i++) {
         salaries[i] = sc.nextDouble();
     }

     // Sort using Heap Sort
     heapSort(salaries);

     // Display sorted salary demands
     System.out.println("Salary demands sorted in ascending order:");
     for (double salary : salaries) {
         System.out.print(salary + " ");
     }

     // Close the scanner
     sc.close();
 }

 // Heap Sort Method
 public static void heapSort(double[] arr) {
     int n = arr.length;

     // Build Max Heap
     for (int i = n / 2 - 1; i >= 0; i--) {
         heapify(arr, n, i);
     }

     // Extract elements from heap one by one
     for (int i = n - 1; i > 0; i--) {
         // Swap current root with last element
         double temp = arr[0];
         arr[0] = arr[i];
         arr[i] = temp;

         // Reheapify reduced heap
         heapify(arr, i, 0);
     }
 }

 // Heapify Method to maintain Max Heap property
 public static void heapify(double[] arr, int n, int i) {
     int largest = i;          // Initialize largest as root
     int left = 2 * i + 1;     // Left child
     int right = 2 * i + 2;    // Right child

     // If left child is larger than root
     if (left < n && arr[left] > arr[largest]) {
         largest = left;
     }

     // If right child is larger than largest so far
     if (right < n && arr[right] > arr[largest]) {
         largest = right;
     }

     // If largest is not root, swap and continue heapifying
     if (largest != i) {
         double temp = arr[i];
         arr[i] = arr[largest];
         arr[largest] = temp;

         heapify(arr, n, largest);
     }
 }
}