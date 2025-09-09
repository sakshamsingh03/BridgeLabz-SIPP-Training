package com.interfac.set;

import java.util.*;

public class SymmetricDifference {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        // Symmetric Difference
        Set<Integer> symmetricDiff = new HashSet<>(set1);
        symmetricDiff.addAll(set2); // union
        Set<Integer> temp = new HashSet<>(set1);
        temp.retainAll(set2);       // intersection
        symmetricDiff.removeAll(temp);
        System.out.println("Symmetric Difference: " + symmetricDiff);
    }
}
