import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner sc = new Scanner(System.in);

        // Take input for number of students
        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();

        // Create arrays for marks, percentages, and grades
        int[][] marks = new int[numStudents][3];
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];

        // Take input for student marks
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + " (Physics, Chemistry, Maths):");
            for (int j = 0; j < 3; j++) {
                marks[i][j] = sc.nextInt();
                while (marks[i][j] < 0) {
                    System.out.println("Negative marks are not allowed. Please enter a positive value:");
                    marks[i][j] = sc.nextInt();
                }
            }

            // Calculate percentage
            percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

            // Assign grade
            grades[i] = getGrade(percentages[i]);
        }

        // Display results
        System.out.println("\nStudent Results:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Physics Marks: " + marks[i][0]);
            System.out.println("Chemistry Marks: " + marks[i][1]);
            System.out.println("Maths Marks: " + marks[i][2]);
            System.out.printf("Percentage: %.2f%%\n", percentages[i]);
            System.out.println("Grade: " + grades[i]);
            System.out.println();
        }

        sc.close();
    }

    // Method to Calculate grade based on percentage
    private static char getGrade(double percentage) {
        if (percentage >= 80)
            return 'A';
        else if (percentage >= 70)
            return 'B';
        else if (percentage >= 60)
            return 'C';
        else if (percentage >= 50)
            return 'D';
        else if (percentage >= 40)
            return 'E';
        else
            return 'R'; // Remedial
    }
}