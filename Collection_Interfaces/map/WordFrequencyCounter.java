package com.interfac.map;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) throws IOException {
        String text = "Hello world, hello Java!";
        Map<String, Integer> freqMap = new HashMap<>();

        // Remove punctuation and convert to lowercase
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        for (String word : text.split("\\s+")) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        System.out.println(freqMap);
    }
}