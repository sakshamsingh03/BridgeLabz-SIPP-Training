package com.interfac.queue;

public class CircularBuffer {
    private int[] buffer;
    private int size;
    private int start = 0;
    private int count = 0;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = capacity;
    }

    public void insert(int value) {
        int index = (start + count) % size;
        if (count < size) {
            buffer[index] = value;
            count++;
        } else {
            buffer[start] = value;
            start = (start + 1) % size;
        }
    }

    public void display() {
        System.out.print("Buffer: ");
        for (int i = 0; i < count; i++) {
            int index = (start + i) % size;
            System.out.print(buffer[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display();

        cb.insert(4);
        cb.display();

        cb.insert(5);
        cb.display();
    }
}
