package business;

import model.Candidate;
import view.ConsoleView;
import java.util.ArrayList;

/**
 * Handle search operations
 */
public class SearchService {
    /**
     * Search candidates by name (first or last) - case insensitive
     */
    public ArrayList<Candidate> searchByName(ArrayList<Candidate> candidates, String name) {
        ArrayList<Candidate> results = new ArrayList<>();
        // Convert search name to lowercase for case-insensitive search
        String searchName = name.toLowerCase().trim();

        // Loop through all candidates
        for (Candidate candidate : candidates) {
            // Convert candidate names to lowercase for comparison
            String firstName = candidate.getFirstName().toLowerCase();
            String lastName = candidate.getLastName().toLowerCase();

            // Check if search name is found in first name or last name (partial match)
            if (firstName.contains(searchName) || lastName.contains(searchName)) {
                results.add(candidate); // Add matching candidate to results
            }
        }
        return results; // Return list of matching candidates
    }

    /**
     * Search candidates by type
     */
    public ArrayList<Candidate> searchByType(ArrayList<Candidate> candidates, int type) {
        ArrayList<Candidate> results = new ArrayList<>();
        // Loop through all candidates
        for (Candidate candidate : candidates) {
            // Check if candidate type matches requested type
            if (candidate.getType() == type) {
                results.add(candidate); // Add matching candidate to results
            }
        }
        return results; // Return filtered list by type
    }

    /**
     * Combined search by name and type
     */
    public ArrayList<Candidate> search(ArrayList<Candidate> candidates, String name, int type) {
        ArrayList<Candidate> byType = searchByType(candidates, type);
        return searchByName(byType, name);
    }

    /**
     * Display all candidates grouped by type
     */
    public void displayAllGroupedByType(ArrayList<Candidate> candidates) {
        // Check if candidate list is empty
        if (candidates.isEmpty()) {
            ConsoleView.displayInfo("No candidates found.");
            return; // Exit if no candidates
        }

        System.out.println("\nList of candidate:");

        // Create separate lists for each candidate type
        ArrayList<Candidate> experience = new ArrayList<>();
        ArrayList<Candidate> fresher = new ArrayList<>();
        ArrayList<Candidate> intern = new ArrayList<>();

        // Loop through all candidates and group by type
        for (Candidate candidate : candidates) {
            // Switch based on candidate type to add to appropriate list
            switch (candidate.getType()) {
                case 0: experience.add(candidate); break; // Type 0: Experience
                case 1: fresher.add(candidate); break;    // Type 1: Fresher
                case 2: intern.add(candidate); break;     // Type 2: Intern
            }
        }

        // Display each group with header
        System.out.println("\n===========EXPERIENCE CANDIDATE============");
        ConsoleView.displayCandidateNames(experience);

        System.out.println("\n==========FRESHER CANDIDATE==============");
        ConsoleView.displayCandidateNames(fresher);

        System.out.println("\n===========INTERN CANDIDATE==============");
        ConsoleView.displayCandidateNames(intern);
    }

    /**
     * Display search results
     */
    public void displaySearchResults(ArrayList<Candidate> results) {
        // Check if search returned any results
        if (results.isEmpty()) {
            ConsoleView.displayInfo("No candidates found matching your criteria.");
        } else {
            // Display header for results
            System.out.println("\nThe candidates found:");
            // Loop through all matching candidates
            for (Candidate candidate : results) {
                candidate.display(); // Display each candidate (polymorphic call)
            }
        }
    }
}
