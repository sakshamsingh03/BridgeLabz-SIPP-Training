package com.interfac.map;

import java.util.*;

public class MaxValueKey {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        // Iterate through the map to find the key with the maximum value
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        System.out.println("Key with highest value: " + maxKey);
    }
}
