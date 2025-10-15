public class Student {

    // Các thuộc tính của Student
    String id; // Mã sinh viên
    String name; // Tên sinh viên
    int age; // Tuổi
    double math; // Điểm Toán
    double physics; // Điểm Lý
    double chemistry; // Điểm Hóa

    // Constructor không tham số
    public Student() {
    }

    // Constructor có tham số
    public Student(String id, String name, int age, double math, double physics, double chemistry) {
        setId(id); // Gán mã sinh viên
        setName(name); // Gán tên sinh viên
        setAge(age); // Gán tuổi
        setMath(math); // Gán điểm Toán
        setPhysics(physics); // Gán điểm Lý
        setChemistry(chemistry); // Gán điểm Hóa
    }

    // Setter cho điểm Hóa, kiểm tra hợp lệ
    public void setChemistry(double chemistry) {
        if (chemistry < 0 || chemistry > 10)
            throw new IllegalArgumentException("chemistry out of range");
        this.chemistry = chemistry;
    }

    // Setter cho điểm Lý, kiểm tra hợp lệ
    public void setPhysics(double physics) {
        if (physics < 0 || physics > 10)
            throw new IllegalArgumentException("physics out of range");
        this.physics = physics;
    }

    // Setter cho điểm Toán, kiểm tra hợp lệ
    public void setMath(double math) {
        if (math < 0 || math > 10)
            throw new IllegalArgumentException("math out of range");
        this.math = math;
    }

    // Setter cho tuổi, kiểm tra hợp lệ
    public void setAge(int age) {
        if (age < 18)
            throw new IllegalArgumentException("age must large or equal 18 range");
        this.age = age;
    }

    // Setter cho tên, kiểm tra hợp lệ
    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("name must not be empty");
        this.name = name;
    }

    // Setter cho mã sinh viên, kiểm tra hợp lệ
    public void setId(String id) {
        if (id == null || id.trim().isEmpty())
            throw new IllegalArgumentException("id must not be empty");
        this.id = id;
    }

    // Getter cho mã sinh viên
    public String getId() {
        return id;
    }

    // Getter cho tên sinh viên
    public String getName() {
        return name;
    }

    // Getter cho tuổi
    public int getAge() {
        return age;
    }

    // Getter cho điểm Toán
    public double getMath() {
        return math;
    }

    // Getter cho điểm Lý
    public double getPhysics() {
        return physics;
    }

    // Getter cho điểm Hóa
    public double getChemistry() {
        return chemistry;
    }

    // Phương thức hiển thị thông tin sinh viên
    public void Display() {
        System.out.print(id + "\t");
        System.out.print(name + "\t");
        System.out.print(age + "\t");
        System.out.print(math + "\t");
        System.out.print(physics + "\t");
        System.out.print(chemistry);
        System.out.println("Sum: " + math + physics + chemistry); // Hiển thị tổng điểm
    }

    // Phương thức nhập thông tin sinh viên từ bàn phím
    public void input() {
        setId(Validation.stringInput("Student Id"));
        setName(Validation.stringInput("Student Name"));
        setChemistry(Validation.InputDouble("Chemistry"));
        setMath(Validation.InputDouble("Math"));
        setPhysics(Validation.InputDouble("Physics"));
    }
}
