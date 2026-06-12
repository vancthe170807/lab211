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
    public static void displayHeader (String title) {
        System.out.println (new StringBuilder ()
                .append ("\n")
                .append ("=".repeat (50))
                .toString ());
        System.out.println (new StringBuilder ()
                .append ("  ")
                .append (title)
                .toString ());
        System.out.println ("=".repeat (50));
    }

    /**
     * Display separator
     */
    public static void displaySeparator () {
        System.out.println ("=".repeat (50));
    }

    /**
     * Display success message
     */
    public static void displaySuccess (String message) {
        System.out.println (new StringBuilder ()
                .append ("\n[SUCCESS] ")
                .append (message)
                .toString ());
    }

    /**
     * Display error message
     */
    public static void displayError (String message) {
        System.out.println (new StringBuilder ()
                .append ("\n[ERROR] ")
                .append (message)
                .toString ());
    }

    /**
     * Display info message
     */
    public static void displayInfo (String message) {
        System.out.println (new StringBuilder ()
                .append ("\n[INFO] ")
                .append (message)
                .toString ());
    }

    /**
     * Display candidate list by name only
     */
    public static void displayCandidateNames (ArrayList<Candidate> candidateList) {

        // Check if the candidate list is empty
        if (candidateList.isEmpty ()) {
            System.out.println ("No candidates found."); // No candidates to display
        } else {

            // List is not empty, loop through all candidates to display their names
            for (Candidate candidate : candidateList) {
                System.out.println (new StringBuilder ()
                        .append (candidate.getFirstName ())
                        .append (" ")
                        .append (candidate.getLastName ())
                        .toString ());
            }
        }
    }

    /**
     * Display all candidates grouped by type
     */
    public static void displayAllGroupedByType (ArrayList<Candidate> candidateList) {
        ArrayList<Candidate> experienceList;
        ArrayList<Candidate> fresherList;
        ArrayList<Candidate> internList;

        // Check if candidate list is empty
        if (candidateList.isEmpty ()) {
            displayInfo ("No candidates found.");
            return; // Exit if no candidates
        }

        System.out.println ("\nList of candidate:");
        experienceList = new ArrayList<> ();
        fresherList = new ArrayList<> ();
        internList = new ArrayList<> ();

        // Loop through all candidates and group by type
        for (Candidate candidate : candidateList) {

            // Switch based on candidate type to add to appropriate list
            switch (candidate.getType ()) {
                case 0:
                    experienceList.add (candidate);
                    break; // Type 0: Experience
                case 1:
                    fresherList.add (candidate);
                    break; // Type 1: Fresher
                case 2:
                    internList.add (candidate);
                    break; // Type 2: Intern
            }
        }

        System.out.println ("\n===========EXPERIENCE CANDIDATE============");
        displayCandidateNames (experienceList);
        System.out.println ("\n==========FRESHER CANDIDATE==============");
        displayCandidateNames (fresherList);
        System.out.println ("\n===========INTERN CANDIDATE==============");
        displayCandidateNames (internList);
    }

    /**
     * Display search results
     */
    public static void displaySearchResults (ArrayList<Candidate> resultsList) {

        // Check if search returned any results
        if (resultsList.isEmpty ()) {
            displayInfo ("No candidates found matching your criteria.");
        } else {
            System.out.println ("\nThe candidates found:");

            // Loop through all matching candidates
            for (Candidate candidate : resultsList) {
                System.out.println (candidate.toString ());
            }
        }
    }
}
