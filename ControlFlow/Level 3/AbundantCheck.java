import java.util.Scanner;
class AbundantCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        if (sum > num)
            System.out.println("Abundant Number");
        else
            System.out.println("Not an Abundant Number");
    }
}
