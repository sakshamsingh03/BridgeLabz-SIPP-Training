package com.interfac;

import java.util.*;

public class VotingSystem {
    // HashMap to store candidate -> vote count
    private Map<String, Integer> voteMap = new HashMap<>();

    // LinkedHashMap to maintain order of votes cast
    private Map<Integer, String> voteOrder = new LinkedHashMap<>();
    private int voteId = 1;

    // Cast a vote
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrder.put(voteId++, candidate);
        System.out.println("Vote cast for: " + candidate);
    }

    // Display raw votes (LinkedHashMap) in order of casting
    public void displayVoteOrder() {
        System.out.println("\nVotes Cast in Order:");
        for (Map.Entry<Integer, String> entry : voteOrder.entrySet()) {
            System.out.println("Vote ID " + entry.getKey() + " → " + entry.getValue());
        }
    }

    // Display final results (HashMap)
    public void displayResults() {
        System.out.println("\nFinal Vote Count:");
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    // Display sorted results (TreeMap)
    public void displaySortedResults() {
        System.out.println("\nResults in Sorted Order (by Candidate Name):");
        Map<String, Integer> sorted = new TreeMap<>(voteMap);
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    // Main method to test
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        // Cast some votes
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");
        system.castVote("Alice");

        // Display all required views
        system.displayVoteOrder();
        system.displayResults();
        system.displaySortedResults();
    }
}
