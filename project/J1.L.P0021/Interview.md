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

## 5. Các câu hỏi Interview OOP & Trả lời (Strict Lab Defense)

### 5.1 Student.java & OOP Fundamentals
1. **Câu hỏi 1**: Tại sao tất cả các thuộc tính (`id`, `name`, `semester`, `courseName`) trong lớp Student lại được khai báo là `private` mà không phải `public` hay `protected`? Đóng gói (Encapsulation) sẽ bị phá vỡ thế nào nếu dùng `public`?
   * **Trả lời**: Khai báo `private` để áp dụng nguyên lý đóng gói (Encapsulation), bảo vệ trạng thái nội bộ của đối tượng không bị truy cập và sửa đổi tự do từ bên ngoài. Nếu dùng `public`, bất cứ lớp nào cũng có thể thay đổi trực tiếp giá trị của các thuộc tính (ví dụ: `student.semester = -99`), làm mất tính toàn vẹn và mất đi quyền kiểm soát dữ liệu hợp lệ của lớp.
2. **Câu hỏi 2**: Tại sao lớp Student lại cần cả constructor không tham số lẫn constructor có tham số? Chuyện gì xảy ra nếu tôi xóa constructor không tham số đi? Dòng code nào trong dự án sẽ bị lỗi biên dịch?
   * **Trả lời**: Constructor có tham số giúp khởi tạo nhanh đối tượng cùng với dữ liệu cụ thể. Constructor không tham số được viết để cho phép khởi tạo đối tượng trống và gán giá trị sau bằng setter (rất cần thiết khi làm việc với một số thư viện ánh xạ hoặc framework dữ liệu). Nếu xóa constructor không tham số, Java sẽ không tự động tạo constructor mặc định nữa. Khi đó, bất cứ dòng code nào gọi `new Student()` (không truyền đối số) sẽ bị lỗi biên dịch.
3. **Câu hỏi 3**: Tại sao phương thức `compareTo` và `toString` lại có annotation `@Override`? Nếu xóa annotation này đi thì code có biên dịch được không? Tại sao?
   * **Trả lời**: `@Override` báo hiệu cho trình biên dịch (Compiler) kiểm tra xem phương thức đó có thực sự ghi đè phương thức của lớp cha hoặc interface hay không. Nếu xóa `@Override`, code vẫn biên dịch được với điều kiện ta viết đúng chính xác chữ ký phương thức (signature). Tuy nhiên, nếu viết sai chính tả chữ ký phương thức (ví dụ: viết nhầm thành `toSting()`), compiler sẽ coi đó là phương thức mới hoàn toàn của lớp `Student` thay vì báo lỗi viết sai cú pháp ghi đè, dẫn đến lỗi logic nghiêm trọng khi chạy chương trình.
4. **Câu hỏi 4**: Tại sao lớp Student lại implements Comparable thay vì dùng Comparator? Sự khác nhau cốt lõi giữa hai interface này là gì?
   * **Trả lời**: Dùng `Comparable` để định nghĩa tiêu chí so sánh tự nhiên (Natural Ordering) mặc định, duy nhất được cài đặt trực tiếp bên trong lớp `Student` (thông qua `compareTo`). Còn `Comparator` đại diện cho các bộ so sánh tùy biến bên ngoài lớp (thông qua `compare`), thường dùng khi cần nhiều tiêu chí sắp xếp khác nhau (ví dụ: lúc xếp theo tên, lúc xếp theo học kỳ). Bài toán chỉ yêu cầu sắp xếp theo tên mặc định nên cài đặt `Comparable` là đủ.
5. **Câu hỏi 5**: Trong phương thức `compareTo`, chuyện gì xảy ra nếu trường `name` của một trong hai đối tượng bị `null`? Bạn xử lý ngoại lệ này như thế nào?
   * **Trả lời**: Nếu `name` bị `null`, lời gọi hàm `this.getName().compareTo(other.getName())` sẽ ngay lập tức ném ra ngoại lệ `NullPointerException`. Để xử lý an toàn, cần kiểm tra `null` trước khi thực hiện so sánh, ví dụ: quy ước đối tượng có `name` là `null` sẽ được xếp trước hoặc xếp sau (trả về `-1` hoặc `1`).

