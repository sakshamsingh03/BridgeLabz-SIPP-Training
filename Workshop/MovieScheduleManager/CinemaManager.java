package com.movieschedulemanager;
import java.util.*;


public class CinemaManager {
    private List<String> movieTitles = new ArrayList<>();
    private List<String> showtimes = new ArrayList<>();

    // Adds a movie if the time format is valid
    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        movieTitles.add(title);
        showtimes.add(time);
        System.out.println("Added: " + title + " at " + time);
    }

    // Validates time format as HH:MM (24-hour)
    private boolean isValidTime(String sTime) throws InvalidTimeFormatException {
		try {
			String[] hr_min=sTime.split(":");
			
			if((Integer.parseInt(hr_min[0])>0 && Integer.parseInt(hr_min[0])<24) && (Integer.parseInt(hr_min[1])>=0 && Integer.parseInt(hr_min[1])<60)) {
				return true;
			}
			return false;
		}
		catch(Exception E) {
			throw new InvalidTimeFormatException("InvalidTimeFormat");
		}
	}
    // Searches movies by keyword in title
    public void searchMovie(String keyword) {
        boolean found = false;
        for (int i = 0; i < movieTitles.size(); i++) {
            String title = movieTitles.get(i);
            if (title.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(String.format("Match %d: %s at %s", i, title, showtimes.get(i)));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching movies found for keyword: " + keyword);
            System.out.println("All Available mobies: ");
            displayAllMovies();
        }
    }

    // Displays all movies and showtimes
    public void displayAllMovies() {
        if (movieTitles.isEmpty()) {
            System.out.println("No movies to display.");
        } else {
            for (int i = 0; i < movieTitles.size(); i++) {
                System.out.println(String.format("Movie %d: %s at %s", i + 1, movieTitles.get(i), showtimes.get(i)));
            }
        }
    }

    // Generates a printable report as an array
    public String[] generateReport() {
        String[] report = new String[movieTitles.size()];
        for (int i = 0; i < movieTitles.size(); i++) {
            report[i] = movieTitles.get(i) + " - " + showtimes.get(i);
        }
        return report;
    }

}