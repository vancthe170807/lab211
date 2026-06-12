package controller;

import business.CandidateManager;
import business.SearchService;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;
import util.Inputter;
import util.Validator;
import view.CandidateMenu;
import view.ConsoleView;
import java.util.ArrayList;

/**
 * Main controller - Application entry point
 */
public class Main {

    private static CandidateManager candidateManager;
    private static SearchService searchService;

    /**
     * Entry point of the candidate management program
     */
    public static void main (String[] argsArray) {
        initialize ();
        run ();
    }

    /**
     * Initialize services and print application greeting
     */
    private static void initialize () {
        candidateManager = new CandidateManager ();
        searchService = new SearchService ();
        ConsoleView.displayHeader ("CANDIDATE MANAGEMENT SYSTEM");
    }

    /**
     * Main loops for menu choice handling and flow coordination
     */
    private static void run () {
        boolean running;
        int choice;

        running = true;

        // Main application loop - continues until user chooses to exit
        while (running) {
            CandidateMenu.displayMainMenu ();
            choice = Inputter.getInteger ("Enter your choice (1-5): ", 1, 5);

            // Handle user's menu choice
            switch (choice) {
                case 1:
                    createExperience (); // Create Experience candidate
                    break;
                case 2:
                    createFresher (); // Create Fresher candidate
                    break;
                case 3:
                    createIntern (); // Create Intern candidate
                    break;
                case 4:
                    searchCandidates (); // Search functionality
                    break;
                case 5:
                    exit (); // Exit program
                    running = false; // Stop the loop
                    break;
            }
        }
    }

    /**
     * Interactively collect Experience candidate data and save it
     */
    private static void createExperience () {
        String id;
        String firstName;
        String lastName;
        int birthDate;
        String address;
        String phone;
        String email;
        int expInYear;
        String proSkill;
        Experience exp;

        ConsoleView.displayHeader ("CREATE EXPERIENCE CANDIDATE");

        // Loop to allow creating multiple Experience candidates
        do {
            try {

                // Get candidate ID and check for duplicates
                id = Inputter.getString ("Enter ID: ");
                if (candidateManager.isDuplicateId (id)) {
                    ConsoleView.displayError ("ID already exists!");
                    continue; // Skip to next iteration if duplicate ID
                }

                // Collect all required candidate information
                firstName = Inputter.getString ("Enter First Name: ");
                lastName = Inputter.getString ("Enter Last Name: ");
                birthDate = Inputter.getBirthDate (new StringBuilder ()
                        .append ("Enter Birth Year (1900-")
                        .append (Validator.getCurrentYear ())
                        .append ("): ")
                        .toString ());
                address = Inputter.getString ("Enter Address: ");
                phone = Inputter.getPhone ("Enter Phone (min 10 digits): ");
                email = Inputter.getEmail ("Enter Email: ");
                expInYear = Inputter.getInteger ("Enter Years of Experience (0-100): ", 0, 100);
                proSkill = Inputter.getString ("Enter Professional Skills: ");

                // Create new Experience candidate object
                exp = new Experience (id, firstName, lastName, birthDate,
                                    address, phone, email, expInYear, proSkill);

                // Try to add candidate to manager
                if (candidateManager.addCandidate (exp)) {
                    ConsoleView.displaySuccess ("Experience candidate created successfully!");
                } else {
                    ConsoleView.displayError ("Failed to create candidate.");
                }
            } catch (Exception e) {

                // Catch any unexpected errors during creation
                ConsoleView.displayError (new StringBuilder ()
                        .append ("Error: ")
                        .append (e.getMessage ())
                        .toString ());
            }
        } while (Inputter.confirm ("Do you want to continue?")); // Ask user if they want to continue

        // Display all candidates if any were created
        if (candidateManager.getCandidateCount () > 0) {
            ConsoleView.displayAllGroupedByType (candidateManager.getAllCandidates ());
        }
    }

