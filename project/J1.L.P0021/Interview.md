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

## 4. Giải thích chi tiết từng class và hàm
### 4.1 Main
- Main là lớp khởi động chương trình.
- main(String[] args)
  - Đây là hàm chính của chương trình.
  - Nó tạo đối tượng StudentController và gọi controller.run() để bắt đầu vòng đời của ứng dụng.

### 4.2 StudentController
- StudentController là lớp điều phối luồng chương trình.
- Nó nhận dữ liệu từ View, gọi Model để xử lý, rồi hiển thị kết quả lại cho người dùng.

- StudentController()
  - Hàm khởi tạo.
  - Tạo các đối tượng view, model, constants để sử dụng cho toàn bộ chương trình.

- run()
  - Đây là hàm vòng lặp chính của chương trình.
  - Hiển thị menu, nhận lựa chọn từ người dùng, rồi gọi hàm tương ứng cho từng chức năng.

- handleCreateStudent()
  - Xử lý chức năng tạo sinh viên mới.
  - Nhập ID, tên, học kỳ, khóa học.
  - Kiểm tra xem sinh viên này đã tồn tại hay chưa.
  - Nếu chưa tồn tại thì thêm vào danh sách.

- handleFindAndSort()
  - Xử lý chức năng tìm sinh viên theo tên.
  - Nhập chuỗi tìm kiếm, gọi Model lọc kết quả và sắp xếp lại theo tên.
  - Sau đó hiển thị danh sách tìm được.

- handleUpdateOrDelete()
  - Xử lý chức năng cập nhật hoặc xóa sinh viên.
  - Tìm sinh viên theo ID.
  - Cho phép người dùng chọn bản ghi và quyết định cập nhật hay xóa.

- handleReport()
  - Xử lý chức năng tạo báo cáo.
  - Gọi Model để tổng hợp dữ liệu và hiển thị bảng báo cáo cho người dùng.

### 4.3 StudentView
- StudentView là lớp giao diện console.
- Nó chịu trách nhiệm hiển thị menu, nhận input và in kết quả cho người dùng.

- StudentView()
  - Hàm khởi tạo.
  - Tạo đối tượng Validation và Constants để hỗ trợ nhập liệu và kiểm tra dữ liệu.

- displayMenuAndGetChoice()
  - In menu chính ra console.
  - Nhận lựa chọn từ người dùng.

- inputStudentId()
  - Yêu cầu nhập ID sinh viên.
  - Chuẩn hóa ID thành chữ in hoa.

- inputStudentName()
  - Yêu cầu nhập tên sinh viên.

- inputSemester()
  - Yêu cầu nhập học kỳ.

- inputCourse()
  - Yêu cầu nhập tên khóa học.
  - Chỉ cho phép các khóa học hợp lệ như Java, .Net, C/C++.

- askContinue()
  - Hỏi người dùng có muốn tiếp tục nhập thêm sinh viên không.

- displayStudentList(ArrayList<Student> studentList)
  - Hiển thị danh sách sinh viên theo định dạng bảng.

- inputSearchName()
  - Nhận tên cần tìm để tìm kiếm sinh viên.

- inputSearchId()
  - Nhận ID cần tìm.

- inputChoiceIndex(int maxIndex)
  - Yêu cầu người dùng chọn bản ghi khi có nhiều kết quả phù hợp.

- inputUpdateOrDelete()
  - Hỏi người dùng muốn cập nhật hay xóa.

- inputOptionalId(), inputOptionalName(), inputOptionalSemester(), inputOptionalCourse()
  - Các hàm nhập dữ liệu mới khi cập nhật.
  - Nếu người dùng nhập trống hoặc 0 thì giữ nguyên giá trị cũ.

- displayReportList(ArrayList<Report> reportList)
  - Hiển thị danh sách báo cáo theo format bảng.

- displayMessage(String message)
  - In một dòng thông báo ra console.

