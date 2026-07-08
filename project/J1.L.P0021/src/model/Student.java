package model;

/**
 * Represents a student record in the application.
 */
public class Student implements Comparable<Student> {

    private String id;
    private String name;
    private int semester;
    private String courseName;

    /**
     * Creates an empty student object.
     */
    public Student () {
    }

    /**
     * Creates a student with the given details.
     *
     * @param id The student ID.
     * @param semester The semester number.
     * @param name The student name.
     * @param courseName The course name.
     */
    public Student (String id, int semester, String name, String courseName) {
        this.id = id;
        this.semester = semester;
        this.name = name;
        this.courseName = courseName;
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getSemester () {
        return semester;
    }

    public void setSemester (int semester) {
        this.semester = semester;
    }

    public String getCourseName () {
        return courseName;
    }

    public void setCourseName (String courseName) {
        this.courseName = courseName;
    }

    /**
     * Compares this student with another student by name.
     *
     * @param other The student to compare with.
     * @return A negative, zero, or positive value based on name comparison.
     */
    @Override
    public int compareTo (Student other) {
        return this.getName().compareTo(other.getName());
    }

    /**
     * Returns a formatted string representation of the student.
     *
     * @return A formatted string containing student details.
     */
    @Override
    public String toString () {
        return String.format("%10s%30s%10d%13s", id, name, semester, courseName);
    }
}