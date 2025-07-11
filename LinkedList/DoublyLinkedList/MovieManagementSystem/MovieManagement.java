package com.linkedlist.doublylinkedlist.moviemanagementsystem;

public class MovieManagement {
	private Movie head;
    private Movie tail;

    // Add movie at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add movie at end
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add movie at specific position (1-based indexing)
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newMovie.next = current.next;
        newMovie.prev = current;
        if (current.next != null) {
            current.next.prev = newMovie;
        } else {
            tail = newMovie;
        }
        current.next = newMovie;
    }

    // Remove movie by title
    public void removeByTitle(String title) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Movie '" + title + "' removed successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }

    // Search movie by director or rating
    public void searchMovie(String key) {
        boolean found = false;
        Movie current = head;
        while (current != null) {
            if (current.director.equalsIgnoreCase(key) || String.valueOf(current.rating).equals(key)) {
                displayMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movie records found for search key: " + key);
        }
    }

    // Update rating by title
    public void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated successfully for movie: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }

    // Display all movies forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }

        System.out.println("Movies (Forward Order):");
        Movie current = head;
        while (current != null) {
            displayMovie(current);
            current = current.next;
        }
    }

    // Display all movies in reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }

        System.out.println("Movies (Reverse Order):");
        Movie current = tail;
        while (current != null) {
            displayMovie(current);
            current = current.prev;
        }
    }

    // Helper method to display movie details
    private void displayMovie(Movie movie) {
        System.out.println("Title: " + movie.title);
        System.out.println("Director: " + movie.director);
        System.out.println("Year of Release: " + movie.yearOfRelease);
        System.out.println("Rating: " + movie.rating);
        System.out.println("--------------------------------");
    }
}