import java.util.*;

// Interface: GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract class: Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        setVehicleId(vehicleId);
        setDriverName(driverName);
        setRatePerKm(ratePerKm);
        this.currentLocation = "Depot"; // Default starting location
    }

    // Encapsulation
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        if (vehicleId == null || vehicleId.isEmpty()) throw new IllegalArgumentException("Invalid Vehicle ID.");
        this.vehicleId = vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        if (driverName == null || driverName.isEmpty()) throw new IllegalArgumentException("Invalid Driver Name.");
        this.driverName = driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        if (ratePerKm <= 0) throw new IllegalArgumentException("Rate must be positive.");
        this.ratePerKm = ratePerKm;
    }

    protected String getCurrentLocation() {
        return currentLocation;
    }

    protected void setCurrentLocation(String location) {
        this.currentLocation = location;
    }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: ₹" + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }

    public abstract double calculateFare(double distance);
}

// Car
class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50; // Base booking charge
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
}

// Bike
class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
}

// Auto
class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 30; // Auto base charge
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }
}

// Main class
public class RideHailingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Vehicle> fleet = new ArrayList<>();

        System.out.print("Enter number of vehicles to register: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nVehicle " + (i + 1));
            System.out.print("Enter type (Car/Bike/Auto): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Enter Vehicle ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Driver Name: ");
            String driver = sc.nextLine();

            System.out.print("Enter Rate per Km: ");
            double rate = sc.nextDouble();
            sc.nextLine();

            Vehicle v = null;

            switch (type) {
                case "car":
                    v = new Car(id, driver, rate);
                    break;
                case "bike":
                    v = new Bike(id, driver, rate);
                    break;
                case "auto":
                    v = new Auto(id, driver, rate);
                    break;
                default:
                    System.out.println("Invalid type. Skipping.");
                    continue;
            }

            System.out.print("Set starting location: ");
            String location = sc.nextLine();
            if (v instanceof GPS) {
                ((GPS) v).updateLocation(location);
            }

            fleet.add(v);
        }

        System.out.println("\n=== Fleet Summary ===");
        for (Vehicle v : fleet) {
            System.out.println("-------------------------------");
            v.getVehicleDetails();
        }

        System.out.println("\n=== Booking Simulation ===");
        for (Vehicle v : fleet) {
            System.out.println("-------------------------------");
            v.getVehicleDetails();
            System.out.print("Enter ride distance in Km: ");
            double distance = sc.nextDouble();
            sc.nextLine();

            double fare = v.calculateFare(distance);
            System.out.printf("Calculated Fare for %.2f Km: ₹%.2f\n", distance, fare);

            System.out.print("Update driver location after ride? (yes/no): ");
            String choice = sc.nextLine().trim().toLowerCase();
            if (choice.equals("yes")) {
                System.out.print("Enter new location: ");
                String newLoc = sc.nextLine();
                if (v instanceof GPS) {
                    ((GPS) v).updateLocation(newLoc);
                }
            }
        }

        System.out.println("\n=== Final Fleet Status ===");
        for (Vehicle v : fleet) {
            System.out.println("-------------------------------");
            v.getVehicleDetails();
        }

        sc.close();
    }
}
