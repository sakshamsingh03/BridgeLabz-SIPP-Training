package com.interfac.list;

import java.util.*;

public class FrequencyCounter {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> frequencyMap = countFrequency(items);

        System.out.println(frequencyMap);
    }

    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> freqMap = new HashMap<>();

        for (String item : list) {
            freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
        }

        return freqMap;
    }
}
