package controller;

import java.util.List;
import model.Student;
import model.StudentModel;
import view.StudentView;
import utils.Validation;

/**
 * Controller class to manage the workflow and coordinate Model and View.
 */
public class StudentController {
    private final StudentModel model;
    private final StudentView view;
    private final Validation validation;

    /**
     * Constructor for StudentController
     * @param model StudentModel instance
     * @param view StudentView instance
     * @param validation Validation instance
     */
    public StudentController(StudentModel model, StudentView view, Validation validation) {
        this.model = model;
        this.view = view;
        this.validation = validation;
    }

    /**
     * Starts the main controller loop.
     */
    public void run() {
        while (true) {
            view.displayMenu();
            int choice = validation.inputInt("Enter choice", 1, 6);
            switch (choice) {
                case 1:
                    handleAddStudent();
                    break;
                case 2:
                    handleSearchStudent();
                    break;
                case 3:
                    handleEditStudent();
                    break;
                case 4:
                    handleDeleteStudent();
                    break;
                case 5:
                    handleDisplayAll();
                    break;
                case 6:
                    view.displayMessage("Thank you for using the system. Goodbye!");
                    return;
                default:
                    view.displayError("Invalid option.");
            }
        }
    }

    /**
     * Handles the process of adding a new student.
     * Prompts the user for student details, validates the input,
     * and adds the student to the model.
     */
    private void handleAddStudent() {
        do {
            view.displayMessage("\n--- Add New Student ---");
            String id;
            while (true) {
                id = validation.inputString("Enter Student ID");
                if (model.getStudent(id) == null) {
                    break;
                }
                view.displayMessage("Error: Student ID already exists. Please enter a different ID.");
            }
            
            String name = validation.inputString("Enter Student Name");
            int age = validation.inputInt("Enter Age", 18, 100);
            double math = validation.inputDouble("Enter Math Grade", 0.0, 10.0);
            double physics = validation.inputDouble("Enter Physics Grade", 0.0, 10.0);
            double chemistry = validation.inputDouble("Enter Chemistry Grade", 0.0, 10.0);

            Student student = new Student(id, name, age, math, physics, chemistry);
            if (model.addStudent(student)) {
                view.displayMessage("Student added successfully.");
            } else {
                view.displayError("Failed to add student due to duplicate ID.");
            }
        } while (validation.inputYesNo("Do you want to continue adding students?"));
    }

    /**
     * Handles the process of searching for a student.
     * Prompts the user for a search query and displays matching students.
     */
    private void handleSearchStudent() {
        view.displayMessage("\n--- Search Student ---");
        String query = validation.inputString("Enter name to search");
        List<Student> results = model.findStudentsByName(query);
        if (results.isEmpty()) {
            view.displayMessage("No students match the search query.");
        } else {
            view.displayStudentList(results);
        }
    }

    /**
     * Handles the process of editing a student's details.
     * Prompts the user for the student ID and new details,
     * and updates the student's information in the model.
     */
    private void handleEditStudent() {
        view.displayMessage("\n--- Edit Student Details ---");
        String id = validation.inputString("Enter Student ID to edit");
        Student student = model.getStudent(id);
        if (student == null) {
            view.displayMessage("Student not found with ID: " + id);
            return;
        }

        view.displayMessage("Current information of the student:");
        view.displayStudentHeader();
        view.displayMessage(student.toString());

        view.displayMessage("Enter new details (or input same details to keep):");
        String newName = validation.inputString("Enter New Student Name");
        int newAge = validation.inputInt("Enter New Age", 18, 100);
        double newMath = validation.inputDouble("Enter New Math Grade", 0.0, 10.0);
        double newPhysics = validation.inputDouble("Enter New Physics Grade", 0.0, 10.0);
        double newChemistry = validation.inputDouble("Enter New Chemistry Grade", 0.0, 10.0);

        if (model.editStudent(id, newName, newAge, newMath, newPhysics, newChemistry)) {
            view.displayMessage("Student updated successfully.");
        } else {
            view.displayError("Failed to update student details.");
        }
    }

    /**
     * Handles the process of deleting a student.
     * Prompts the user for the student ID and confirms the deletion,
     * then removes the student from the model.
     */
    private void handleDeleteStudent() {
        view.displayMessage("\n--- Delete Student ---");
        String id = validation.inputString("Enter Student ID to delete");
        Student student = model.getStudent(id);
        if (student == null) {
            view.displayMessage("Student not found with ID: " + id);
            return;
        }

        view.displayMessage("Student to be deleted:");
        view.displayStudentHeader();
        view.displayMessage(student.toString());

        if (validation.inputYesNo("Are you sure you want to delete this student?")) {
            if (model.removeStudent(id)) {
                view.displayMessage("Student deleted successfully.");
            } else {
                view.displayError("Failed to delete student.");
            }
        } else {
            view.displayMessage("Delete operation cancelled.");
        }
    }

    /**
     * Handles the process of displaying all students.
     * Retrieves all students from the model and displays them.
     */
    private void handleDisplayAll() {
        view.displayMessage("\n--- Display All Students ---");
        view.displayStudentList(model.getStudents());
    }
}
