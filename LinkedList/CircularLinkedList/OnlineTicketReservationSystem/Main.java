package com.linkedlist.circularlinkedlist.onlineticketreservationsystem;

public class Main {
	public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Adding sample tickets
        system.addTicket(101, "Alice", "Inception", "A1", "2025-07-04 19:00");
        system.addTicket(102, "Bob", "Avatar", "B2", "2025-07-04 20:30");
        system.addTicket(103, "Charlie", "Inception", "C3", "2025-07-05 18:00");

        // Displaying all tickets
        system.displayTickets();

        // Search by customer name or movie name
        System.out.println("\nSearching tickets by keyword 'Inception':");
        system.searchTicket("Inception");

        // Remove a ticket
        System.out.println("\nRemoving ticket with ID 102:");
        system.removeTicket(102);
        system.displayTickets();

        // Total tickets
        System.out.println("Total booked tickets: " + system.getTotalTickets());
    }
}