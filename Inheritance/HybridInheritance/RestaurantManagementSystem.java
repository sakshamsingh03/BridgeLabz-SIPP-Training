// Superclass
class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Interface
interface Worker {
    void performDuties();
}

// Subclass: Chef
class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is cooking " + specialty + " dishes.");
    }
}

// Subclass: Waiter
class Waiter extends Person implements Worker {
    int tableCount;

    Waiter(String name, int id, int tableCount) {
        super(name, id);
        this.tableCount = tableCount;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving " + tableCount + " tables.");
    }
}

// Main class to test
public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon Ramsay", 101, "Italian");
        Waiter waiter = new Waiter("John Smith", 202, 5);

        System.out.println("--- Chef Info ---");
        chef.displayInfo();
        chef.performDuties();

        System.out.println("\n--- Waiter Info ---");
        waiter.displayInfo();
        waiter.performDuties();
    }
}
