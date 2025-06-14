import java.util.Scanner;

public class DoubleOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Taking user input for a, b, and c
        System.out.print("a: ");
        double a = sc.nextInt();
        
        System.out.print("b: ");
        double b = sc.nextInt();
        
        System.out.print("c: ");
        double c = sc.nextInt();
        
        double result1 = a + b * c;      
        double result2 = a * b + c;      
        double result3 = c + a / b;      
        double result4 = a % b + c;      
        
        // Printing the results
        System.out.println("The results of Double Operations are " + result1 + ", " + result2 + 
                           ", " + result3 + ", and " + result4);
        
    }
}