package com.flightbookingsystem;

class Flight {
    String flightNumber;
    String source;
    String destination;
    double price;

    Flight(String flightNumber, String source, String destination, double price) {
        this.flightNumber = flightNumber;
        this.source = source.toLowerCase();
        this.destination = destination.toLowerCase();
        this.price = price;
    }

    public String toString() {
        return "Flight " + flightNumber + " from " + source + " to " + destination + " for ₹" + price;
    }
}