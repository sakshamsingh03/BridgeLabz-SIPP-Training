import java.util.*;

public class OTPGenerator {

    // Method to generate a 6-digit OTP using Math.random()
    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;  // 100000 to 999999
    }

    // Method to generate and store 10 OTPs in an array
    public static int[] generateMultipleOTPs(int count) {
        int[] otps = new int[count];
        for (int i = 0; i < count; i++) {
            otps[i] = generateOTP();
        }
        return otps;
    }

    // Method to check if all OTPs are unique
    public static boolean areOTPsUnique(int[] otps) {
        Set<Integer> uniqueOTPs = new HashSet<>();
        for (int otp : otps) {
            if (!uniqueOTPs.add(otp)) {
                return false; // Duplicate found
            }
        }
        return true; // All unique
    }

    // Display OTPs
    public static void displayOTPs(int[] otps) {
        System.out.println("Generated OTPs:");
        for (int i = 0; i < otps.length; i++) {
            System.out.println("OTP " + (i + 1) + ": " + otps[i]);
        }
    }

    // Main method
    public static void main(String[] args) {
        int[] otps = generateMultipleOTPs(10);
        displayOTPs(otps);

        if (areOTPsUnique(otps)) {
            System.out.println("\n✅ All 10 OTPs are unique.");
        } else {
            System.out.println("\n❌ Duplicate OTPs found.");
        }
    }
}
