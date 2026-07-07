# Interview Guide - Student Management Project

## 1. Tổng quan về project
Project này là một chương trình Java quản lý sinh viên bằng console. Chức năng chính gồm:
- Tạo sinh viên
- Tìm kiếm và sắp xếp sinh viên
- Cập nhật hoặc xóa sinh viên
- Thống kê báo cáo
- Thoát chương trình

## 2. Luồng chạy chương trình
### Bước 1: Khởi động ứng dụng
- File chạy chính là Main.java
- Khi chương trình bắt đầu, nó tạo đối tượng StudentController
- Gọi phương thức run()

### Bước 2: Hiển thị menu
- StudentController gọi StudentView.displayMenuAndGetChoice()
- Người dùng chọn chức năng từ 1 đến 5

### Bước 3: Xử lý theo lựa chọn
- Nếu chọn 1: tạo sinh viên
- Nếu chọn 2: tìm và sắp xếp sinh viên
- Nếu chọn 3: cập nhật hoặc xóa sinh viên
- Nếu chọn 4: xem báo cáo
- Nếu chọn 5: thoát chương trình

### Bước 4: Tương tác với Model
- Controller gọi StudentModel để xử lý dữ liệu
- StudentModel quản lý ArrayList<Student>
- StudentView chỉ chịu trách nhiệm hiển thị và nhận input từ người dùng

## 3. Cấu trúc các lớp chính
### Main
- Chứa phương thức main()
- Dùng để khởi chạy chương trình

### StudentController
- Chịu trách nhiệm điều hướng luồng chương trình
- Không chứa logic xử lý dữ liệu phức tạp
- Chỉ gọi các phương thức trong View và Model

### StudentView
- Chịu trách nhiệm in menu, nhập dữ liệu, hiển thị thông tin
- Là lớp giao diện console

### StudentModel
- Chịu trách nhiệm xử lý dữ liệu
- Quản lý danh sách sinh viên
- Thực hiện tìm kiếm, thêm, xóa, cập nhật, tạo báo cáo

### Student
- Lớp model đại diện cho một sinh viên
- Chứa thông tin: id, name, semester, courseName

### Report
- Lớp model dùng để lưu kết quả báo cáo

### Validation
- Hỗ trợ kiểm tra dữ liệu nhập vào từ người dùng
- Kiểm tra số nguyên, chuỗi, lựa chọn Y/N, U/D

## 4. Các hàm quan trọng và ý nghĩa
### Trong Main
- main(String[] args)
  - Khởi tạo StudentController
  - Gọi controller.run()

### Trong StudentController
- run()
  - Vòng lặp chính của chương trình
  - Hiển thị menu và điều hướng chức năng

- handleCreateStudent()
  - Nhập thông tin sinh viên
  - Kiểm tra trùng lặp
  - Thêm sinh viên vào danh sách

- handleFindAndSort()
  - Nhập tên cần tìm
  - Tìm sinh viên phù hợp
  - Sắp xếp theo tên

- handleUpdateOrDelete()
  - Tìm sinh viên bằng ID
  - Chọn bản ghi cần sửa/xóa
  - Thực hiện update hoặc delete

- handleReport()
  - Tạo báo cáo thống kê
  - Hiển thị kết quả cho người dùng

### Trong StudentModel
- addStudent(Student student)
  - Thêm sinh viên vào danh sách

- checkStudentRegistered(String id, int semester, String course)
  - Kiểm tra sinh viên đã đăng ký khóa học trong học kỳ này chưa

- findNameById(String id)
  - Tìm tên sinh viên qua ID

- findAndSortStudents(String searchName)
  - Tìm và sắp xếp theo tên

- findStudentsById(String id)
  - Tìm danh sách sinh viên theo ID

- updateStudentProperties(Student student, String id, int semester, String course)
  - Cập nhật thông tin sinh viên

- updateStudentNameGlobally(String id, String newName)
  - Cập nhật tên cho tất cả bản ghi cùng ID

- deleteStudent(Student student)
  - Xóa sinh viên khỏi danh sách

- generateReports()
  - Tạo báo cáo tổng hợp

