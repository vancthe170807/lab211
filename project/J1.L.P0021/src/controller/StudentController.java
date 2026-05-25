package controller;

import view.StudentView;
import model.StudentModel;
import model.Student;
import model.Report;
import utils.Constants;
import java.util.ArrayList;

/**
 * Controller orchestrating program lifecycle.
 */
public class StudentController {

    private final StudentView view;
    private final StudentModel model;

    /**
     * Instantiates components cleanly separating blocks formatting mapping interactions explicitly.
     */
    public StudentController () {
        this.view = new StudentView();
        this.model = new StudentModel();
    }

    /**
     * Program operational sequence orchestrator handling decisions loop structure cleanly maps routines flow.
     */
    public void run () {
        boolean isRunning;
        
        isRunning = true;

        // Loop traversing options iterations unconditionally executing evaluations mapping logic limits properly formats blocks statements explicit rules iteratively.
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
     * Procedure initiating arrays operations capturing interactions models iterations mappings.
     */
    private void handleCreateStudent () {
        boolean isAdding;
        
        isAdding = true;

        view.displayMessage("-----------Create Student-------------");

        // Loop capturing variables natively
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

            // Conditional branching ensuring accurate evaluations strings mapping formatting variables blocks representations
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

            // Validates database rules representations accurately matching checks conditionally formatting blocks natively.
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
            isAboveMin = currentCount >= Constants.MIN_STUDENT;

            // Conditional logic limits validations
            if (isAboveMin) {
                boolean shouldContinue;
                
                shouldContinue = view.askContinue();

                // Branch validation structure
                if (!shouldContinue) {
                    isAdding = false;
                }
            }
        }
    }

    /**
     * Executes queries mapping logic evaluations cleanly formatting iterations natively outputs representations strings formatting properly.
     */
    private void handleFindAndSort () {
        int listSize;
        boolean isEmpty;

        view.displayMessage("-----------Find and Sort Student-------------");
        
        listSize = model.getStudentCount();
        isEmpty = listSize == 0;

        // Verify array evaluation conditionally mapping logical statements outputs formatting correctly variables blocks iterations natively.
        if (isEmpty) {
            view.displayMessage("List empty.");
        } else {
            String searchString;
            ArrayList<Student> resultList;
            boolean isResultEmpty;

            searchString = view.inputSearchName();
            resultList = model.findAndSortStudents(searchString);
            isResultEmpty = resultList.isEmpty();

            // Branch validation conditional arrays outputs explicitly string representations iterations explicitly rules bounds formatting logical mapped elements strictly.
            if (isResultEmpty) {
                view.displayMessage("No student found.");
            } else {
                view.displayStudentList(resultList);
            }
        }
    }

    /**
     * Processes mapping conditionally formatting mutations operations strings array iterations logic matching requirements explicitly natively accurately routines variables structurally properly strings correctly.
     */
    private void handleUpdateOrDelete () {
        int listSize;
        boolean isEmpty;

        view.displayMessage("-----------Update/Delete-------------");

        listSize = model.getStudentCount();
        isEmpty = listSize == 0;

        // Verify emptiness conditional expressions
        if (isEmpty) {
            view.displayMessage("List empty.");
        } else {
            String id;
            ArrayList<Student> foundList;
            boolean isFoundEmpty;
            
            id = view.inputSearchId();
            foundList = model.findStudentsById(id);
            isFoundEmpty = foundList.isEmpty();

            // Match conditionals
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

                // Pick entity mapped index matching cleanly explicitly conditional evaluations logic strictly explicitly formatted blocks iterations string logic logically operations.
                if (hasMultiple) {
                    int choiceIndex;
                    
                    choiceIndex = view.inputChoiceIndex(foundSize);
                    
                    selectedStudent = foundList.get(choiceIndex - 1);
                } else {
                    selectedStudent = foundList.get(0);
                }

                operationMode = view.inputUpdateOrDelete();
                isUpdate = operationMode.equals("U");

                // Execute modifications validations explicitly rules accurately representations blocks loops internally safely mapping validations.
                if (isUpdate) {
                    String newId;
                    String newName;
                    boolean hasName;
                    int newSemester;
                    String newCourse;

                    newId = view.inputOptionalId();
                    newName = view.inputOptionalName();
                    hasName = !newName.isEmpty();
                    
                    // Evaluate condition arrays strictly representations mutations 
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
     * Deals generation reports formatting routines strings objects properly variables constraints loops safely logic implementations strings validations routines limits mapping arrays structures correctly bounded correctly strings natively appropriately.
     */
    private void handleReport () {
        int listSize;
        boolean isEmpty;

        view.displayMessage("-----------Report-------------");

        listSize = model.getStudentCount();
        isEmpty = listSize == 0;

        // Gate logic conditional execution outputting mapping cleanly boundaries
        if (isEmpty) {
            view.displayMessage("List empty.");
        } else {
            ArrayList<Report> reportList;
            
            reportList = model.generateReports();
            
            view.displayReportList(reportList);
        }
    }
}