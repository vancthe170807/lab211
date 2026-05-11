package business;

import model.Candidate;
import java.util.ArrayList;

/**
 * Manage candidate collection and operations
 */
public class CandidateManager {
    private ArrayList<Candidate> candidates;

    public CandidateManager() {
        this.candidates = new ArrayList<>();
    }

    /**
     * Add candidate with duplicate ID checking
     */
    public boolean addCandidate(Candidate candidate) {
        try {
            // Check if ID already exists in the list
            if (isDuplicateId(candidate.getId())) {
                return false; // Duplicate ID, cannot add
            }
            // Add candidate to the ArrayList
            candidates.add(candidate);
            return true; // Successfully added
        } catch (Exception e) {
            // Catch any unexpected errors during addition
            return false; // Failed to add
        }
    }

    /**
     * Check if ID already exists
     */
    public boolean isDuplicateId(String id) {
        // Loop through all existing candidates
        for (Candidate candidate : candidates) {
            // Compare IDs case-insensitively
            if (candidate.getId().equalsIgnoreCase(id)) {
                return true; // Found duplicate ID
            }
        }
        // No duplicate found
        return false;
    }

    /**
     * Get all candidates
     */
    public ArrayList<Candidate> getAllCandidates() {
        return candidates;
    }

    /**
     * Get candidates by type
     */
    public ArrayList<Candidate> getCandidatesByType(int type) {
        ArrayList<Candidate> result = new ArrayList<>();
        // Loop through all candidates
        for (Candidate candidate : candidates) {
            // Check if candidate type matches the requested type
            if (candidate.getType() == type) {
                result.add(candidate); // Add matching candidate to result
            }
        }
        return result; // Return filtered list
    }

    /**
     * Get candidate count
     */
    public int getCandidateCount() {
        return candidates.size();
    }
}
