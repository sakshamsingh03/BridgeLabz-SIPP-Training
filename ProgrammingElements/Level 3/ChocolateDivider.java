import java.util.Scanner;

public class ChocolateDivider {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = sc.nextInt();
        
        System.out.print("Enter the number of children: ");
        int numberOfChildren = sc.nextInt();
        
        // Calculate distribution
        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;
        
        // Display results
        System.out.println("The number of chocolates each child gets is " + chocolatesPerChild + 
                          " and the number of remaining chocolates is " + remainingChocolates);
    }
}