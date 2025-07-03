import java.util.*;

// Interface: MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class: Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private List<String> medicalRecords;

    public Patient(String patientId, String name, int age) {
        setPatientId(patientId);
        setName(name);
        setAge(age);
        this.medicalRecords = new ArrayList<>();
    }

    // Encapsulation
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        if (patientId == null || patientId.isEmpty()) throw new IllegalArgumentException("Invalid ID.");
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Invalid name.");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) throw new IllegalArgumentException("Invalid age.");
        this.age = age;
    }

    protected List<String> getMedicalRecords() {
        return medicalRecords;
    }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public abstract double calculateBill();
}

// InPatient
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private List<String> records;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records:");
        if (records.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (String r : records) {
                System.out.println("- " + r);
            }
        }
    }

    @Override
    public void getPatientDetails() {
        super.getPatientDetails();
        System.out.println("Patient Type: In-Patient");
        System.out.println("Days Admitted: " + daysAdmitted);
        System.out.println("Daily Rate: ₹" + dailyRate);
    }
}

// OutPatient
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records:");
        if (records.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (String r : records) {
                System.out.println("- " + r);
            }
        }
    }

    @Override
    public void getPatientDetails() {
        super.getPatientDetails();
        System.out.println("Patient Type: Out-Patient");
        System.out.println("Consultation Fee: ₹" + consultationFee);
    }
}

// Main Class
public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>();

        System.out.print("Enter number of patients to register: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nPatient " + (i + 1));
            System.out.print("Enter type (InPatient/OutPatient): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Enter Patient ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            Patient p = null;

            if (type.equals("inpatient")) {
                System.out.print("Enter Days Admitted: ");
                int days = sc.nextInt();

                System.out.print("Enter Daily Rate: ");
                double rate = sc.nextDouble();
                sc.nextLine();

                p = new InPatient(id, name, age, days, rate);
            } else if (type.equals("outpatient")) {
                System.out.print("Enter Consultation Fee: ");
                double fee = sc.nextDouble();
                sc.nextLine();

                p = new OutPatient(id, name, age, fee);
            } else {
                System.out.println("Invalid type. Skipping.");
                continue;
            }

            System.out.print("Add medical record? (yes/no): ");
            String addRecordChoice = sc.nextLine().trim().toLowerCase();

            while (addRecordChoice.equals("yes")) {
                System.out.print("Enter medical record detail: ");
                String record = sc.nextLine();
                if (p instanceof MedicalRecord) {
                    ((MedicalRecord) p).addRecord(record);
                }
                System.out.print("Add another record? (yes/no): ");
                addRecordChoice = sc.nextLine().trim().toLowerCase();
            }

            patients.add(p);
        }

        System.out.println("\n=== Patient Summary ===");
        for (Patient p : patients) {
            System.out.println("----------------------------");
            p.getPatientDetails();
            System.out.printf("Calculated Bill: ₹%.2f\n", p.calculateBill());
            if (p instanceof MedicalRecord) {
                ((MedicalRecord) p).viewRecords();
            }
            System.out.println();
        }

        sc.close();
    }
}
