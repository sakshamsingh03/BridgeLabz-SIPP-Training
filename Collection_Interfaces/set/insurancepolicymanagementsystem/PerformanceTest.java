package com.interfac.set.insurancepolicymanagementsystem;

import java.time.LocalDate;
import java.util.*;

public class PerformanceTest {
    public static void main(String[] args) {
        int n = 100000;
        List<Policy> sample = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sample.add(new Policy("P" + i, "Holder " + i,
                    LocalDate.now().plusDays(i % 365), "Auto", 5000 + i));
        }

        // HashSet performance
        long start = System.nanoTime();
        Set<Policy> hs = new HashSet<>(sample);
        long hashTime = System.nanoTime() - start;

        start = System.nanoTime();
        Set<Policy> lhs = new LinkedHashSet<>(sample);
        long linkedHashTime = System.nanoTime() - start;

        start = System.nanoTime();
        Set<Policy> ts = new TreeSet<>(sample);
        long treeTime = System.nanoTime() - start;

        System.out.println("HashSet time (ns): " + hashTime);
        System.out.println("LinkedHashSet time (ns): " + linkedHashTime);
        System.out.println("TreeSet time (ns): " + treeTime);
    }
}
