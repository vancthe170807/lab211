package controller;

import java.util.ArrayList;
import model.Report;
import model.Student;
import model.StudentModel;
import utils.Constants;
import view.StudentView;

/**
 * Controls the main flow of the student management application.
 */
public class StudentController {

    private final StudentView view;
    private final StudentModel model;
    private final Constants constants;

    /**
     * Initializes the view, model, and constants used by the controller.
     */
    public StudentController () {
        this.view = new StudentView();
        this.model = new StudentModel();
        this.constants = new Constants();
    }

    /**
     * Runs the main application loop and handles user menu choices.
     */
    public void run () {
        boolean isRunning;
        
        isRunning = true;

        while (isRunning) {
            int choice;
            
            choice = view.displayMenuAndGetChoice();

            switch (choice) {
                case 1: {
                    handleCreateStudent();
                    break;
                }
                case 2: {
                    handleFindAndSort();
                    break;
                }
                case 3: {
                    handleUpdateOrDelete();
                    break;
                }
                case 4: {
                    handleReport();
                    break;
                }
                case 5: {
                    isRunning = false;
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    /**
     * Handles the process of creating a new student record.
     */
    private void handleCreateStudent () {
        boolean isAdding;
        
        isAdding = true;

        view.displayMessage("-----------Create Student-------------");

        while (isAdding) {
            String id;
            String name;
            int semester;
            String course;
            boolean isRegistered;
            int currentCount;
            boolean isAboveMin;

            id = view.inputStudentId();
            name = model.findNameById(id);

            if (name.isEmpty()) {
                name = view.inputStudentName();
            } else {
                StringBuilder msgBuilder;
                
                msgBuilder = new StringBuilder();

                msgBuilder.append("Student name: ");
                msgBuilder.append(name);
                
                view.displayMessage(msgBuilder.toString());
            }

            semester = view.inputSemester();
            course = view.inputCourse();

            isRegistered = model.checkStudentRegistered(id, semester, course);

            if (isRegistered) {
                StringBuilder errorBuilder;
                
                errorBuilder = new StringBuilder();

                errorBuilder.append("This student has already registered ");
                errorBuilder.append(course);
                errorBuilder.append(" in semester ");
                errorBuilder.append(semester);

                view.displayMessage(errorBuilder.toString());
            } else {
                Student newStudent;
                
                newStudent = new Student(id, semester, name, course);
                
                model.addStudent(newStudent);
                
                view.displayMessage("Add student success.");
            }

            currentCount = model.getStudentCount();
            isAboveMin = currentCount >= constants.MIN_STUDENT;

            if (isAboveMin) {
                boolean shouldContinue;
                
                shouldContinue = view.askContinue();

                if (!shouldContinue) {
                    isAdding = false;
                }
            }
        }
    }

    /**
     * Handles searching and sorting students by name.
     */
    private void handleFindAndSort () {
        int listSize;
        boolean isEmpty;

        view.displayMessage("-----------Find and Sort Student-------------");
        
        listSize = model.getStudentCount();
        isEmpty = listSize == 0;

        if (isEmpty) {
            view.displayMessage("List empty.");
        } else {
            String searchString;
            ArrayList<Student> resultList;
            boolean isResultEmpty;

            searchString = view.inputSearchName();
            resultList = model.findAndSortStudents(searchString);
            isResultEmpty = resultList.isEmpty();

            if (isResultEmpty) {
                view.displayMessage("No student found.");
            } else {
                view.displayStudentList(resultList);
            }
        }
    }

    /**
     * Handles updating or deleting a student record.
     */
    private void handleUpdateOrDelete () {
        int listSize;
        boolean isEmpty;

        view.displayMessage("-----------Update/Delete-------------");

        listSize = model.getStudentCount();
        isEmpty = listSize == 0;

        if (isEmpty) {
            view.displayMessage("List empty.");
        } else {
            String id;
            ArrayList<Student> foundList;
            boolean isFoundEmpty;
            
            id = view.inputSearchId();
            foundList = model.findStudentsById(id);
            isFoundEmpty = foundList.isEmpty();

            if (isFoundEmpty) {
                view.displayMessage("Student not found.");
            } else {
                int foundSize;
                boolean hasMultiple;
                Student selectedStudent;
                String operationMode;
                boolean isUpdate;

                view.displayStudentList(foundList);
                
                foundSize = foundList.size();
                hasMultiple = foundSize > 1;

                if (hasMultiple) {
                    int choiceIndex;
                    
                    choiceIndex = view.inputChoiceIndex(foundSize);
                    
                    selectedStudent = foundList.get(choiceIndex - 1);
                } else {
                    selectedStudent = foundList.get(0);
                }

                operationMode = view.inputUpdateOrDelete();
                isUpdate = operationMode.equals("U");

                if (isUpdate) {
                    String newId;
                    String newName;
                    boolean hasName;
                    int newSemester;
                    String newCourse;

                    newId = view.inputOptionalId();
                    newName = view.inputOptionalName();
                    hasName = !newName.isEmpty();
                    
                    if (hasName) {
                        model.updateStudentNameGlobally(selectedStudent.getId(), newName);
                    }

                    newSemester = view.inputOptionalSemester();
                    newCourse = view.inputOptionalCourse();

                    model.updateStudentProperties(selectedStudent, newId, newSemester, newCourse);
                    
                    view.displayMessage("Update success.");
                } else {
                    model.deleteStudent(selectedStudent);
                    
                    view.displayMessage("Delete success.");
                }
            }
        }
    }

    /**
     * Handles generating and displaying the report list.
     */
    private void handleReport () {
        int listSize;
        boolean isEmpty;

        view.displayMessage("-----------Report-------------");

        listSize = model.getStudentCount();
        isEmpty = listSize == 0;

        if (isEmpty) {
            view.displayMessage("List empty.");
        } else {
            ArrayList<Report> reportList;
            
            reportList = model.generateReports();
            
            view.displayReportList(reportList);
        }
    }
}