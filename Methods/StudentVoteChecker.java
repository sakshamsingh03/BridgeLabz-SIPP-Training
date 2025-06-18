import java.util.Scanner;

public class StudentVoteChecker {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Create an array to store the ages of 10 students
        int[] ages = new int[10];

        // Take user input for the ages of the students
        System.out.println("Please enter the ages of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            ages[i] = input.nextInt();
        }

        // Create an instance of StudentVoteChecker
        StudentVoteChecker checker = new StudentVoteChecker();

        // Check voting eligibility based on age
        for (int age : ages) {
            System.out.println(checker.canStudentVote(age));
        }

        // Close the input stream
        input.close();
    }

    public boolean canStudentVote(int age) {
        // Check if the student can vote based on age
        if (age < 0) {
            System.out.println("Invalid age: " + age);
            return false;
        } else if (age >= 18) {
            System.out.println("The student with the age " + age + " can vote.");
            return true;
        } else {
            System.out.println("The student with the age " + age + " cannot vote.");
            return false;
        }
    }
}
