
import java.util.Scanner;

public class SortProductPrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of products and their prices
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        double[] prices = new double[n];
        System.out.println("Enter the prices of " + n + " products:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextDouble();
        }

        // Sort using Quick Sort
        quickSort(prices, 0, n - 1);

        // Display sorted prices
        System.out.println("Product prices sorted in ascending order:");
        for (double price : prices) {
            System.out.print(price + " ");
        }

        // Close the scanner
        sc.close();
    }

    // Quick Sort Method
    public static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot index
            int pi = partition(arr, low, high);

            // Recursively sort left and right partitions
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition Method (Using Last Element as Pivot)
    public static int partition(double[] arr, int low, int high) {
        double pivot = arr[high]; // Pivot
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot to correct position
        double temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return pivot index
    }
}