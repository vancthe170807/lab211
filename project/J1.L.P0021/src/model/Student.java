package model;

/**
 * Model class for student entity.
 */
public class Student implements Comparable<Student> {

    private String id;
    private String name;
    private int semester;
    private String courseName;

    /**
     * Default constructor.
     */
    public Student () {
    }

    /**
     * Parameterized constructor.
     * 
     * @param id Student ID
     * @param semester Semester value
     * @param name Student name
     * @param courseName Name of course
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
     * Compares this student to another by name.
     * 
     * @param other Student to compare with
     * @return Comparison int
     */
    @Override
    public int compareTo (Student other) {
        return this.getName().compareTo(other.getName());
    }

    /**
     * Formats student attributes.
     * 
     * @return Formatted string
     */
    @Override
    public String toString () {
        return String.format("%10s%30s%10d%13s", id, name, semester, courseName);
    }
}