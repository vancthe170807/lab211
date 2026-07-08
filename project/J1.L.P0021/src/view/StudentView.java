package view;

import java.util.ArrayList;
import model.Report;
import model.Student;
import utils.Constants;
import utils.Validation;

/**
 * Handles user interaction for the student management console.
 */
public class StudentView {

    private final Validation validation;
    private final Constants constants;

    /**
     * Initializes the validation and constants helpers used by the view.
     */
    public StudentView () {
        this.validation = new Validation();
        this.constants = new Constants();
    }

    /**
     * Displays the main menu and returns the user's selected option.
     *
     * @return The chosen menu option.
     */
    public int displayMenuAndGetChoice () {
        int choice;
        StringBuilder menuBuilder;

        menuBuilder = new StringBuilder();
        
        // Build the main menu text
        menuBuilder.append("WELCOME TO STUDENT MANAGEMENT\n");
        menuBuilder.append("\t1. Create\n");
        menuBuilder.append("\t2. Find and Sort\n");
        menuBuilder.append("\t3. Update/Delete\n");
        menuBuilder.append("\t4. Report\n");
        menuBuilder.append("\t5. Exit\n");
        menuBuilder.append("Your choice: ");

        displayMessage(menuBuilder.toString());
        
        choice = validation.getInteger("", constants.MIN_CHOICE, constants.MAX_CHOICE);

        return choice;
    }

    /**
     * Prompts the user to enter a student ID and returns it in uppercase.
     *
     * @return A validated student ID.
     */
    public String inputStudentId () {
        String id;
        
        id = validation.getString("Enter student's id: ", constants.REGEX_ID, "HE123456");
        id = id.toUpperCase();

        return id;
    }

    /**
     * Prompts the user to enter a student name.
     *
     * @return A validated student name.
     */
    public String inputStudentName () {
        String name;
        
        name = validation.getString("Enter student's name: ", constants.REGEX_NAME, "Nguyen Van A");

        return name;
    }

    /**
     * Prompts the user to enter a semester number.
     *
     * @return A validated semester value.
     */
    public int inputSemester () {
        int semester;
        
        semester = validation.getInteger("Enter student's semester: ", constants.MIN_SEMESTER, constants.MAX_SEMESTER);

        return semester;
    }

    /**
     * Prompts the user to enter a valid course name until the input is accepted.
     *
     * @return A validated course name.
     */
    public String inputCourse () {
        String course;
        
        while (true) {
            boolean isJava;
            boolean isNet;
            boolean isC;
            boolean isCpp;
            boolean isValid;

            course = validation.getString("Enter course (Java, .Net, C/C++): ", constants.REGEX_ANY, "Java");
            
            isJava = course.equalsIgnoreCase(constants.COURSE_JAVA);
            isNet = course.equalsIgnoreCase(constants.COURSE_NET);
            isC = course.equalsIgnoreCase(constants.COURSE_C);
            isCpp = course.equalsIgnoreCase(constants.COURSE_CPP);

            isValid = isJava || 
                      isNet || 
                      isC || 
                      isCpp;

            if (isValid) {
                break;
            }

            displayMessage("Only three courses allowed: Java, .Net and C/C++");
        }

        return course;
    }

    /**
     * Asks whether the user wants to continue the program.
     *
     * @return True if the user chooses to continue, otherwise false.
     */
    public boolean askContinue () {
        boolean isContinue;
        
        isContinue = validation.checkYN("Do you want to continue (Y/N)? ");

        return isContinue;
    }

    /**
     * Displays the list of students in a formatted table.
     *
     * @param studentList The list of students to display.
     */
    public void displayStudentList (ArrayList<Student> studentList) {
        boolean isEmpty;
        
        isEmpty = studentList.isEmpty();

        if (isEmpty) {
            displayMessage("Student list is currently empty.");
        } else {
            StringBuilder headerBuilder;
            
            headerBuilder = new StringBuilder();

            headerBuilder.append(String.format("%10s", "Id"));
            headerBuilder.append(String.format("%30s", "Student name"));
            headerBuilder.append(String.format("%10s", "Semester"));
            headerBuilder.append(String.format("%13s", "Course name"));

            displayMessage("---------------------------------------------------------------");
            displayMessage(headerBuilder.toString());
            displayMessage("---------------------------------------------------------------");

            for (Student student : studentList) {
                displayMessage(student.toString());
            }
            
            displayMessage("---------------------------------------------------------------");
        }
    }

