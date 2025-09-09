package com.interfac.list;

import java.util.*;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;

        List<Integer> rotated = rotateLeft(list, rotateBy);
        System.out.println("Rotated List: " + rotated);
    }

    public static <T> List<T> rotateLeft(List<T> list, int positions) {
        int size = list.size();
        if (size == 0) return list;

        // Normalize positions if > size
        positions = positions % size;

        // Create a new list with rotated order
        List<T> rotated = new ArrayList<>();

        rotated.addAll(list.subList(positions, size)); // from rotation point to end
        rotated.addAll(list.subList(0, positions));    // from start to rotation point

        return rotated;
    }
}
