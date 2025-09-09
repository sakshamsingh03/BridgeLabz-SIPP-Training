package com.interfac.set.insurancepolicymanagementsystem;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayAllPolicies(Set<Policy> set) {
        for (Policy p : set) {
            System.out.println(p);
        }
    }

    public List<Policy> getExpiringSoon() {
        List<Policy> expiring = new ArrayList<>();
        LocalDate now = LocalDate.now();
        for (Policy p : treeSet) {
            if (!p.getExpiryDate().isAfter(now.plusDays(30))) {
                expiring.add(p);
            }
        }
        return expiring;
    }

    public List<Policy> getByCoverageType(String type) {
        List<Policy> filtered = new ArrayList<>();
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(type)) {
                filtered.add(p);
            }
        }
        return filtered;
    }

    public List<Policy> findDuplicates() {
        Set<String> seen = new HashSet<>();
        List<Policy> duplicates = new ArrayList<>();
        for (Policy p : linkedHashSet) {
            if (!seen.add(p.getPolicyNumber())) {
                duplicates.add(p);
            }
        }
        return duplicates;
    }
}
