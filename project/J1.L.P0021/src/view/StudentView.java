package view;

import java.util.ArrayList;
import model.Report;
import model.Student;
import utils.Constants;
import utils.Validation;

/**
 * View class handling terminal I/O.
 */
public class StudentView {

    private final Validation validation;
    private final Constants constants;

    /**
     * Initiates external validation utilities class.
     */
    public StudentView () {
        this.validation = new Validation();
        this.constants = new Constants();
    }

    /**
     * Interacts building string layout of main application layout.
     * 
     * @return Checked choice
     */
    public int displayMenuAndGetChoice () {
        int choice;
        StringBuilder menuBuilder;

        menuBuilder = new StringBuilder();
        
        // Build lines independently preserving standard concatenations rules
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
     * Captures rigorously parsed identity data.
     * 
     * @return Verified string sequence
     */
    public String inputStudentId () {
        String id;
        
        id = validation.getString("Enter student's id: ", constants.REGEX_ID, "HE123456");
        id = id.toUpperCase();

        return id;
    }

    /**
     * Handles string scanning for explicit names.
     * 
     * @return Clear alphabetic array text
     */
    public String inputStudentName () {
        String name;
        
        name = validation.getString("Enter student's name: ", constants.REGEX_NAME, "Nguyen Van A");

        return name;
    }

    /**
     * Gathers validated int from console representing semester.
     * 
     * @return Integer
     */
    public int inputSemester () {
        int semester;
        
        semester = validation.getInteger("Enter student's semester: ", constants.MIN_SEMESTER, constants.MAX_SEMESTER);

        return semester;
    }

    /**
     * Fetches correctly mapped classes strings.
     * 
     * @return Standard verified text representing selection
     */
    public String inputCourse () {
        String course;
        
        // Loop controlling accurate course insertion loop
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

            // Escapes infinite evaluation validation block continuously safely
            if (isValid) {
                break;
            }

            displayMessage("Only three courses allowed: Java, .Net and C/C++");
        }

        return course;
    }

    /**
     * Verifies intentions regarding continuous operations processing iteratively strings.
     * 
     * @return Output state indicating decisions
     */
    public boolean askContinue () {
        boolean isContinue;
        
        isContinue = validation.checkYN("Do you want to continue (Y/N)? ");

        return isContinue;
    }

    /**
     * Formats multiple entries internally utilizing array representation iterations output blocks cleanly separatedly.
     * 
     * @param studentList Reference holding model
     */
    public void displayStudentList (ArrayList<Student> studentList) {
        boolean isEmpty;
        
        isEmpty = studentList.isEmpty();

        // Control structure ensuring items exist
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

            // Iterate outputs
            for (Student student : studentList) {
                displayMessage(student.toString());
            }
            
            displayMessage("---------------------------------------------------------------");
        }
    }

    /**
     * Interactively checks search criteria.
     * 
     * @return Free string
     */
    public String inputSearchName () {
        String searchName;
        
        searchName = validation.getString("Enter name to search: ", constants.REGEX_ANY, "");

        return searchName;
    }

    /**
     * Receives matching criteria.
     * 
     * @return Free format string
     */
    public String inputSearchId () {
        String searchId;
        
        searchId = validation.getString("Enter student ID: ", constants.REGEX_ANY, "");
        searchId = searchId.toUpperCase();

        return searchId;
    }

    /**
     * Handles specific integer capturing ensuring bounds limits properly isolated rules compliant.
     * 
     * @param maxIndex Max size count globally bound mapped.
     * @return Single item value correctly isolated
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
     * Gathers selection code characters matching specific states efficiently returning strings.
     * 
     * @return Action representation U D formatted explicitly.
     */
    public String inputUpdateOrDelete () {
        String choice;
        
        choice = validation.checkUD("Do you want to update (U) or delete (D)? ");

        return choice;
    }

    /**
     * Deals updating specific parameter skipping verification empty characters optionally properly aligned. 
     * 
     * @return Retreivable generic strings format representations explicit regex
     */
    public String inputOptionalId () {
        String newId;
        
        newId = validation.getString("Enter new ID (Enter to keep): ", constants.REGEX_ANY, "");
        newId = newId.toUpperCase();

        return newId;
    }

    /**
     * Optional skipping parameters similarly evaluated mapped format characters checking.
     * 
     * @return Clean optional representation strings formats mapping precisely values
     */
    public String inputOptionalName () {
        String newName;
        
        newName = validation.getString("Enter new name (Enter to keep): ", constants.REGEX_ANY, "");

        return newName;
    }

    /**
     * Scans bounded range optional elements preserving default representation properly bounded numbers limits formatting integers.
     * 
     * @return Limited elements correctly verified options
     */
    public int inputOptionalSemester () {
        int newSemester;
        
        newSemester = validation.getInteger("Enter new semester (0 to keep): ", 0, constants.MAX_SEMESTER);

        return newSemester;
    }

    /**
     * Retrieves limited values conditionally validating options identically previously mapping strings.
     * 
     * @return Correct format matching exact requirements
     */
    public String inputOptionalCourse () {
        String newCourse;
        
        // Loop controlling accurate optional updating logic conditionally bounds formatting iterations strictly checking texts arrays 
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

            // Escapes loop evaluations
            if (isValid) {
                break;
            }

            displayMessage("Only Java, .Net and C/C++ allowed, or leave empty");
        }

        return newCourse;
    }

    /**
     * Evaluates arrays containing data iterating format mapping structures outputs strings.
     * 
     * @param reportList Arrays
     */
    public void displayReportList (ArrayList<Report> reportList) {
        boolean isEmpty;
        
        isEmpty = reportList.isEmpty();

        // Assesses output possibility conditionally evaluating array
        if (isEmpty) {
            displayMessage("Report list is empty.");
        } else {
            
            displayMessage("----------------------------------------------");
            displayMessage(String.format("%-25s | %-10s | %-5s", "Student name", "Course", "Total"));
            displayMessage("----------------------------------------------");

            // Loop data structures strictly mapping formatting representation natively printed
            for (Report report : reportList) {
                displayMessage(report.toString());
            }
            
            displayMessage("----------------------------------------------");
        }
    }

    /**
     * Base interactions mapping standard system layouts internally cleanly strings
     * 
     * @param message Text variables explicitly
     */
    public void displayMessage (String message) {
        System.out.println(message);
    }
}