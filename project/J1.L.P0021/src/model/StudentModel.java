package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Model class containing data logic and list management.
 */
public class StudentModel {

    private final ArrayList<Student> studentList;

    /**
     * Constructor allocating the internal list.
     */
    public StudentModel () {
        this.studentList = new ArrayList<>();
    }

    /**
     * Returns the size of the student list.
     * 
     * @return Element count
     */
    public int getStudentCount () {
        int count;
        
        count = studentList.size();
        
        return count;
    }

    /**
     * Adds an institutional student.
     * 
     * @param student Object to append
     */
    public void addStudent (Student student) {
        studentList.add(student);
    }

    /**
     * Finds if a student explicitly registered in a semester.
     * 
     * @param id Searched ID
     * @param semester Semester number
     * @param course Course string
     * @return Logical state of existence
     */
    public boolean checkStudentRegistered (String id, int semester, String course) {
        boolean isRegistered;
        
        isRegistered = false;

        // Iterate verifying every registered class
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

            // Trigger registration collision
            if (isMatch) {
                isRegistered = true;
                break;
            }
        }

        return isRegistered;
    }

    /**
     * Gets a saved name corresponding an ID natively.
     * 
     * @param id Key ID
     * @return Retreived name or empty
     */
    public String findNameById (String id) {
        String name;
        
        name = "";

        // Seek the ID on the collection
        for (Student student : studentList) {
            boolean isSameId;
            
            isSameId = student.getId().equalsIgnoreCase(id);

            // Harvest the entity name safely
            if (isSameId) {
                name = student.getName();
                break;
            }
        }

        return name;
    }

    /**
     * Collects and sorts elements that contain a text target.
     * 
     * @param searchName Search key
     * @return Built arrayList referencing matching entities
     */
    public ArrayList<Student> findAndSortStudents (String searchName) {
        ArrayList<Student> resultList;
        
        resultList = new ArrayList<>();

        // Loop traversing strings
        for (Student student : studentList) {
            String lowerName;
            String lowerSearch;
            boolean containsName;
            
            lowerName = student.getName().toLowerCase();
            lowerSearch = searchName.toLowerCase();
            containsName = lowerName.contains(lowerSearch);

            // Pack if strings overlap
            if (containsName) {
                resultList.add(student);
            }
        }

        // Apply Java sorting scheme
        Collections.sort(resultList);

        return resultList;
    }

    /**
     * Gets a list of elements that correspond an ID.
     * 
     * @param id Requested key
     * @return List matching query
     */
    public ArrayList<Student> findStudentsById (String id) {
        ArrayList<Student> resultList;
        
        resultList = new ArrayList<>();

        // Traverses the entire container for identical IDs
        for (Student student : studentList) {
            boolean isMatch;
            
            isMatch = student.getId().equalsIgnoreCase(id);

            // Stack on array
            if (isMatch) {
                resultList.add(student);
            }
        }

        return resultList;
    }

    /**
     * In-place mutates properties of a single entity.
     * 
     * @param student Target pointing to update
     * @param id Valid new ID
     * @param semester Filtered numerical input
     * @param course Valid new course string
     */
    public void updateStudentProperties (Student student, String id, int semester, String course) {
        boolean isIdValid;
        boolean isSemesterValid;
        boolean isCourseValid;

        isIdValid = !id.isEmpty();
        isSemesterValid = semester > 0;
        isCourseValid = !course.isEmpty();

        // Evaluate conditions step by step
        if (isIdValid) {
            student.setId(id);
        }

        // Pass integer logic correctly
        if (isSemesterValid) {
            student.setSemester(semester);
        }

        // Add valid class texts
        if (isCourseValid) {
            student.setCourseName(course);
        }
    }

    /**
     * Modifies related names throughout the whole DB records.
     * 
     * @param id Search key
     * @param newName Input defining changes
     */
    public void updateStudentNameGlobally (String id, String newName) {
        
        // Loop targeting all identically linked students
        for (Student student : studentList) {
            boolean isMatch;
            
            isMatch = student.getId().equalsIgnoreCase(id);

            // Reconstruct name definition
            if (isMatch) {
                student.setName(newName);
            }
        }
    }

    /**
     * Removes an exact record mapping object relation.
     * 
     * @param student Item representation internally
     */
    public void deleteStudent (Student student) {
        studentList.remove(student);
    }

    /**
     * Summarizes existing courses array representation list.
     * 
     * @return Consolidated reports mapping count per entities
     */
    public ArrayList<Report> generateReports () {
        ArrayList<Report> reportList;
        
        reportList = new ArrayList<>();

        // External cycle generating objects on report model
        for (Student student : studentList) {
            int count;
            boolean exists;
            
            count = 0;
            exists = false;

            // Internal evaluation to merge quantities correctly
            for (Student check : studentList) {
                boolean isSameId;
                boolean isSameCourse;
                boolean isCorrelated;
                
                isSameId = student.getId().equalsIgnoreCase(check.getId());
                isSameCourse = student.getCourseName().equalsIgnoreCase(check.getCourseName());
                isCorrelated = isSameId && 
                               isSameCourse;

                // Tally occurrences strictly isolated
                if (isCorrelated) {
                    count = count + 1;
                }
            }

            // Exclude repetitions inside tracking structures
            for (Report report : reportList) {
                boolean isSameName;
                boolean isSameCourseReport;
                boolean isDuplicated;
                
                isSameName = report.getStudentName().equalsIgnoreCase(student.getName());
                isSameCourseReport = report.getCourseName().equalsIgnoreCase(student.getCourseName());
                isDuplicated = isSameName && 
                               isSameCourseReport;

                // Stop duplicate injections immediately 
                if (isDuplicated) {
                    exists = true;
                    break;
                }
            }

            // Populate valid data block 
            if (!exists) {
                Report newReport;
                
                newReport = new Report(student.getName(), student.getCourseName(), count);
                
                reportList.add(newReport);
            }
        }

        return reportList;
    }
}