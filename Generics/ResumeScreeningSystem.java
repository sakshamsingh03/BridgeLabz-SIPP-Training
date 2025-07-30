import java.util.*;

// Abstract JobRole
abstract class JobRole {
    protected String candidateName;
    protected int experience; // in years

    public JobRole(String candidateName, int experience) {
        this.candidateName = candidateName;
        this.experience = experience;
    }

    public abstract boolean isEligible();

    public String getCandidateName() {
        return candidateName;
    }
}

// Concrete Roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experience) {
        super(candidateName, experience);
    }

    @Override
    public boolean isEligible() {
        return experience >= 2;
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experience) {
        super(candidateName, experience);
    }

    @Override
    public boolean isEligible() {
        return experience >= 3;
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experience) {
        super(candidateName, experience);
    }

    @Override
    public boolean isEligible() {
        return experience >= 4;
    }
}

// Generic Resume Class
class Resume<T extends JobRole> {
    private T jobApplicant;

    public Resume(T jobApplicant) {
        this.jobApplicant = jobApplicant;
    }

    public boolean process() {
        return jobApplicant.isEligible();
    }

    public String getCandidateName() {
        return jobApplicant.getCandidateName();
    }

    public String getRole() {
        return jobApplicant.getClass().getSimpleName();
    }
}

// Utility with Wildcard Method
class ScreeningPipeline {
    public static void screenResumes(List<? extends JobRole> resumes) {
        for (JobRole role : resumes) {
            System.out.println("Screening " + role.getCandidateName() + " for role: " + role.getClass().getSimpleName());
            if (role.isEligible()) {
                System.out.println("✅ Eligible");
            } else {
                System.out.println("❌ Not Eligible");
            }
            System.out.println("-------------------------");
        }
    }
}

// Main class with user input
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<JobRole> resumeList = new ArrayList<>();

        System.out.print("Enter number of resumes to process: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nResume " + (i + 1));
            System.out.print("Enter Candidate Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Experience (in years): ");
            int exp = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Job Role (SoftwareEngineer/DataScientist/ProductManager): ");
            String role = scanner.nextLine();

            switch (role.toLowerCase()) {
                case "softwareengineer":
                    resumeList.add(new SoftwareEngineer(name, exp));
                    break;
                case "datascientist":
                    resumeList.add(new DataScientist(name, exp));
                    break;
                case "productmanager":
                    resumeList.add(new ProductManager(name, exp));
                    break;
                default:
                    System.out.println("Invalid Role! Skipping this resume.");
            }
        }

        System.out.println("\n=== Screening Results ===");
        ScreeningPipeline.screenResumes(resumeList);
    }
}
