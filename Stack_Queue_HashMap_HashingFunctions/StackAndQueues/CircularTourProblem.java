import java.util.*;

public class CircularTourProblem {
    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter number of petrol pumps: ");
        int n = sc.nextInt();
        PetrolPump[] pumps = new PetrolPump[n];

        System.out.println("Enter petrol and distance to next pump for each:");
        for (int i = 0; i < n; i++) {
            int petrol = sc.nextInt();
            int distance = sc.nextInt();
            pumps[i] = new PetrolPump(petrol, distance);
        }

        // Find starting point
        int start = 0;
        int surplus = 0;
        int deficit = 0;

        for (int i = 0; i < n; i++) {
            surplus += pumps[i].petrol - pumps[i].distance;
            if (surplus < 0) {
                start = i + 1;
                deficit += surplus;
                surplus = 0;
            }
        }

        if (surplus + deficit >= 0) {
            System.out.println("Starting point is pump index: " + start);
        } else {
            System.out.println("No possible tour");
        }
    }
}