### 5.2 StudentModel.java & Data Structures
6. **Câu hỏi 6**: Tại sao thuộc tính `studentList` trong lớp StudentModel lại được khai báo với kiểu cụ thể là `ArrayList<Student>` thay vì kiểu Interface `List<Student>`? Thiết kế này có vi phạm nguyên tắc "Program to an interface, not an implementation" không?
   * **Trả lời**: Thiết kế này vi phạm nguyên tắc. Việc khai báo kiểu cụ thể `ArrayList` làm tăng sự phụ thuộc chặt chẽ (tight coupling) vào cấu trúc dữ liệu. Lẽ ra nên khai báo `private List<Student> studentList` để có thể dễ dàng thay đổi kiểu cài đặt bên dưới (ví dụ sang `LinkedList` hoặc `CopyOnWriteArrayList` cho đa luồng) mà không phải thay đổi các dòng code khai báo thuộc tính.
7. **Câu hỏi 7**: Trong hàm `updateStudentNameGlobally` của StudentModel, tại sao bạn phải duyệt qua toàn bộ danh sách để đổi tên cho tất cả sinh viên cùng ID? Thiết kế cơ sở dữ liệu/đối tượng ở đây bị lỗi gì dẫn đến việc dữ liệu bị phân mảnh như vậy?
   * **Trả lời**: Thiết kế bị lỗi dư thừa dữ liệu (Data Redundancy) và vi phạm nguyên tắc chuẩn hóa dữ liệu. Do cấu trúc thiết kế gộp chung thông tin đăng ký học kỳ/khóa học với thông tin cá nhân của sinh viên vào một lớp `Student`. Đáng lẽ thông tin thực thể Sinh viên (`id`, `name`) phải được tách thành một lớp riêng biệt và độc lập với thông tin đăng ký học (`StudentId`, `courseName`, `semester`) để khi thay đổi thông tin cá nhân chỉ cần cập nhật tại một nơi duy nhất.
8. **Câu hỏi 8**: Tại sao phương thức `getStudentCount()` lại chỉ đơn giản là `return studentList.size()`? Tại sao không cho Controller truy cập trực tiếp vào `studentList`?
   * **Trả lời**: Để tuân thủ nguyên lý đóng gói thông tin. Nếu Controller nắm giữ và thao tác trực tiếp trên danh sách gốc `studentList`, nó có thể tùy ý gọi hàm `add()`, `clear()`, hay `remove()` phá vỡ hoàn toàn các quy tắc kiểm tra và logic nghiệp vụ được quản lý tập trung ở Model.
9. **Câu hỏi 9**: Chuyện gì xảy ra về mặt hiệu năng (Time Complexity) khi gọi `findAndSortStudents()` trên một danh sách có hàng triệu sinh viên? Tại sao việc sao chép danh sách rồi sắp xếp lại mỗi lần tìm kiếm là một thiết kế tồi?
   * **Trả lời**: Độ phức tạp thời gian khi sắp xếp sẽ là $O(N \log N)$ (Timsort của Java). Khi danh sách có hàng triệu bản ghi, việc sao chép mảng và sắp xếp lại liên tục trên RAM sẽ tiêu tốn tài nguyên bộ nhớ rất lớn và làm ứng dụng bị chậm, đơ. Thiết kế tối ưu hơn là duy trì một danh sách đã sắp xếp trước hoặc sử dụng cấu trúc dữ liệu tự sắp xếp (như `TreeSet`) hoặc đẩy phần xử lý lọc/sắp xếp xuống hệ quản trị cơ sở dữ liệu (Database Indexing).
