package controller;

import business.*;
import model.*;
import util.*;
import view.*;

import java.util.ArrayList;

/**
 * Main controller - Application entry point
 */
public class Main {
    private static CandidateManager candidateManager;
    private static SearchService searchService;

    public static void main(String[] args) {
        initialize();
        run();
    }

    private static void initialize() {
        candidateManager = new CandidateManager();
        searchService = new SearchService();
        ConsoleView.displayHeader("CANDIDATE MANAGEMENT SYSTEM");
    }

    private static void run() {
        boolean running = true;

        // Main application loop - continues until user chooses to exit
        while (running) {
            CandidateMenu.displayMainMenu();
            int choice = Inputter.getInteger("Enter your choice (1-5): ", 1, 5);

            // Handle user's menu choice
            switch (choice) {
                case 1:
                    createExperience(); // Create Experience candidate
                    break;
                case 2:
                    createFresher(); // Create Fresher candidate
                    break;
                case 3:
                    createIntern(); // Create Intern candidate
                    break;
                case 4:
                    searchCandidates(); // Search functionality
                    break;
                case 5:
                    exit(); // Exit program
                    running = false; // Stop the loop
                    break;
            }
        }
    }

    private static void createExperience() {
        ConsoleView.displayHeader("CREATE EXPERIENCE CANDIDATE");

        // Loop to allow creating multiple Experience candidates
        do {
            try {
                // Get candidate ID and check for duplicates
                String id = Inputter.getString("Enter ID: ");
                if (candidateManager.isDuplicateId(id)) {
                    ConsoleView.displayError("ID already exists!");
                    continue; // Skip to next iteration if duplicate ID
                }

                // Collect all required candidate information
                String firstName = Inputter.getString("Enter First Name: ");
                String lastName = Inputter.getString("Enter Last Name: ");
                int birthDate = Inputter.getBirthDate("Enter Birth Year (1900-" +
                                                     Validator.getCurrentYear() + "): ");
                String address = Inputter.getString("Enter Address: ");
                String phone = Inputter.getPhone("Enter Phone (min 10 digits): ");
                String email = Inputter.getEmail("Enter Email: ");
                int expInYear = Inputter.getInteger("Enter Years of Experience (0-100): ", 0, 100);
                String proSkill = Inputter.getString("Enter Professional Skills: ");

                // Create new Experience candidate object
                Experience exp = new Experience(id, firstName, lastName, birthDate,
                                              address, phone, email, expInYear, proSkill);

                // Try to add candidate to manager
                if (candidateManager.addCandidate(exp)) {
                    ConsoleView.displaySuccess("Experience candidate created successfully!");
                } else {
                    ConsoleView.displayError("Failed to create candidate.");
                }

            } catch (Exception e) {
                // Catch any unexpected errors during creation
                ConsoleView.displayError("Error: " + e.getMessage());
            }
        } while (Inputter.confirm("Do you want to continue?")); // Ask user if they want to continue

        // Display all candidates if any were created
        if (candidateManager.getCandidateCount() > 0) {
            searchService.displayAllGroupedByType(candidateManager.getAllCandidates());
        }
    }

