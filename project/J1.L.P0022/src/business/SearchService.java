package business;

import model.Candidate;
import java.util.ArrayList;

/**
 * Handle search operations
 */
public class SearchService {

    /**
     * Search candidates by name (first or last) - case insensitive
     */
    public ArrayList<Candidate> searchByName (ArrayList<Candidate> candidateList, String name) {
        ArrayList<Candidate> resultsList;
        String searchName;

        resultsList = new ArrayList<> ();

        // Convert search name to lowercase for case-insensitive search
        searchName = name.toLowerCase ().trim ();

        // Loop through all candidates
        for (Candidate candidate : candidateList) {
            String firstName;
            String lastName;

            firstName = candidate.getFirstName ().toLowerCase ();
            lastName = candidate.getLastName ().toLowerCase ();

            // Check if search name is found in first name or last name (partial match)
            if (firstName.contains (searchName) || lastName.contains (searchName)) {
                resultsList.add (candidate); // Add matching candidate to resultsList
            }
        }

        return resultsList; // Return list of matching candidates
    }

    /**
     * Search candidates by type
     */
    public ArrayList<Candidate> searchByType (ArrayList<Candidate> candidateList, int type) {
        ArrayList<Candidate> resultsList;

        resultsList = new ArrayList<> ();

        // Loop through all candidates
        for (Candidate candidate : candidateList) {

            // Check if candidate type matches requested type
            if (candidate.getType () == type) {
                resultsList.add (candidate); // Add matching candidate to resultsList
            }
        }

        return resultsList; // Return filtered list by type
    }

    /**
     * Combined search by name and type
     */
    public ArrayList<Candidate> search (ArrayList<Candidate> candidateList, String name, int type) {
        ArrayList<Candidate> byTypeList;

        byTypeList = searchByType (candidateList, type);
        return searchByName (byTypeList, name);
    }
}
