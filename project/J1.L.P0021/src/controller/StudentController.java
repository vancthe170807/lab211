package controller;

import model.Student;
import model.Report;
import view.StudentView;
import utils.Validation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Lớp điều khiển quản lý các hoạt động liên quan đến sinh viên.
 */
public class StudentController {
    private final ArrayList<Student> studentList;
    private final StudentView view;
    private final Validation validation;

    /**
     * Khởi tạo Controller với danh sách sinh viên rỗng.
     */
    public StudentController() {
        this.studentList = new ArrayList<>();
        this.view = new StudentView();
        this.validation = new Validation();
    }

    /**
     * Khởi chạy ứng dụng và điều hướng các lựa chọn từ menu.
     */
    public void run() {
        while (true) {
            view.displayMenu();
            int choice = validation.getInteger("Your choice: ", 1, 5);
            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    findAndSort();
                    break;
                case 3:
                    updateOrDelete();
                    break;
                case 4:
                    report();
                    break;
                case 5:
                    return;
            }
        }
    }

    /**
     * Tạo mới một sinh viên và thêm vào danh sách.
     * 
     * Kiểm tra trùng lặp dựa trên ID, học kỳ và khóa học để tránh thêm sinh viên đã đăng ký cùng khóa học trong cùng học kỳ.
     * Bắt buộc nhập ít nhất 10 sinh viên, sau đó hỏi người dùng có muốn tiếp tục hay không.
     */
    private void createStudent() {
        view.displayMessage("-----------Create Student-------------");
        while (true) {
            String id = validation.getString("Enter student's id: ", "[a-zA-Z0-9]+", "HE123456");
            String name = "";
            
            // Tìm sinh viên đã tồn tại với ID này để lấy tên
            for (Student s : studentList) {
                if (s.getId().equalsIgnoreCase(id)) {
                    name = s.getName();
                    break;
                }
            }

            if (name.isEmpty()) {
                name = validation.getString("Enter student's name: ", "([a-zA-Z]{1,10}\\s?)+", "Nguyen Van A");
            } else {
                view.displayMessage("Student name: " + name);
            }

            int semester = validation.getInteger("Enter student's semester: ", 1, 10);
            String course = getCourseInput();

            if (isStudentRegistered(id, name, semester, course)) {
                view.displayMessage("This student has already registered " + course + " in semester " + semester);
            } else {
                studentList.add(new Student(id, semester, name, course));
                view.displayMessage("Add student success.");
            }

            if (studentList.size() >= 10) {
                if (!validation.checkYN("Do you want to continue (Y/N)? ")) {
                    break;
                }
            } else {
                // Đề bài yêu cầu tạo ít nhất 10 student? 
                // Tuy nhiên trong bản cũ nó cho phép dừng nếu user chọn N sau 10 student.
                // Ở đây ta cứ theo logic cũ: hỏi sau mỗi lần thêm nếu size >= 10.
            }
            // Nếu ít hơn 10, vẫn có thể dừng nếu developer muốn, nhưng đề thường yêu cầu ít nhất 10.
            // Để đơn giản ta cứ hỏi Y/N nếu user muốn dừng.
        }
    }

    /**
     * Tìm kiếm sinh viên theo tên và sắp xếp theo tên.
     */
    private void findAndSort() {
        view.displayMessage("-----------Find and Sort Student-------------");
        if (studentList.isEmpty()) {
            view.displayMessage("List empty.");
            return;
        }
        String name = validation.getString("Enter name to search: ", "", "");
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(s);
            }
        }
        if (result.isEmpty()) {
            view.displayMessage("No student found.");
        } else {
            Collections.sort(result);
            view.displayAllStudents(result);
        }
    }

    /**
     * Cập nhật hoặc xóa thông tin sinh viên dựa trên ID.
     */
    private void updateOrDelete() {
        view.displayMessage("-----------Update/Delete-------------");
        if (studentList.isEmpty()) {
            view.displayMessage("List empty.");
            return;
        }
        String id = validation.getString("Enter student ID: ", "", "");
        ArrayList<Student> listFound = getStudentById(id);
        if (listFound.isEmpty()) {
            view.displayMessage("Student not found.");
            return;
        }

        // Hiển thị danh sách sinh viên có ID này
        view.displayAllStudents(listFound);
        
        // Chọn record cụ thể để sửa/xóa nếu có nhiều record của cùng 1 ID (khác semester/course)
        Student studentToProcess;
        if (listFound.size() > 1) {
            int choice = validation.getInteger("Choose record to process (1-" + listFound.size() + "): ", 1, listFound.size());
            studentToProcess = listFound.get(choice - 1);
        } else {
            studentToProcess = listFound.get(0);
        }

        String mode = validation.checkUD("Do you want to update (U) or delete (D)? ");
        if (mode.equals("U")) {
            String newId = validation.getString("Enter new ID (Enter to keep): ", ".*", "");
            if (!newId.isEmpty()) studentToProcess.setId(newId);
            
            String newName = validation.getString("Enter new name (Enter to keep): ", ".*", "");
            if (!newName.isEmpty()) {
                // Cập nhật tên cho tất cả các record cùng ID
                updateStudentName(studentToProcess.getId(), newName);
            }
            
            int newSemester = validation.getInteger("Enter new semester (0 to keep): ", 0, 10);
            if (newSemester != 0) studentToProcess.setSemester(newSemester);
            
            String newCourse = validation.getString("Enter new course (Enter to keep): ", ".*", "");
            if (!newCourse.isEmpty()) {
                if (isValidCourse(newCourse)) {
                    studentToProcess.setCourseName(newCourse);
                } else {
                    view.displayMessage("Invalid course. Kept old course.");
                }
            }
            view.displayMessage("Update success.");
        } else {
            studentList.remove(studentToProcess);
            view.displayMessage("Delete success.");
        }
    }

    /**
     * Tạo báo cáo thống kê số lượng khóa học của từng sinh viên.
     */
    private void report() {
        view.displayMessage("-----------Report-------------");
        if (studentList.isEmpty()) {
            view.displayMessage("List empty.");
            return;
        }
        ArrayList<Report> reportList = new ArrayList<>();
        // Logic báo cáo: ID + Name + Course -> Count
        for (Student s : studentList) {
            int count = 0;
            for (Student check : studentList) {
                if (s.getId().equalsIgnoreCase(check.getId()) 
                    && s.getCourseName().equalsIgnoreCase(check.getCourseName())) {
                    count++;
                }
            }
            
            boolean exists = false;
            for (Report r : reportList) {
                if (r.getStudentName().equalsIgnoreCase(s.getName()) 
                    && r.getCourseName().equalsIgnoreCase(s.getCourseName())) {
                    exists = true;
                    break;
                }
            }
            
            if (!exists) {
                reportList.add(new Report(s.getName(), s.getCourseName(), count));
            }
        }
        view.displayReports(reportList);
    }

    private String getCourseInput() {
        while (true) {
            String course = validation.getString("Enter course (Java, .Net, C/C++): ", "", "");
            if (isValidCourse(course)) return course;
            view.displayMessage("There are only three courses: Java, .Net and C/C++");
        }
    }

    private boolean isValidCourse(String course) {
        return course.equalsIgnoreCase("Java") 
            || course.equalsIgnoreCase(".Net") 
            || course.equalsIgnoreCase("C") 
            || course.equalsIgnoreCase("C++");
    }

    private boolean isStudentRegistered(String id, String name, int semester, String course) {
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id) 
                && s.getSemester() == semester 
                && s.getCourseName().equalsIgnoreCase(course)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<Student> getStudentById(String id) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                result.add(s);
            }
        }
        return result;
    }

    private void updateStudentName(String id, String newName) {
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                s.setName(newName);
            }
        }
    }
}
