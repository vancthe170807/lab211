package model;

/**
 * Lớp đại diện cho một sinh viên.
 * Chứa thông tin về ID, tên, học kỳ và tên khóa học.
 */
public class Student implements Comparable<Student> {
    private String id;
    private String name;
    private int semester;
    private String courseName;

    /**
     * Khởi tạo một đối tượng Student mới không có tham số.
     */
    public Student() {
    }

    /**
     * Khởi tạo một đối tượng Student với đầy đủ thông tin.
     * 
     * @param id Mã số sinh viên
     * @param semester Học kỳ
     * @param name Tên sinh viên
     * @param courseName Tên khóa học
     */
    public Student(String id, int semester, String name, String courseName) {
        this.id = id;
        this.semester = semester;
        this.name = name;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return String.format("%10s%30s%10d%13s", id, name, semester, courseName);
    }

    /**
     * So sánh sinh viên dựa trên tên để hỗ trợ việc sắp xếp.
     * 
     * @param o Sinh viên để so sánh
     * @return Kết quả so sánh tên
     */
    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}
