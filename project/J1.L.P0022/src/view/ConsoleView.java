package view;

import model.Candidate;
import java.util.ArrayList;

/**
 * Display utilities for console output
 */
public class ConsoleView {
    /**
     * Display header with borders
     */
    public static void displayHeader(String title) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("  " + title);
        System.out.println("=".repeat(50));
    }

    /**
     * Display separator
     */
    public static void displaySeparator() {
        System.out.println("=".repeat(50));
    }

    /**
     * Display success message
     */
    public static void displaySuccess(String message) {
        System.out.println("\n[SUCCESS] " + message);
    }

    /**
     * Display error message
     */
    public static void displayError(String message) {
        System.out.println("\n[ERROR] " + message);
    }

    /**
     * Display info message
     */
    public static void displayInfo(String message) {
        System.out.println("\n[INFO] " + message);
    }

    /**
     * Display candidate list by name only
     */
    public static void displayCandidateNames(ArrayList<Candidate> candidates) {
        // Check if the candidate list is empty
        if (candidates.isEmpty()) {
            System.out.println("No candidates found."); // No candidates to display
        } else {
            // List is not empty, loop through all candidates to display their names
            for (Candidate candidate : candidates) {
                // Display each candidate's full name (first name + last name)
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
    }
}
