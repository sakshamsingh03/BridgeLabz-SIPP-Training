class Student {
    static String universityName = "National University";
    static int totalStudents = 0;

    final int rollNumber;
    String name, grade;

    Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    void display() {
        if (this instanceof Student) {
            System.out.println("Name: " + name + ", Roll: " + rollNumber + ", Grade: " + grade);
        }
    }
}
