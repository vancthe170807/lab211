import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Validation validation = new Validation();
        ArrayList<Student> studentList = new ArrayList<>();
//        initialize(studentList);
        while (true) {
            //step 1: display menu
            manager.displayMenu();
            //step 2: ask user to choose an option
            int choice = validation.getInteger("Your choice: ",1,5);
            //step 3: perform selected option
            switch(choice){
                //create
                case 1:{
                    manager.createStudent(studentList);
                    break;
                }
                //find and sort
                case 2:{
                    manager.findAndSort(studentList);
                    break;
                }
                //update/delete
                case 3:{
                    manager.updateOrDelete(studentList);
                    break;
                }
                //report
                case 4:{
                    manager.report(studentList);
                    break;
                }
                //exit
                case 5:{
                    return;
                }
            }
        }
    }

    public static ArrayList<Student> initialize(ArrayList<Student> studentList){
        Student student1 = new Student("HE161776", 3, "Vu Dang Khoa", "java");
        Student student2 = new Student("HE161777", 3, "Luu Bich Thuong", ".net");
        Student student3 = new Student("HE161771", 9, "Nguyen Van A", "C");
        Student student4 = new Student("HE161772", 4, "Vu Manh Hung", "C++");
        Student student5 = new Student("HE161773", 2, "Luu Bich Ngoc", ".net");
        Student student6 = new Student("HE161778", 1, "Dao Nam Thang", "java");
        Student student7 = new Student("HE161774", 7, "Nguyen Tien Dat", "java");
        Student student8 = new Student("HE161779", 6, "Le Phuong Chi", "C");
        Student student9 = new Student("HE161775", 3, "Pham Trang Thu", "C");
        Student student10 = new Student("HE161770", 2, "Nghiem Dam Khanh Van", "java");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        studentList.add(student7);
        studentList.add(student8);
        studentList.add(student9);
        studentList.add(student10);
        return studentList;
    }

}
