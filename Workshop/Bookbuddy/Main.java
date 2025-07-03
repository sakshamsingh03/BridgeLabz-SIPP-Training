package com.bookbuddy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book myLibrary = new Book();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== BookBuddy Menu ====");
            System.out.println("1. Add Book");
            System.out.println("2. Sort Books Alphabetically");
            System.out.println("3. Search by Author");
            System.out.println("4. Display all available book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    myLibrary.addBook(title, author);
                    break;
                case 2:
                    myLibrary.sortBookAlphabetically();
                    System.out.println("Books sorted!");
                    break;
                case 3:
                    System.out.print("Enter author name to search: ");
                    String searchAuthor = scanner.nextLine();
                    myLibrary.searchByAuthor(searchAuthor);
                    break;
                case 4:
                	System.out.println("All available books: ");
                	myLibrary.display();
                	break;
                case 5:
                    System.out.println("Exiting");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}