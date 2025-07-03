package com.flightbookingsystem;

class Booking {
    String passengerName;
    Flight flight;

    Booking(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }

    public String toString() {
        return "Booking for " + passengerName + ": " + flight;
    }
}