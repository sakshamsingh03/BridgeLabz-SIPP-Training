package com.interfac.set;

import java.util.*;

public class SetEquality {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        boolean areEqual = set1.equals(set2);
        System.out.println("Sets are equal: " + areEqual);
    }
}
