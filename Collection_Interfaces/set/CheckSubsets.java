package com.interfac.set;

import java.util.*;

public class CheckSubsets {
        public static void main(String[] args) {
                Set<Integer> small = new HashSet<>(Arrays.asList(2, 3));
                Set<Integer> large = new HashSet<>(Arrays.asList(1, 2, 3, 4));

                boolean isSubset = large.containsAll(small);
                System.out.println("Is Subset: " + isSubset);
        }
}