    private static void createFresher() {
        ConsoleView.displayHeader("CREATE FRESHER CANDIDATE");

        // Loop to allow creating multiple Fresher candidates
        do {
            try {
                // Get candidate ID and check for duplicates
                String id = Inputter.getString("Enter ID: ");
                if (candidateManager.isDuplicateId(id)) {
                    ConsoleView.displayError("ID already exists!");
                    continue; // Skip to next iteration if duplicate ID
                }

                // Collect all required candidate information
                String firstName = Inputter.getString("Enter First Name: ");
                String lastName = Inputter.getString("Enter Last Name: ");
                int birthDate = Inputter.getBirthDate("Enter Birth Year (1900-" +
                                                     Validator.getCurrentYear() + "): ");
                String address = Inputter.getString("Enter Address: ");
                String phone = Inputter.getPhone("Enter Phone (min 10 digits): ");
                String email = Inputter.getEmail("Enter Email: ");
                String gradDate = Inputter.getString("Enter Graduation Date: ");
                String gradRank = Inputter.getGraduationRank("Select Graduation Rank:");
                String education = Inputter.getString("Enter University/Education: ");

                // Create new Fresher candidate object
                Fresher fresher = new Fresher(id, firstName, lastName, birthDate,
                                             address, phone, email, gradDate, gradRank, education);

                // Try to add candidate to manager
                if (candidateManager.addCandidate(fresher)) {
                    ConsoleView.displaySuccess("Fresher candidate created successfully!");
                } else {
                    ConsoleView.displayError("Failed to create candidate.");
                }

            } catch (Exception e) {
                // Catch any unexpected errors during creation
                ConsoleView.displayError("Error: " + e.getMessage());
            }
        } while (Inputter.confirm("Do you want to continue?")); // Ask user if they want to continue

        // Display all candidates if any were created
        if (candidateManager.getCandidateCount() > 0) {
            searchService.displayAllGroupedByType(candidateManager.getAllCandidates());
        }
    }

    private static void createIntern() {
        ConsoleView.displayHeader("CREATE INTERN CANDIDATE");

        // Loop to allow creating multiple Intern candidates
        do {
            try {
                // Get candidate ID and check for duplicates
                String id = Inputter.getString("Enter ID: ");
                if (candidateManager.isDuplicateId(id)) {
                    ConsoleView.displayError("ID already exists!");
                    continue; // Skip to next iteration if duplicate ID
                }

                // Collect all required candidate information
                String firstName = Inputter.getString("Enter First Name: ");
                String lastName = Inputter.getString("Enter Last Name: ");
                int birthDate = Inputter.getBirthDate("Enter Birth Year (1900-" +
                                                     Validator.getCurrentYear() + "): ");
                String address = Inputter.getString("Enter Address: ");
                String phone = Inputter.getPhone("Enter Phone (min 10 digits): ");
                String email = Inputter.getEmail("Enter Email: ");
                String majors = Inputter.getString("Enter Majors: ");
                String semester = Inputter.getString("Enter Semester: ");
                String university = Inputter.getString("Enter University Name: ");

                // Create new Intern candidate object
                Intern intern = new Intern(id, firstName, lastName, birthDate,
                                          address, phone, email, majors, semester, university);

                // Try to add candidate to manager
                if (candidateManager.addCandidate(intern)) {
                    ConsoleView.displaySuccess("Intern candidate created successfully!");
                } else {
                    ConsoleView.displayError("Failed to create candidate.");
                }

            } catch (Exception e) {
                // Catch any unexpected errors during creation
                ConsoleView.displayError("Error: " + e.getMessage());
            }
        } while (Inputter.confirm("Do you want to continue?")); // Ask user if they want to continue

        // Display all candidates if any were created
        if (candidateManager.getCandidateCount() > 0) {
            searchService.displayAllGroupedByType(candidateManager.getAllCandidates());
        }
    }

    private static void searchCandidates() {
        ConsoleView.displayHeader("SEARCHING");

        // Get all candidates from manager
        ArrayList<Candidate> allCandidates = candidateManager.getAllCandidates();

        // Check if there are any candidates to search
        if (allCandidates.isEmpty()) {
            ConsoleView.displayInfo("No candidates available. Please create candidates first.");
            return; // Exit if no candidates exist
        }

        // Display all candidates grouped by type before searching
        searchService.displayAllGroupedByType(allCandidates);

        // Get search criteria from user
        String searchName = Inputter.getString("\nInput Candidate name (First name or Last name): ");
        int searchType = Inputter.getInteger("Input type of candidate (0-Experience, 1-Fresher, 2-Intern): ", 0, 2);

        // Perform search and display results
        ArrayList<Candidate> results = searchService.search(allCandidates, searchName, searchType);
        searchService.displaySearchResults(results);
    }

    private static void exit() {
        ConsoleView.displayInfo("Thank you for using Candidate Management System!");
        System.out.println("Total candidates managed: " + candidateManager.getCandidateCount());
    }
}
