import java.util.*;

// Interface: Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract Class: Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        setRentalRate(rentalRate);
    }

    // Encapsulation
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        if (rentalRate < 0) {
            throw new IllegalArgumentException("Rental rate cannot be negative.");
        }
        this.rentalRate = rentalRate;
    }

    public void displayInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per day: $" + rentalRate);
    }

    public abstract double calculateRentalCost(int days);
}

// Car implements Insurable
class Car extends Vehicle implements Insurable {
    private String carModel;

    public Car(String vehicleNumber, double rentalRate, String carModel) {
        super(vehicleNumber, "Car", rentalRate);
        this.carModel = carModel;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 50; // $50 fixed cleaning fee
    }

    @Override
    public double calculateInsurance() {
        return 200.0; // flat insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Car insurance: Flat $200";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Model: " + carModel);
        System.out.println(getInsuranceDetails());
    }
}

// Bike implements Insurable
class Bike extends Vehicle implements Insurable {
    private String engineCapacity;

    public Bike(String vehicleNumber, double rentalRate, String engineCapacity) {
        super(vehicleNumber, "Bike", rentalRate);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 50.0;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike insurance: Flat $50";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Engine Capacity: " + engineCapacity);
        System.out.println(getInsuranceDetails());
    }
}

// Truck implements Insurable
class Truck extends Vehicle implements Insurable {
    private double loadCapacity;

    public Truck(String vehicleNumber, double rentalRate, double loadCapacity) {
        super(vehicleNumber, "Truck", rentalRate);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + loadCapacity * 10; // load charge
    }

    @Override
    public double calculateInsurance() {
        return 300.0;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck insurance: Flat $300";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
        System.out.println(getInsuranceDetails());
    }
}

// Main Class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Vehicle> fleet = new ArrayList<>();

        System.out.print("Enter number of vehicles to add: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nVehicle " + (i + 1));
            System.out.print("Enter type (Car/Bike/Truck): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Enter Vehicle Number: ");
            String number = sc.nextLine();

            System.out.print("Enter Rental Rate per day: ");
            double rate = sc.nextDouble();
            sc.nextLine();

            switch (type) {
                case "car":
                    System.out.print("Enter Car Model: ");
                    String model = sc.nextLine();
                    fleet.add(new Car(number, rate, model));
                    break;

                case "bike":
                    System.out.print("Enter Engine Capacity (e.g. 150cc): ");
                    String engine = sc.nextLine();
                    fleet.add(new Bike(number, rate, engine));
                    break;

                case "truck":
                    System.out.print("Enter Load Capacity (in tons): ");
                    double load = sc.nextDouble();
                    sc.nextLine();
                    fleet.add(new Truck(number, rate, load));
                    break;

                default:
                    System.out.println("Invalid vehicle type. Skipping...");
                    break;
            }
        }

        // Processing rentals
        System.out.println("\n=== Rental Summary ===");
        System.out.print("Enter number of rental days: ");
        int days = sc.nextInt();

        for (Vehicle v : fleet) {
            System.out.println("-------------------------");
            v.displayInfo();

            double rentalCost = v.calculateRentalCost(days);
            double insurance = 0;
            if (v instanceof Insurable) {
                insurance = ((Insurable) v).calculateInsurance();
            }

            double totalCost = rentalCost + insurance;

            System.out.printf("Rental Cost for %d days: $%.2f%n", days, rentalCost);
            System.out.printf("Insurance Cost: $%.2f%n", insurance);
            System.out.printf("Total Cost: $%.2f%n", totalCost);
        }

        sc.close();
    }
}
