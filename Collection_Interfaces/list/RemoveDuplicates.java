package com.interfac.list;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);

        List<Integer> result = removeDuplicatesPreserveOrder(list);
        System.out.println("Result: " + result);
    }

    public static <T> List<T> removeDuplicatesPreserveOrder(List<T> list) {
        Set<T> seen = new LinkedHashSet<>();
        List<T> result = new ArrayList<>();

        for (T item : list) {
            if (seen.add(item)) {  // add returns false if item already exists
                result.add(item);
            }
        }

        return result;
    }
}
