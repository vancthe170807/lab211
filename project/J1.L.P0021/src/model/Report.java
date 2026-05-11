package model;

/**
 * Lớp đại diện cho báo cáo sinh viên.
 * Chứa thông tin về tên sinh viên, tên khóa học và tổng số khóa học.
 */
public class Report {
    private String studentName;
    private String courseName;
    private int totalCourse;

    /**
     * Khởi tạo một đối tượng báo cáo.
     * 
     * @param studentName Tên sinh viên
     * @param courseName Tên khóa học
     * @param totalCourse Tổng số khóa học
     */
    public Report(String studentName, String courseName, int totalCourse) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    @Override
    public String toString() {
        return String.format("%-25s | %-10s | %-5d", studentName, courseName, totalCourse);
    }
}
