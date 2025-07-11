
import java.util.Scanner;

public class SortBookPrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of books and their prices
        System.out.print("Enter the number of books: ");
        int n = sc.nextInt();

        double[] prices = new double[n];
        System.out.println("Enter the prices of " + n + " books:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextDouble();
        }

        // Sort using Merge Sort
        mergeSort(prices, 0, n - 1);

        // Display sorted prices
        System.out.println("Book prices sorted in ascending order:");
        for (double price : prices) {
            System.out.print(price + " ");
        }

        // close the scanner
        sc.close();
    }

    // Merge Sort Method
    public static void mergeSort(double[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort left half
            mergeSort(arr, left, mid);
            // Sort right half
            mergeSort(arr, mid + 1, right);
            // Merge sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Merge Method
    public static void merge(double[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] leftArr = new double[n1];
        double[] rightArr = new double[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // Merge temporary arrays back into original array
        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy remaining elements of leftArr (if any)
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements of rightArr (if any)
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }
}