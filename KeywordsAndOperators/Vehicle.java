class Vehicle {
    static double registrationFee = 1500.0;

    final String registrationNumber;
    String ownerName, vehicleType;

    Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    void display() {
        if (this instanceof Vehicle) {
            System.out.println("Vehicle: " + vehicleType + ", Owner: " + ownerName + ", Reg No: " + registrationNumber);
        }
    }
}
