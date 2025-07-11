package com.linkedlist.singlylinkedlist.socialmediafriendconnections;

public class Main {
	public static void main(String[] args) {
        FriendConnectionManager manager = new FriendConnectionManager();

        // Adding sample users
        manager.addUser(1, "Ayush", 25);
        manager.addUser(2, "Anubhav", 28);
        manager.addUser(3, "Divanshu", 22);
        manager.addUser(4, "Prakash", 27);
        manager.addUser(5, "Utkarsh", 24);

        // Adding friend connections
        manager.addFriendConnection(1, 2);
        manager.addFriendConnection(1, 3);
        manager.addFriendConnection(2, 3);
        manager.addFriendConnection(2, 4);
        manager.addFriendConnection(4, 5);

        System.out.println("\nDisplaying Friends of User 2:");
        manager.displayFriends(2);

        System.out.println("\nFinding Mutual Friends between User 1 and User 2:");
        manager.findMutualFriends(1, 2);

        System.out.println("\nSearching for user with name 'Divanshu':");
        manager.searchUser("Divanshu");

        System.out.println("\nCounting number of friends for all users:");
        manager.countFriends();

        System.out.println("\nRemoving Friend Connection between User 2 and User 3:");
        manager.removeFriendConnection(2, 3);
        manager.displayFriends(2);
    }
}