### 4.4 StudentModel
- StudentModel là lớp xử lý dữ liệu và logic nghiệp vụ.
- Nó quản lý danh sách sinh viên và thực hiện các thao tác CRUD cũng như thống kê báo cáo.

- StudentModel()
  - Khởi tạo danh sách studentList.

- getStudentCount()
  - Trả về số lượng sinh viên hiện có trong danh sách.

- addStudent(Student student)
  - Thêm một sinh viên mới vào danh sách.

- checkStudentRegistered(String id, int semester, String course)
  - Kiểm tra xem sinh viên đó đã đăng ký khóa học này trong học kỳ này chưa.

- findNameById(String id)
  - Tìm tên sinh viên bằng cách duyệt danh sách theo ID.

- findAndSortStudents(String searchName)
  - Tìm những sinh viên có tên chứa chuỗi nhập vào.
  - Sau đó sắp xếp kết quả theo tên.

- findStudentsById(String id)
  - Tìm tất cả sinh viên có cùng ID.

- updateStudentProperties(Student student, String id, int semester, String course)
  - Cập nhật thông tin của một sinh viên.
  - Chỉ cập nhật những trường có giá trị hợp lệ.

- updateStudentNameGlobally(String id, String newName)
  - Cập nhật tên cho tất cả các bản ghi có cùng ID.

- deleteStudent(Student student)
  - Xóa một sinh viên khỏi danh sách.

- generateReports()
  - Tạo danh sách báo cáo từ dữ liệu sinh viên.
  - Tính số lượng đăng ký theo từng cặp tên và khóa học.

### 4.5 Student
- Student là lớp model đại diện cho một đối tượng sinh viên.

- Student()
  - Constructor rỗng, tạo đối tượng sinh viên chưa có dữ liệu.

- Student(String id, int semester, String name, String courseName)
  - Constructor có tham số, khởi tạo đầy đủ thông tin cho sinh viên.

- Getter và Setter
  - getId(), setId(), getName(), setName(), getSemester(), setSemester(), getCourseName(), setCourseName()
  - Dùng để đọc và thay đổi thông tin của sinh viên.

- compareTo(Student other)
  - So sánh hai sinh viên theo tên.
  - Dùng cho việc sắp xếp danh sách.

- toString()
  - Trả về chuỗi formatted để in thông tin sinh viên ra console.

### 4.6 Report
- Report là lớp dùng để lưu kết quả thống kê báo cáo.

- Report(String studentName, String courseName, int totalCourse)
  - Khởi tạo một bản ghi báo cáo.

- Getter và Setter
  - getStudentName(), setStudentName(), getCourseName(), setCourseName(), getTotalCourse(), setTotalCourse()
  - Dùng để lấy và chỉnh sửa dữ liệu báo cáo.

- toString()
  - Trả về chuỗi biểu diễn báo cáo để hiển thị ra màn hình.

### 4.7 Validation
- Validation là lớp hỗ trợ kiểm tra và đọc dữ liệu đầu vào từ người dùng.

- Validation()
  - Khởi tạo Scanner để đọc dữ liệu từ bàn phím.

- getInteger(String msg, int min, int max)
  - Đọc một số nguyên từ người dùng.
  - Kiểm tra giá trị có rỗng, có phải số nguyên và có nằm trong khoảng cho phép hay không.

- getString(String msg, String regex, String exampleOfRegex)
  - Đọc một chuỗi phù hợp với regex cho trước.
  - Nếu không đúng định dạng thì yêu cầu nhập lại.

- checkYN(String msg)
  - Nhận lựa chọn Yes/No từ người dùng.

- checkUD(String msg)
  - Nhận lựa chọn Update/Delete từ người dùng.

### 4.8 Constants
- Constants là lớp lưu các hằng số cố định của chương trình.
- Nó giúp tránh việc hardcode các giá trị lặp lại như giới hạn học kỳ, regex, tên khóa học.

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