10. **Câu hỏi 10**: Tại sao phương thức `deleteStudent` lại dùng `studentList.remove(student)`? Cơ chế so sánh của `ArrayList.remove(Object)` dựa trên phương thức nào của lớp `Student`? Lớp `Student` của bạn đã override phương thức đó chưa, và chuyện gì xảy ra nếu chưa?
    * **Trả lời**: `ArrayList.remove(Object)` duyệt qua danh sách và gọi phương thức `equals(Object)` của từng phần tử để so sánh với đối tượng cần xóa. Lớp `Student` hiện tại chưa override phương thức `equals(Object)`, vì vậy Java sẽ sử dụng triển khai mặc định của lớp `Object` (so sánh địa chỉ tham chiếu vùng nhớ bằng toán tử `==`). Chuyện xảy ra nếu chưa override là: ta chỉ có thể xóa được phần tử nếu truyền chính xác đối tượng cùng địa chỉ bộ nhớ Heap; nếu truyền một đối tượng sinh viên mới có cùng `id` và thông tin nhưng được tạo bằng từ khóa `new` ở nơi khác, hàm `remove()` sẽ không tìm thấy và không xóa được.

### 5.3 Constants.java & Design Decisions
11. **Câu hỏi 11**: Tại sao các hằng số trong lớp Constants lại được khai báo là `public final` mà không có từ khóa `static`?
    * **Trả lời**: Đây là lỗi thiết kế. Thiếu từ khóa `static` làm cho các thuộc tính này trở thành biến thực thể (instance variables). Các hằng số này sẽ không được nạp chung ở cấp độ lớp mà chỉ tồn tại khi ta khởi tạo đối tượng `new Constants()`.
12. **Câu hỏi 12**: Không có từ khóa `static`, mỗi lần khởi tạo một đối tượng cần dùng hằng số (như `StudentView` hay `StudentController`), vùng nhớ Heap sẽ bị ảnh hưởng như thế nào?
    * **Trả lời**: Mỗi lần khởi tạo một lớp cần dùng hằng số, Java sẽ tạo ra một thực thể `Constants` mới trên bộ nhớ Heap chứa các bản sao của tất cả thuộc tính hằng số này. Điều này gây lãng phí bộ nhớ Heap không cần thiết và tạo ra nhiều đối tượng rác khiến Garbage Collector (GC) phải dọn dẹp liên tục, làm giảm hiệu suất tổng thể của ứng dụng.
13. **Câu hỏi 13**: Tại sao không khai báo lớp Constants là một `interface` hoặc `enum`? Khi nào nên dùng `interface` để chứa hằng số và tại sao việc đó lại được coi là một Anti-pattern (Constant Interface Pattern)?
    * **Trả lời**: Dùng `interface` chỉ để chứa hằng số được coi là một Anti-pattern (Constant Interface Pattern) vì interface đại diện cho giao diện hành vi và thiết lập hợp đồng thiết kế cho các lớp triển khai nó. Việc implements interface chỉ để sử dụng các hằng số sẽ làm lộ chi tiết triển khai nội bộ ra API công khai của lớp con. Do đó, thiết kế chuẩn mực là sử dụng một lớp cụ thể (`final class`) kết hợp với constructor `private` để ngăn khởi tạo thực thể, và khai báo các hằng số là `public static final`.
14. **Câu hỏi 14**: Điều gì xảy ra nếu tôi cố tình thay đổi giá trị của `MIN_CHOICE` trong runtime? Tại sao compiler lại ngăn chặn việc này?
    * **Trả lời**: Trình biên dịch sẽ báo lỗi cú pháp ngay khi compile. Compiler ngăn chặn vì từ khóa `final` định nghĩa rằng thuộc tính đó là biến chỉ đọc (read-only) và không được phép gán lại giá trị mới sau khi đã được khởi tạo.
15. **Câu hỏi 15**: Tại sao bạn lại tạo hẳn một class Constants riêng biệt thay vì khai báo trực tiếp hằng số ở nơi sử dụng chúng?
    * **Trả lời**: Để quản lý hằng số tập trung tại một nơi (Centralized Configuration), tránh tình trạng trùng lặp mã nguồn và sử dụng các "Magic Values" rải rác trong code. Điều này giúp code dễ đọc hơn và khi cần thay đổi giá trị cấu hình (ví dụ: thay đổi `MAX_SEMESTER` lên 12) thì chỉ cần sửa ở đúng một vị trí.