    /**
     * Interactively collect Fresher candidate data and save it
     */
    private static void createFresher () {
        String id;
        String firstName;
        String lastName;
        int birthDate;
        String address;
        String phone;
        String email;
        String gradDate;
        String gradRank;
        String education;
        Fresher fresher;

        ConsoleView.displayHeader ("CREATE FRESHER CANDIDATE");

        // Loop to allow creating multiple Fresher candidates
        do {
            try {

                // Get candidate ID and check for duplicates
                id = Inputter.getString ("Enter ID: ");
                if (candidateManager.isDuplicateId (id)) {
                    ConsoleView.displayError ("ID already exists!");
                    continue; // Skip to next iteration if duplicate ID
                }

                // Collect all required candidate information
                firstName = Inputter.getString ("Enter First Name: ");
                lastName = Inputter.getString ("Enter Last Name: ");
                birthDate = Inputter.getBirthDate (new StringBuilder ()
                        .append ("Enter Birth Year (1900-")
                        .append (Validator.getCurrentYear ())
                        .append ("): ")
                        .toString ());
                address = Inputter.getString ("Enter Address: ");
                phone = Inputter.getPhone ("Enter Phone (min 10 digits): ");
                email = Inputter.getEmail ("Enter Email: ");
                gradDate = Inputter.getString ("Enter Graduation Date: ");
                gradRank = Inputter.getGraduationRank ("Select Graduation Rank:");
                education = Inputter.getString ("Enter University/Education: ");

                // Create new Fresher candidate object
                fresher = new Fresher (id, firstName, lastName, birthDate,
                                     address, phone, email, gradDate, gradRank, education);

                // Try to add candidate to manager
                if (candidateManager.addCandidate (fresher)) {
                    ConsoleView.displaySuccess ("Fresher candidate created successfully!");
                } else {
                    ConsoleView.displayError ("Failed to create candidate.");
                }
            } catch (Exception e) {

                // Catch any unexpected errors during creation
                ConsoleView.displayError (new StringBuilder ()
                        .append ("Error: ")
                        .append (e.getMessage ())
                        .toString ());
            }
        } while (Inputter.confirm ("Do you want to continue?")); // Ask user if they want to continue

        // Display all candidates if any were created
        if (candidateManager.getCandidateCount () > 0) {
            ConsoleView.displayAllGroupedByType (candidateManager.getAllCandidates ());
        }
    }

    /**
     * Interactively collect Intern candidate data and save it
     */
    private static void createIntern () {
        String id;
        String firstName;
        String lastName;
        int birthDate;
        String address;
        String phone;
        String email;
        String majors;
        String semester;
        String university;
        Intern intern;

        ConsoleView.displayHeader ("CREATE INTERN CANDIDATE");

        // Loop to allow creating multiple Intern candidates
        do {
            try {

                // Get candidate ID and check for duplicates
                id = Inputter.getString ("Enter ID: ");
                if (candidateManager.isDuplicateId (id)) {
                    ConsoleView.displayError ("ID already exists!");
                    continue; // Skip to next iteration if duplicate ID
                }

                // Collect all required candidate information
                firstName = Inputter.getString ("Enter First Name: ");
                lastName = Inputter.getString ("Enter Last Name: ");
                birthDate = Inputter.getBirthDate (new StringBuilder ()
                        .append ("Enter Birth Year (1900-")
                        .append (Validator.getCurrentYear ())
                        .append ("): ")
                        .toString ());
                address = Inputter.getString ("Enter Address: ");
                phone = Inputter.getPhone ("Enter Phone (min 10 digits): ");
                email = Inputter.getEmail ("Enter Email: ");
                majors = Inputter.getString ("Enter Majors: ");
                semester = Inputter.getString ("Enter Semester: ");
                university = Inputter.getString ("Enter University Name: ");

                // Create new Intern candidate object
                intern = new Intern (id, firstName, lastName, birthDate,
                                   address, phone, email, majors, semester, university);

                // Try to add candidate to manager
                if (candidateManager.addCandidate (intern)) {
                    ConsoleView.displaySuccess ("Intern candidate created successfully!");
                } else {
                    ConsoleView.displayError ("Failed to create candidate.");
                }
            } catch (Exception e) {

                // Catch any unexpected errors during creation
                ConsoleView.displayError (new StringBuilder ()
                        .append ("Error: ")
                        .append (e.getMessage ())
                        .toString ());
            }
        } while (Inputter.confirm ("Do you want to continue?")); // Ask user if they want to continue

        // Display all candidates if any were created
        if (candidateManager.getCandidateCount () > 0) {
            ConsoleView.displayAllGroupedByType (candidateManager.getAllCandidates ());
        }
    }

    /**
     * Display current candidates and perform user search
     */
    private static void searchCandidates () {
        ArrayList<Candidate> allCandidatesList;
        String searchName;
        int searchType;
        ArrayList<Candidate> resultsList;

        ConsoleView.displayHeader ("SEARCHING");

        // Get all candidates from manager
        allCandidatesList = candidateManager.getAllCandidates ();

        // Check if there are any candidates to search
        if (allCandidatesList.isEmpty ()) {
            ConsoleView.displayInfo ("No candidates available. Please create candidates first.");
            return; // Exit if no candidates exist
        }

        // Display all candidates grouped by type before searching
        ConsoleView.displayAllGroupedByType (allCandidatesList);

        // Get search criteria from user
        searchName = Inputter.getString (new StringBuilder ()
                .append ("\n")
                .append ("Input Candidate name (First name or Last name): ")
                .toString ());
        searchType = Inputter.getInteger (new StringBuilder ()
                .append ("Input type of candidate ")
                .append ("(0-Experience, 1-Fresher, 2-Intern): ")
                .toString (), 0, 2);

        // Perform search and display results
        resultsList = searchService.search (allCandidatesList, searchName, searchType);
        ConsoleView.displaySearchResults (resultsList);
    }

    /**
     * Terminate the application gracefully and print summary info
     */
    private static void exit () {
        ConsoleView.displayInfo ("Thank you for using Candidate Management System!");
        System.out.println (new StringBuilder ()
                .append ("Total candidates managed: ")
                .append (candidateManager.getCandidateCount ())
                .toString ());
    }
}
