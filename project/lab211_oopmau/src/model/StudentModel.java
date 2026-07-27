package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Service/Repository layer to manage the list of Student objects.
 */
public class StudentModel {
    private final List<Student> students;

    /**
     * Constructor for StudentModel
     */
    public StudentModel() {
        this.students = new ArrayList<>();
    }

    /**
     * Constructor for StudentModel
     * @param students List of Student objects
     */
    public StudentModel(List<Student> students) {
        this.students = new ArrayList<>(students);
    }

    /**
     * Finds a student by ID.
     * 
     * @param id Student ID to search for
     * @return Student object if found, null otherwise
     */
    public Student getStudent(String id) {
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Adds a student to the list, verifying there are no duplicates.
     * 
     * @param student Student object to add
     * @return true if student was added successfully, false if student with same ID already exists
     */
    public boolean addStudent(Student student) {
        if (getStudent(student.getId()) == null) {
            students.add(student);
            return true;
        }
        return false;
    }

    /**
     * Removes a student by ID.
     * 
     * @param id Student ID to remove
     * @return true if student was removed successfully, false if student not found
     */
    public boolean removeStudent(String id) {
        Student student = getStudent(id);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }

    /**
     * Gets all students.
     * 
     * @return List of Student objects
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Edits student details.
     * 
     * @param id Student ID to edit
     * @param name New student name
     * @param age New student age
     * @param math New math score
     * @param physics New physics score
     * @param chemistry New chemistry score
     * 
     * @return true if student was edited successfully, false if student not found
     */
    public boolean editStudent(String id, String name, int age, double math, double physics, double chemistry) {
        Student student = getStudent(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            student.setMath(math);
            student.setPhysics(physics);
            student.setChemistry(chemistry);
            return true;
        }
        return false;
    }

    /**
     * Finds students whose names contain the query string (case-insensitive).
     * 
     * @param queryName Query string to search for
     * @return List of Student objects that contain the query string in their name
     */
    public List<Student> findStudentsByName(String queryName) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(queryName.toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }
}
