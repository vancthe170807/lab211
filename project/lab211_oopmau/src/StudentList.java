import java.util.ArrayList;

// Lớp quản lý danh sách sinh viên
public class StudentList {
    private ArrayList<Student> students; // Danh sách sinh viên

    // Constructor không tham số
    public StudentList() {
        // Nên khởi tạo danh sách ở đây để tránh lỗi NullPointerException
        students = new ArrayList<>();
    }

    // Constructor có tham số
    public StudentList(ArrayList<Student> students) {
        // Gán danh sách sinh viên được truyền vào
        this.students = students;
    }

    // Lấy sinh viên theo mã sinh viên
    public Student getStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // Thêm sinh viên vào danh sách, kiểm tra trùng mã
    public boolean addStudent(Student student) {
        if (getStudent(student.getId()) == null) {
            students.add(student);
            return true;
        } else return false;
    }

    // Xóa sinh viên theo mã
    public boolean removeStudent(String id) {
        Student student = getStudent(id);
        if (student != null) {
            students.remove(student);
            return true;
        } else {
            return false;
        }
    }

    // Lấy danh sách sinh viên
    public ArrayList<Student> getStudents() {
        return students;
    }

    // Sửa thông tin sinh viên theo mã
    public boolean EditStudent(Student student) {
        Student temp = getStudent(student.getId());
        if (temp != null) {
            temp.setName(student.getName());
            temp.setChemistry(student.getChemistry());
            temp.setPhysics(student.getPhysics());
            return true;
        }
        return false;
    }

    // Hiển thị danh sách sinh viên
    public void DisPlay() {
        System.out.println("Student List");
        for (Student student : students) {
            student.Display();
        }
    }

    // Nhập danh sách sinh viên từ bàn phím
    public void Input() {
        Student sv;
        do {
            System.out.print("Enter student information  " + (students.size() + 1) + " : ");
            sv = new Student();
            sv.input();
            students.add(sv); // Thêm sinh viên vừa nhập vào danh sách
            char con;
            System.out.print("do you want to continous Y/N");
            con = System.console().readLine().charAt(0);
            if (!(con == 'Y' || con == 'y')) {
                break;
            }
        }
        while (true);
    }

    // Tìm kiếm sinh viên theo tên (không phân biệt hoa thường)
    public StudentList findStudentName(String name) {
        StudentList re = new StudentList();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(name.toLowerCase())) {
                re.addStudent(student);
            }
        }
        return re;
    }
}
