package com.interfac.map.insurancepolicymanagementsystem;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        manager.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 1500.0));
        manager.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 1800.0));
        manager.addPolicy(new Policy("P003", "Alice", LocalDate.now().minusDays(5), "Home", 1200.0));

        System.out.println("Policy by number (P001): " + manager.getPolicyByNumber("P001"));

        System.out.println("\nExpiring within 30 days:");
        for (Policy p : manager.getExpiringPolicies()) {
            System.out.println(p);
        }

        System.out.println("\nPolicies for Alice:");
        for (Policy p : manager.getPoliciesByHolder("Alice")) {
            System.out.println(p);
        }

        manager.removeExpiredPolicies();
        System.out.println("\nAfter removing expired:");
        for (Policy p : manager.hashMap.values()) {
            System.out.println(p);
        }
    }
}
