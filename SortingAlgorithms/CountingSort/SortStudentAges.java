
import java.util.Scanner;

public class SortStudentAges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of students and their ages
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        int[] ages = new int[n];
        System.out.println("Enter the ages of " + n + " students (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
            // Validate age range
            if (ages[i] < 10 || ages[i] > 18) {
                System.out.println("Invalid age! Please enter ages between 10 and 18.");
                return;
            }
        }

        // Sort using Counting Sort
        countingSort(ages);

        // Display sorted ages
        System.out.println("Student ages sorted in ascending order:");
        for (int age : ages) {
            System.out.print(age + " ");
        }

        // Close the scanner
        sc.close();
    }

    // Counting Sort Method
    public static void countingSort(int[] arr) {
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];

        // Count frequencies
        for (int age : arr) {
            count[age - minAge]++;
        }

        // Build sorted array based on count
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                arr[index++] = i + minAge;
                count[i]--;
            }
        }
    }
}