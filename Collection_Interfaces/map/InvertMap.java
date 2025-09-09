package com.interfac.map;

import java.util.*;

public class InvertMap {
    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        Map<Integer, List<String>> invertedMap = new HashMap<>();

        // Invert the map
        for (Map.Entry<String, Integer> entry : originalMap.entrySet()) {
            int value = entry.getValue();
            String key = entry.getKey();

            invertedMap.putIfAbsent(value, new ArrayList<>());
            invertedMap.get(value).add(key);
        }

        System.out.println(invertedMap);
    }
}
