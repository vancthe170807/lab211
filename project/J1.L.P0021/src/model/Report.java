package model;

/**
 * Model class for counting courses of students.
 */
public class Report {

    private String studentName;
    private String courseName;
    private int totalCourse;

    /**
     * Constructor for Report class.
     * 
     * @param studentName Name of the student
     * @param courseName Course designated
     * @param totalCourse Amount of assignments
     */
    public Report (String studentName, String courseName, int totalCourse) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    public String getStudentName () {
        return studentName;
    }

    public void setStudentName (String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName () {
        return courseName;
    }

    public void setCourseName (String courseName) {
        this.courseName = courseName;
    }

    public int getTotalCourse () {
        return totalCourse;
    }

    public void setTotalCourse (int totalCourse) {
        this.totalCourse = totalCourse;
    }

    /**
     * Translates report to formatted string.
     * 
     * @return Formatted string representation
     */
    @Override
    public String toString () {
        return String.format("%-25s | %-10s | %-5d", studentName, courseName, totalCourse);
    }
}