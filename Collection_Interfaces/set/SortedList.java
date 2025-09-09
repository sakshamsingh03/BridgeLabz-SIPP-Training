package com.interfac.set;

import java.util.*;

public class SortedList {
	public static void main(String[] args) {
		
        Set<Integer> unsortedSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        List<Integer> sortedList = new ArrayList<>(unsortedSet);
        Collections.sort(sortedList);
        System.out.println("Sorted List: " + sortedList);
	}
}
