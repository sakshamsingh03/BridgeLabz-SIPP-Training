import java.util.Random;

public class FootballTeamStats {

    // Generate random heights between 150 and 250 cm
    public static int[] generatePlayerHeights(int numberOfPlayers) {
        Random rand = new Random();
        int[] heights = new int[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            heights[i] = rand.nextInt(101) + 150; // 150 to 250
        }
        return heights;
    }

    // Method to calculate the sum of all elements
    public static int getSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    // Method to calculate the mean height
    public static double getMean(int[] heights) {
        return (double) getSum(heights) / heights.length;
    }

    // Method to find the shortest height
    public static int getShortest(int[] heights) {
        int min = Integer.MAX_VALUE;
        for (int height : heights) {
            if (height < min) min = height;
        }
        return min;
    }

    // Method to find the tallest height
    public static int getTallest(int[] heights) {
        int max = Integer.MIN_VALUE;
        for (int height : heights) {
            if (height > max) max = height;
        }
        return max;
    }

    // Main method
    public static void main(String[] args) {
        int[] heights = generatePlayerHeights(11);

        System.out.println("Player Heights (in cm):");
        for (int height : heights) {
            System.out.print(height + " ");
        }
        System.out.println();

        int sum = getSum(heights);
        double mean = getMean(heights);
        int shortest = getShortest(heights);
        int tallest = getTallest(heights);

        System.out.println("\nTeam Height Statistics:");
        System.out.println("Total Sum of Heights: " + sum + " cm");
        System.out.printf("Mean Height: %.2f cm%n", mean);
        System.out.println("Shortest Height: " + shortest + " cm");
        System.out.println("Tallest Height: " + tallest + " cm");
    }
}
