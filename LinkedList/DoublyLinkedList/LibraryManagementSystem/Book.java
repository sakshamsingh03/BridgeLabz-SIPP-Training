package com.linkedlist.doublylinkedlist.librarymanagementsystem;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book prev;
    Book next;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.prev = null;
        this.next = null;
    }
}