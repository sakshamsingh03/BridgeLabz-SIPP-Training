package com.interfac.map.insurancepolicymanagementsystem;

import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManager {
    Map<String, Policy> hashMap = new HashMap<>();
    Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();

    // Add Policy
    public void addPolicy(Policy policy) {
        hashMap.put(policy.getPolicyNumber(), policy);
        linkedHashMap.put(policy.getPolicyNumber(), policy);

        // TreeMap by expiry date
        treeMap.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    // Retrieve by policy number
    public Policy getPolicyByNumber(String number) {
        return hashMap.get(number);
    }

    // List policies expiring in next 30 days
    public List<Policy> getExpiringPolicies() {
        List<Policy> result = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);
        for (Map.Entry<LocalDate, List<Policy>> entry : treeMap.subMap(today, true, limit, true).entrySet()) {
            result.addAll(entry.getValue());
        }
        return result;
    }

    // List all policies for a policyholder
    public List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : hashMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(holderName)) {
                result.add(policy);
            }
        }
        return result;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<String, Policy>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Policy> entry = iterator.next();
            if (entry.getValue().getExpiryDate().isBefore(today)) {
                iterator.remove();
                linkedHashMap.remove(entry.getKey());
                treeMap.get(entry.getValue().getExpiryDate()).remove(entry.getValue());
            }
        }
    }
}
