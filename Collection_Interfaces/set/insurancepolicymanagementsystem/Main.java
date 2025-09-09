package com.interfac.set.insurancepolicymanagementsystem;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new Policy("P101", "Anubhav", LocalDate.now().plusDays(15), "Health", 12000));
        manager.addPolicy(new Policy("P102", "Ayush", LocalDate.now().plusDays(45), "Auto", 9000));
        manager.addPolicy(new Policy("P103", "Divanshu", LocalDate.now().plusDays(5), "Home", 8000));
        manager.addPolicy(new Policy("P101", "Anubhav", LocalDate.now().plusDays(15), "Health", 12000));
        
        System.out.println("📄 All Policies:");
        manager.displayAllPolicies(manager.linkedHashSet);

        System.out.println("\n⏳ Policies Expiring Soon (within 30 days):");
        for (Policy p : manager.getExpiringSoon()) {
            System.out.println(p);
        }

        System.out.println("\n🚗 Auto Coverage Policies:");
        for (Policy p : manager.getByCoverageType("Auto")) {
            System.out.println(p);
        }

        System.out.println("\n❗ Duplicate Policies:");
        for (Policy p : manager.findDuplicates()) {
            System.out.println(p);
        }
    }
}
