import java.util.Scanner; 
class MultiplicationTable {
    public static void main(String[] args) {
        //Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Get user input for the multiplication table
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        // Create an array to store the multiplication results from 6 to 9
        int[] multiplicationResult = new int[4];
        
        // Calculate the multiplication table
        for (int i = 6; i <=9 ; i++) {
            multiplicationResult[i - 6] = number * i;
        }
        
        // Display the result
        for (int i = 0; i < multiplicationResult.length; i++) {
            System.out.println(number + " * " + (i + 6) + " = " + multiplicationResult[i]);
        }
        
        // Close the input stream
        input.close();
    }
}