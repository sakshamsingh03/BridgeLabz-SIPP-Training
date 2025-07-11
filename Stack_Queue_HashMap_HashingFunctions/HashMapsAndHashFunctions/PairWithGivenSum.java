import java.util.*;

public class PairWithGivenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        if (hasPairWithSum(arr, target)) {
            System.out.println("Pair exists with sum " + target);
        } else {
            System.out.println("No such pair found.");
        }
        sc.close();
    }

    static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(target - num)) {
                System.out.println("Pair: (" + num + ", " + (target - num) + ")");
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}
