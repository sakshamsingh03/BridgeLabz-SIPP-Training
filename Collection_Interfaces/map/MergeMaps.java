package com.interfac.map;

import java.util.*;

public class MergeMaps {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> result = new HashMap<>(map1);

        // Merging map2 into result
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            // If the key already exists, sum the values; otherwise, add the new key-value
            // pair
            result.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        System.out.println("Merged Map: " + result);
    }
}