### 5.4 StudentController.java & StudentView.java (Architecture & Control Flow)
16. **Câu hỏi 16**: Tại sao StudentController lại giữ các tham chiếu đến cả `StudentModel`, `StudentView` và `Constants`? Mối quan hệ giữa các lớp này thuộc loại quan hệ nào trong OOP (Association, Aggregation hay Composition)?
    * **Trả lời**: Controller đóng vai trò là bộ não điều phối dữ liệu giữa Model và View nên cần tham chiếu đến cả hai lớp này. Đây là mối quan hệ kết hợp (Association), cụ thể là Aggregation (Tụ hợp), vì các đối tượng Model và View được truyền vào Controller từ bên ngoài và có vòng đời độc lập, không bị hủy khi đối tượng Controller bị hủy.
17. **Câu hỏi 17**: Tại sao StudentView không được phép gọi trực tiếp `StudentModel` để lấy dữ liệu? Kiến trúc MVC sẽ bị phá vỡ thế nào nếu View tự ý thay đổi dữ liệu trong Model?
    * **Trả lời**: Để giữ sự độc lập giữa giao diện hiển thị (View) và logic xử lý dữ liệu (Model) nhằm tăng khả năng bảo trì và tái sử dụng. Nếu View gọi trực tiếp Model để thao tác dữ liệu, liên kết giữa chúng sẽ trở nên chặt chẽ (tight coupling). Khi giao diện thay đổi, logic nghiệp vụ cũng bị ảnh hưởng hoặc ngược lại. Nó cũng làm mất đi khả năng kiểm soát luồng dữ liệu trung tâm của Controller.
18. **Câu hỏi 18**: Trong hàm `run()` của StudentController, tại sao lại dùng vòng lặp `while (true)`? Thiết kế này có thể gây ra vấn đề gì về hiệu năng và tài nguyên hệ thống nếu không được kiểm soát tốt?
    * **Trả lời**: Vòng lặp `while (true)` duy trì giao diện console chạy liên tục và chỉ dừng khi người dùng chủ động chọn chức năng thoát (chọn 5). Nếu trong vòng lặp không chứa bất kỳ câu lệnh chặn luồng (blocking call) nào để chờ đợi dữ liệu vào (như đọc dữ liệu từ `Scanner`), CPU sẽ bị cuốn vào vòng lặp vô hạn chạy với tốc độ tối đa, đẩy mức sử dụng CPU lên 100% (gây ra lỗi Busy-waiting / Spinning).
19. **Câu hỏi 19**: Tại sao các phương thức xử lý sự kiện như `handleCreateStudent` hay `handleUpdateOrDelete` lại nằm ở Controller chứ không nằm ở Model?
    * **Trả lời**: Vì đây là logic điều phối luồng xử lý của ứng dụng (Workflow Logic / Application Logic), không phải logic nghiệp vụ dữ liệu cốt lõi (Domain Logic). Controller điều phối bằng cách: nhận chỉ thị, gọi View để lấy thông tin nhập liệu của người dùng, kiểm tra điều kiện nghiệp vụ thông qua Model, ghi nhận dữ liệu vào Model, và ra lệnh cho View cập nhật thông tin hiển thị. Model chỉ nên tập trung quản lý dữ liệu và thực thi các quy tắc nghiệp vụ của riêng nó.
20. **Câu hỏi 20**: Nếu tôi muốn thay thế giao diện Console hiện tại bằng giao diện đồ họa (GUI) như JavaFX, tôi sẽ phải sửa đổi những lớp nào? Thiết kế hiện tại của bạn đã thực sự đảm bảo tính "Loose Coupling" (liên kết lỏng) chưa?
    * **Trả lời**: Ta sẽ phải sửa đổi hoặc viết lại hoàn toàn lớp `StudentView`, đồng thời sửa lại các đoạn mã gọi View trong `StudentController`. Thiết kế hiện tại chưa thực sự đạt được liên kết lỏng (loose coupling) hoàn hảo vì Controller vẫn trực tiếp khai báo và phụ thuộc vào lớp cụ thể `StudentView`. Thiết kế chuẩn hơn là Controller nên giao tiếp với View thông qua một Interface (ví dụ: `IStudentView`), khi đó chỉ cần truyền đối tượng cài đặt giao diện GUI vào Controller mà không cần thay đổi bất cứ dòng code nào của Controller.

