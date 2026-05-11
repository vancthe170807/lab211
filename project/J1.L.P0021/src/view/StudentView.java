package view;

import model.Student;
import model.Report;
import java.util.ArrayList;

/**
 * Lớp hiển thị dữ liệu cho người dùng.
 */
public class StudentView {

    /**
     * Hiển thị menu chính.
     */
    public void displayMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("\t1. Create");
        System.out.println("\t2. Find and Sort");
        System.out.println("\t3. Update/Delete");
        System.out.println("\t4. Report");
        System.out.println("\t5. Exit");
    }

    /**
     * Hiển thị danh sách sinh viên.
     * 
     * @param studentList Danh sách sinh viên cần hiển thị
     */
    public void displayAllStudents(ArrayList<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("Student list is currently empty");
            return;
        }
        System.out.format("%10s%30s%10s%13s\n", "Id", "Student name", "Semester", "Course name");
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }

    /**
     * Hiển thị danh sách báo cáo.
     * 
     * @param reportList Danh sách báo cáo cần hiển thị
     */
    public void displayReports(ArrayList<Report> reportList) {
        if (reportList.isEmpty()) {
            System.out.println("Report list is empty.");
            return;
        }
        for (Report report : reportList) {
            System.out.println(report.toString());
        }
    }

    /**
     * Hiển thị thông báo chung.
     * 
     * @param message Nội dung thông báo
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