### Trong StudentView
- displayMenuAndGetChoice()
  - Hiển thị menu và nhận lựa chọn

- inputStudentId()
  - Nhập ID sinh viên

- inputStudentName()
  - Nhập tên sinh viên

- inputSemester()
  - Nhập học kỳ

- inputCourse()
  - Nhập tên khóa học

- displayStudentList(ArrayList<Student>)
  - Hiển thị bảng danh sách sinh viên

- displayReportList(ArrayList<Report>)
  - Hiển thị bảng báo cáo

## 5. Các câu hỏi Interview 1:1 giữa GV và SV
### Câu hỏi 1: Project này dùng kiến trúc nào?
Trả lời mẫu:
- Project sử dụng kiến trúc MVC cơ bản: Model, View, Controller.
- Model xử lý dữ liệu, View hiển thị giao diện console, Controller điều hướng luồng.

### Câu hỏi 2: Vai trò của Controller là gì?
Trả lời mẫu:
- Controller nhận input từ View, gọi Model để xử lý, rồi trả kết quả về View để hiển thị.

### Câu hỏi 3: Vai trò của Model là gì?
Trả lời mẫu:
- Model chịu trách nhiệm về dữ liệu và logic nghiệp vụ như thêm, sửa, xóa, tìm kiếm, tạo báo cáo.

### Câu hỏi 4: Vì sao cần tách View và Controller?
Trả lời mẫu:
- Để phân tách rõ trách nhiệm, dễ bảo trì, dễ mở rộng và test hơn.

### Câu hỏi 5: Hàm run() trong Controller làm gì?
Trả lời mẫu:
- Hàm run() tạo vòng lặp chính, hiển thị menu và xử lý các lựa chọn của người dùng.

### Câu hỏi 6: Bạn làm sao để kiểm tra sinh viên đã tồn tại?
Trả lời mẫu:
- Dùng phương thức checkStudentRegistered() để kiểm tra ID, semester và courseName.

### Câu hỏi 7: Tại sao dùng ArrayList?
Trả lời mẫu:
- Vì cần lưu nhiều sinh viên và có thể thêm, xóa, duyệt phần tử dễ dàng.

### Câu hỏi 8: Hàm findAndSortStudents() hoạt động như thế nào?
Trả lời mẫu:
- Nó duyệt toàn bộ danh sách, lọc sinh viên có tên chứa chuỗi nhập vào, rồi dùng Collections.sort() để sắp xếp.

### Câu hỏi 9: Cách cập nhật sinh viên được thực hiện thế nào?
Trả lời mẫu:
- Người dùng nhập ID, hệ thống tìm các bản ghi phù hợp, sau đó chọn bản ghi và cập nhật thông tin.

### Câu hỏi 10: Bạn có thể giải thích ý nghĩa của Validation không?
Trả lời mẫu:
- Validation dùng để kiểm tra dữ liệu đầu vào từ người dùng trước khi xử lý, tránh lỗi và dữ liệu không hợp lệ.

### Câu hỏi 11: Nếu muốn mở rộng thêm chức năng, bạn sẽ làm gì?
Trả lời mẫu:
- Tôi sẽ thêm lớp service hoặc repository, tách logic tốt hơn, đồng thời cập nhật View và Controller tương ứng.

### Câu hỏi 12: Bạn đã áp dụng những nguyên tắc lập trình nào trong project này?
Trả lời mẫu:
- Tôi đã sử dụng đóng gói, tách lớp, tái sử dụng, kiểm tra đầu vào và chia nhỏ chức năng thành các phương thức riêng biệt.

## 6. Mẫu câu trả lời ngắn để ghi nhớ
- Controller điều hướng luồng chương trình.
- Model xử lý dữ liệu và logic nghiệp vụ.
- View chịu trách nhiệm giao diện console.
- Validation dùng để kiểm tra dữ liệu đầu vào.
- Project này là một ví dụ đơn giản về kiến trúc MVC.

## 7. Gợi ý khi trả lời GV
- Nói ngắn gọn, rõ ràng và có logic.
- Nên kết nối câu trả lời với code thực tế trong project.
