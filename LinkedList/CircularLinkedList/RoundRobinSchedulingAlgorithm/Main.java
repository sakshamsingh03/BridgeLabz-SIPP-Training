package com.linkedlist.circularlinkedlist.roundrobinschedulingalgorithm;

public class Main {
	public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Adding processes
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 4, 1);
        scheduler.addProcess(3, 7, 3);
        scheduler.addProcess(4, 5, 2);

        int timeQuantum = 3;
        scheduler.simulateScheduling(timeQuantum);
    }
}