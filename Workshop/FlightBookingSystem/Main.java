package com.flightbookingsystem;

import java.util.*;

public class Main {
	static Flight[] availableFlights = {
			new Flight("AI101", "Delhi", "Mumbai", 4500),
			new Flight("AI202", "Chennai", "Bangalore", 3200),
			new Flight("AI303", "Delhi", "Bangalore", 5600),
			new Flight("AI404", "Mumbai", "Kolkata", 6000)
	};

	static List<Booking> bookings = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	static void searchFlights(String source, String destination) {
		boolean found = false;
		for (Flight f : availableFlights) {
			if (f.source.equalsIgnoreCase(source) && f.destination.equalsIgnoreCase(destination)) {
				System.out.println(f);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No flights found between " + source + " and " + destination);
		}
	}

	static void bookFlight(String flightNumber, String passengerName) {
		for (Flight f : availableFlights) {
			if (f.flightNumber.equalsIgnoreCase(flightNumber)) {
				bookings.add(new Booking(passengerName, f));
				System.out.println("Booking confirmed for " + passengerName + " on flight " + flightNumber);
				return;
			}
		}
		System.out.println("Flight number " + flightNumber + " not found.");
	}

	static void viewBookings() {
		if (bookings.isEmpty()) {
			System.out.println("No bookings yet.");
		} else {
			for (Booking b : bookings) {
				System.out.println(b);
			}
		}
	}

	public static void main(String[] args) {
		while (true) {
			System.out.println("\n1. Search Flights\n2. Book Flight\n3. View Bookings\n4. Exit");
			System.out.print("Choose an option: ");
			int choice = sc.nextInt();
			sc.nextLine(); // consume newline

			switch (choice) {
				case 1:
					System.out.print("From: ");
					String from = sc.nextLine();
					System.out.print("To: ");
					String to = sc.nextLine();
					searchFlights(from, to);
					break;
				case 2:
					System.out.print("Enter flight number: ");
					String fn = sc.nextLine();
					System.out.print("Enter passenger name: ");
					String name = sc.nextLine();
					bookFlight(fn, name);
					break;
				case 3:
					viewBookings();
					break;
				case 4:
					System.out.println("Thank you for using our Flight Booking System!");
					return;
				default:
					System.out.println("Invalid option. Try again.");
			}
		}
	}
}