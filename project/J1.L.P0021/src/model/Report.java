package model;

/**
 * Represents a summary report for a student's course registration.
 */
public class Report {

    private String studentName;
    private String courseName;
    private int totalCourse;

    /**
     * Creates a report with the provided values.
     *
     * @param studentName The student's name.
     * @param courseName The course name.
     * @param totalCourse The number of registrations for the course.
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
     * Returns the report as a formatted string.
     *
     * @return A formatted string representation of the report.
     */
    @Override
    public String toString () {
        return String.format("%-25s | %-10s | %-5d", studentName, courseName, totalCourse);
    }
}