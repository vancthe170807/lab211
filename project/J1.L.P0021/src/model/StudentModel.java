package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Handles the student data logic and list operations.
 */
public class StudentModel {

    private final ArrayList<Student> studentList;

    /**
     * Initializes the internal student list.
     */
    public StudentModel () {
        this.studentList = new ArrayList<>();
    }

    /**
     * Returns the number of students currently stored.
     *
     * @return The size of the student list.
     */
    public int getStudentCount () {
        int count;
        
        count = studentList.size();
        
        return count;
    }

    /**
     * Adds a student to the list.
     *
     * @param student The student to add.
     */
    public void addStudent (Student student) {
        studentList.add(student);
    }

    /**
     * Checks whether the same student is already registered for the same semester and course.
     *
     * @param id The student ID to check.
     * @param semester The semester to check.
     * @param course The course to check.
     * @return True if the student is already registered, otherwise false.
     */
    public boolean checkStudentRegistered (String id, int semester, String course) {
        boolean isRegistered;
        
        isRegistered = false;

        for (Student student : studentList) {
            boolean isSameId;
            boolean isSameSemester;
            boolean isSameCourse;
            boolean isMatch;

            isSameId = student.getId().equalsIgnoreCase(id);
            isSameSemester = (student.getSemester() == semester);
            isSameCourse = student.getCourseName().equalsIgnoreCase(course);
            
            isMatch = isSameId && 
                      isSameSemester && 
                      isSameCourse;

            if (isMatch) {
                isRegistered = true;
                break;
            }
        }

        return isRegistered;
    }

    /**
     * Finds the name of a student by ID.
     *
     * @param id The student ID to search for.
     * @return The matching student name, or an empty string if not found.
     */
    public String findNameById (String id) {
        String name;
        
        name = "";

        for (Student student : studentList) {
            boolean isSameId;
            
            isSameId = student.getId().equalsIgnoreCase(id);

            if (isSameId) {
                name = student.getName();
                break;
            }
        }

        return name;
    }

    /**
     * Finds students whose names contain the given search string and sorts the results by name.
     *
     * @param searchName The name fragment to search for.
     * @return A sorted list of matching students.
     */
    public ArrayList<Student> findAndSortStudents (String searchName) {
        ArrayList<Student> resultList;
        
        resultList = new ArrayList<>();

        for (Student student : studentList) {
            String lowerName;
            String lowerSearch;
            boolean containsName;
            
            lowerName = student.getName().toLowerCase();
            lowerSearch = searchName.toLowerCase();
            containsName = lowerName.contains(lowerSearch);

            if (containsName) {
                resultList.add(student);
            }
        }

        Collections.sort(resultList);

        return resultList;
    }

    /**
     * Finds all students with the given ID.
     *
     * @param id The student ID to search for.
     * @return A list of matching students.
     */
    public ArrayList<Student> findStudentsById (String id) {
        ArrayList<Student> resultList;
        
        resultList = new ArrayList<>();

        for (Student student : studentList) {
            boolean isMatch;
            
            isMatch = student.getId().equalsIgnoreCase(id);

            if (isMatch) {
                resultList.add(student);
            }
        }

        return resultList;
    }

    /**
     * Updates the properties of a student record.
     *
     * @param student The student to update.
     * @param id The new ID to apply.
     * @param semester The new semester to apply.
     * @param course The new course to apply.
     */
    public void updateStudentProperties (Student student, String id, int semester, String course) {
        boolean isIdValid;
        boolean isSemesterValid;
        boolean isCourseValid;

        isIdValid = !id.isEmpty();
        isSemesterValid = semester > 0;
        isCourseValid = !course.isEmpty();

        if (isIdValid) {
            student.setId(id);
        }

        if (isSemesterValid) {
            student.setSemester(semester);
        }

        if (isCourseValid) {
            student.setCourseName(course);
        }
    }

    /**
     * Updates the name of all students that share the given ID.
     *
     * @param id The student ID to match.
     * @param newName The new name to set.
     */
    public void updateStudentNameGlobally (String id, String newName) {
        for (Student student : studentList) {
            boolean isMatch;
            
            isMatch = student.getId().equalsIgnoreCase(id);

            if (isMatch) {
                student.setName(newName);
            }
        }
    }

    /**
     * Deletes a student from the list.
     *
     * @param student The student to remove.
     */
    public void deleteStudent (Student student) {
        studentList.remove(student);
    }

    /**
     * Generates a report list based on existing student data.
     *
     * @return A list of reports summarizing student-course counts.
     */
    public ArrayList<Report> generateReports () {
        ArrayList<Report> reportList;
        
        reportList = new ArrayList<>();

        for (Student student : studentList) {
            int count;
            boolean exists;
            
            count = 0;
            exists = false;

            for (Student check : studentList) {
                boolean isSameId;
                boolean isSameCourse;
                boolean isCorrelated;
                
                isSameId = student.getId().equalsIgnoreCase(check.getId());
                isSameCourse = student.getCourseName().equalsIgnoreCase(check.getCourseName());
                isCorrelated = isSameId && 
                               isSameCourse;

                if (isCorrelated) {
                    count = count + 1;
                }
            }

            for (Report report : reportList) {
                boolean isSameName;
                boolean isSameCourseReport;
                boolean isDuplicated;
                
                isSameName = report.getStudentName().equalsIgnoreCase(student.getName());
                isSameCourseReport = report.getCourseName().equalsIgnoreCase(student.getCourseName());
                isDuplicated = isSameName && 
                               isSameCourseReport;

                if (isDuplicated) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                Report newReport;
                
                newReport = new Report(student.getName(), student.getCourseName(), count);
                
                reportList.add(newReport);
            }
        }

        return reportList;
    }
}