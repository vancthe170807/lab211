package business;

import model.Candidate;
import java.util.ArrayList;

/**
 * Manage candidate collection and operations
 */
public class CandidateManager {

    private ArrayList<Candidate> candidatesList;

    /**
     * Constructor for CandidateManager
     */
    public CandidateManager () {
        this.candidatesList = new ArrayList<> ();
    }

    /**
     * Add candidate with duplicate ID checking
     */
    public boolean addCandidate (Candidate candidate) {
        try {

            // Check if ID already exists in the list
            if (isDuplicateId (candidate.getId ())) {
                return false; // Duplicate ID, cannot add
            }

            // Add candidate to the ArrayList
            candidatesList.add (candidate);
            return true; // Successfully added
        } catch (Exception e) {

            // Catch any unexpected errors during addition
            return false; // Failed to add
        }
    }

    /**
     * Check if ID already exists
     */
    public boolean isDuplicateId (String id) {

        // Loop through all existing candidates
        for (Candidate candidate : candidatesList) {

            // Compare IDs case-insensitively
            if (candidate.getId ().equalsIgnoreCase (id)) {
                return true; // Found duplicate ID
            }
        }

        // No duplicate found
        return false;
    }

    /**
     * Get all candidates
     */
    public ArrayList<Candidate> getAllCandidates () {
        return candidatesList;
    }

    /**
     * Get candidates by type
     */
    public ArrayList<Candidate> getCandidatesByType (int type) {
        ArrayList<Candidate> resultList;

        resultList = new ArrayList<> ();

        // Loop through all candidates
        for (Candidate candidate : candidatesList) {

            // Check if candidate type matches the requested type
            if (candidate.getType () == type) {
                resultList.add (candidate); // Add matching candidate to resultList
            }
        }

        return resultList; // Return filtered list
    }

    /**
     * Get candidate count
     */
    public int getCandidateCount () {
        return candidatesList.size ();
    }
}