    /**
     * Prompts the user to enter a name for searching.
     *
     * @return The search name entered by the user.
     */
    public String inputSearchName () {
        String searchName;
        
        searchName = validation.getString("Enter name to search: ", constants.REGEX_ANY, "");

        return searchName;
    }

    /**
     * Prompts the user to enter a student ID for searching.
     *
     * @return The search ID entered by the user.
     */
    public String inputSearchId () {
        String searchId;
        
        searchId = validation.getString("Enter student ID: ", constants.REGEX_ANY, "");
        searchId = searchId.toUpperCase();

        return searchId;
    }

    /**
     * Prompts the user to choose a record by index within the allowed range.
     *
     * @param maxIndex The maximum allowed index value.
     * @return The selected index.
     */
    public int inputChoiceIndex (int maxIndex) {
        int index;
        StringBuilder promptBuilder;
        
        promptBuilder = new StringBuilder();
        
        promptBuilder.append("Choose record to process (1-");
        promptBuilder.append(maxIndex);
        promptBuilder.append("): ");

        index = validation.getInteger(promptBuilder.toString(), 1, maxIndex);

        return index;
    }

    /**
     * Asks whether the user wants to update or delete a record.
     *
     * @return The selected action, either U or D.
     */
    public String inputUpdateOrDelete () {
        String choice;
        
        choice = validation.checkUD("Do you want to update (U) or delete (D)? ");

        return choice;
    }

    /**
     * Prompts the user to enter a new ID, allowing an empty input to keep the existing value.
     *
     * @return The new ID or an empty string if the user keeps the current value.
     */
    public String inputOptionalId () {
        String newId;
        
        newId = validation.getString("Enter new ID (Enter to keep): ", constants.REGEX_ANY, "");
        newId = newId.toUpperCase();

        return newId;
    }

    /**
     * Prompts the user to enter a new name, allowing an empty input to keep the existing value.
     *
     * @return The new name or an empty string if the user keeps the current value.
     */
    public String inputOptionalName () {
        String newName;
        
        newName = validation.getString("Enter new name (Enter to keep): ", constants.REGEX_ANY, "");

        return newName;
    }

    /**
     * Prompts the user to enter a new semester, allowing 0 to keep the existing value.
     *
     * @return The new semester value or 0 if the user keeps the current value.
     */
    public int inputOptionalSemester () {
        int newSemester;
        
        newSemester = validation.getInteger("Enter new semester (0 to keep): ", 0, constants.MAX_SEMESTER);

        return newSemester;
    }

    /**
     * Prompts the user to enter a new course, allowing an empty input to keep the existing value.
     *
     * @return The new course name or an empty string if the user keeps the current value.
     */
    public String inputOptionalCourse () {
        String newCourse;
        
        while (true) {
            boolean isJava;
            boolean isNet;
            boolean isC;
            boolean isCpp;
            boolean isEmptyInput;
            boolean isValid;

            newCourse = validation.getString("Enter new course (Enter to keep): ", constants.REGEX_ANY, "");
            
            isJava = newCourse.equalsIgnoreCase(constants.COURSE_JAVA);
            isNet = newCourse.equalsIgnoreCase(constants.COURSE_NET);
            isC = newCourse.equalsIgnoreCase(constants.COURSE_C);
            isCpp = newCourse.equalsIgnoreCase(constants.COURSE_CPP);
            isEmptyInput = newCourse.isEmpty();

            isValid = isJava || 
                      isNet || 
                      isC || 
                      isCpp || 
                      isEmptyInput;

            if (isValid) {
                break;
            }

            displayMessage("Only Java, .Net and C/C++ allowed, or leave empty");
        }

        return newCourse;
    }

    /**
     * Displays the report list in a formatted table.
     *
     * @param reportList The list of reports to display.
     */
    public void displayReportList (ArrayList<Report> reportList) {
        boolean isEmpty;
        
        isEmpty = reportList.isEmpty();

        if (isEmpty) {
            displayMessage("Report list is empty.");
        } else {
            
            displayMessage("----------------------------------------------");
            displayMessage(String.format("%-25s | %-10s | %-5s", "Student name", "Course", "Total"));
            displayMessage("----------------------------------------------");

            for (Report report : reportList) {
                displayMessage(report.toString());
            }
            
            displayMessage("----------------------------------------------");
        }
    }

    /**
     * Prints the given message to the console.
     *
     * @param message The message to display.
     */
    public void displayMessage (String message) {
        System.out.println(message);
    }
}