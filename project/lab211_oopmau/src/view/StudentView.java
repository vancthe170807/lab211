package view;

import java.util.List;
import model.Student;

/**
 * Handles presentation and printing of information to the console.
 */
public class StudentView {

    /**
     * Displays the main menu choices.
     */
    public void displayMenu() {
        System.out.println("\n========= STUDENT MANAGEMENT =========");
        System.out.println("1. Add Student");
        System.out.println("2. Search Student by Name");
        System.out.println("3. Edit Student by ID");
        System.out.println("4. Delete Student by ID");
        System.out.println("5. Display All Students");
        System.out.println("6. Exit");
    }

    /**
     * Displays a header for the student table.
     */
    public void displayStudentHeader() {
        System.out.println(String.format("\n%-10s | %-20s | %-5s | %-6s | %-6s | %-6s | %-6s", 
                "ID", "Name", "Age", "Math", "Physics", "Chem", "Sum"));
        System.out.println("-------------------------------------------------------------------------");
    }

    /**
     * Displays a list of students as a formatted table.
     */
    public void displayStudentList(List<Student> students) {
        if (students == null || students.isEmpty()) {
            System.out.println("No students found in the list.");
            return;
        }
        displayStudentHeader();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     * Displays general messages.
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays warning/error messages.
     */
    public void displayError(String error) {
        System.err.println("Error: " + error);
    }
}
