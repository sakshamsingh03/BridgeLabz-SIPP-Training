// Base class
class Course {
    String courseName;
    int duration; // in weeks

    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

// Subclass: OnlineCourse
class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

// Subclass: PaidOnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    void displayCourseInfo() {
        super.displayCourseInfo();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
    }
}

// Main class to test
public class EducationalCourseHierarchy {
    public static void main(String[] args) {
        System.out.println("--- Course ---");
        Course c = new Course("Basic Programming", 6);
        c.displayCourseInfo();

        System.out.println("\n--- Online Course ---");
        OnlineCourse oc = new OnlineCourse("Java Fundamentals", 8, "Coursera", true);
        oc.displayCourseInfo();

        System.out.println("\n--- Paid Online Course ---");
        PaidOnlineCourse poc = new PaidOnlineCourse("Advanced Java", 10, "Udemy", true, 99.99, 20);
        poc.displayCourseInfo();
    }
}
