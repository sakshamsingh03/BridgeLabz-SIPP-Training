import java.util.Scanner;

public class StudentGrades2 {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner sc = new Scanner(System.in);

        // Take input for the number of students
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        // Arrays to store marks, percentages, grades
        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // Input and validation
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));
            physics[i] = readValidMark(sc, "Physics");
            chemistry[i] = readValidMark(sc, "Chemistry");
            maths[i] = readValidMark(sc, "Maths");

            int total = physics[i] + chemistry[i] + maths[i];
            percentage[i] = total / 3.0;

            // Grade calculation
            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
            }
        }

        // Display result
        System.out.println("\n--- Student Results ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Physics Marks: " + physics[i]);
            System.out.println("Chemistry Marks: " + chemistry[i]);
            System.out.println("Maths Marks: " + maths[i]);
            System.out.println("Percentage: " + percentage[i]);
            System.out.println("Grade: " + grade[i]);
        }
        sc.close();
    }

    // Method to read valid marks for a subject
    public static int readValidMark(Scanner sc, String subject) {
        int mark;
        do {
            System.out.print("Enter " + subject + " marks (0-100): ");
            mark = sc.nextInt();
            if (mark < 0 || mark > 100) {
                System.out.println("Please enter a valid mark between 0 and 100.");
            }
        } while (mark < 0 || mark > 100);
        return mark;
    }
}