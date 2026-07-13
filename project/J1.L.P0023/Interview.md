# Interview.md

## 1. Nội dung chính của bài toán

Đây là một chương trình quản lý cửa hàng hoa quả đơn giản theo mô hình MVC gồm 3 tầng chính:
- Model: lưu dữ liệu và logic nghiệp vụ như hoa quả, đơn hàng, tồn kho.
- View: chịu trách nhiệm hiển thị thông tin cho người dùng.
- Controller: điều phối luồng chương trình giữa người dùng, view và model.

Bài toán yêu cầu chương trình cho phép:
- Tạo mới sản phẩm hoa quả vào hệ thống.
- Xem danh sách đơn hàng đã lưu.
- Mua hàng cho khách (shopping).
- Thoát chương trình.

Ngoài ra, chương trình cần xử lý các tình huống như:
- ID sản phẩm trùng.
- Số lượng sản phẩm âm hoặc không hợp lệ.
- Hết hàng / không còn sản phẩm để bán.
- Người dùng muốn tiếp tục mua hay không.

## 2. Luồng chạy của chương trình

Chương trình bắt đầu từ file Main:
- Main tạo đối tượng FruitController.
- Gọi phương thức start() để bắt đầu vòng lặp chính của chương trình.

Luồng chính trong FruitController.start():
1. Hiển thị menu chính.
2. Nhận lựa chọn từ người dùng.
3. Dựa vào lựa chọn, thực hiện một trong các chức năng:
   - 1. Create Fruit: thêm sản phẩm mới.
   - 2. View orders: xem các đơn hàng đã lưu.
   - 3. Shopping: khách mua hàng.
   - 4. Exit: kết thúc chương trình.

### Luồng chức năng tạo sản phẩm
- Người dùng nhập ID, tên, giá, số lượng, nguồn gốc.
- Nếu ID đã tồn tại thì báo lỗi.
- Nếu hợp lệ thì thêm vào kho.
- Sau đó hỏi người dùng có tiếp tục tạo sản phẩm nữa không.

### Luồng chức năng mua hàng
- Kiểm tra xem trong kho có sản phẩm còn hàng hay không.
- Nếu không có thì báo “out of stock”.
- Nếu có thì hiển thị danh sách các sản phẩm có thể mua.
- Người dùng chọn sản phẩm và nhập số lượng.
- Hệ thống cập nhật số lượng tồn kho và thêm vào đơn hàng tạm thời.
- Người dùng có thể tiếp tục mua hoặc kết thúc.
- Khi kết thúc, nếu có sản phẩm trong đơn thì lưu đơn hàng và báo đã lưu.

## 3. Giải thích từng file

### 3.1 File: src/manager/Main.java
- Đây là điểm khởi động của chương trình.
- Chứa phương thức main.
- Tạo đối tượng FruitController và gọi start() để bắt đầu ứng dụng.

### 3.2 File: src/controller/FruitController.java
- Là lớp điều phối trung tâm của chương trình.
- Chịu trách nhiệm kết nối giữa View và Model.

#### Các hàm chính và ý nghĩa:
- FruitController(): constructor khởi tạo 3 thành phần phụ thuộc: FruitService, FruitView và Validation.
- start(): vòng lặp chính của chương trình, hiển thị menu, nhận lựa chọn và điều hướng tới chức năng tương ứng.
- createFruit(): xử lý chức năng tạo sản phẩm mới, bao gồm nhập ID, tên, giá, số lượng, nguồn gốc; kiểm tra trùng ID; gọi FruitService để thêm vào kho.
- shopping(): xử lý luồng mua hàng, kiểm tra tồn kho, hiển thị danh sách sản phẩm còn hàng, nhận số lượng mua, cập nhật đơn hàng và lưu lại khi khách xác nhận.

### 3.3 File: src/view/FruitView.java
- Là lớp giao diện, chịu trách nhiệm in thông tin ra console và thu thập dữ liệu từ người dùng.

#### Các hàm chính và ý nghĩa:
- displayMessage(String message): in thông báo thông thường lên màn hình.
- displayError(String message): in thông báo lỗi bằng luồng stderr.
- displayMenu(): hiển thị menu chính gồm các lựa chọn tạo hoa quả, xem đơn hàng, mua hàng và thoát.
- displayFruitList(List<Fruit> fruitList): in bảng danh sách hoa quả còn hàng để người dùng có thể chọn mua.
- displayInvoice(List<Order> orderList): in hóa đơn tạm thời cho đơn hàng hiện tại, bao gồm sản phẩm, số lượng, giá và tổng tiền.
- displayAllOrders(Map<String, List<Order>> ordersMap): hiển thị toàn bộ đơn hàng đã được lưu trong hệ thống.
- displaySelectedFruit(String fruitName): thông báo cho người dùng biết họ vừa chọn loại hoa quả nào.
- inputString(String prompt, Validation validation): nhận chuỗi từ người dùng sau khi kiểm tra dữ liệu đầu vào.
- inputDouble(String prompt, Validation validation): nhận số thực từ người dùng, thường dùng cho giá bán.
- inputInteger(String prompt, Validation validation): nhận số nguyên từ người dùng, thường dùng cho số lượng.
- inputIntegerLimit(String prompt, Validation validation, int min, int max): nhận số nguyên trong khoảng cho phép.
- inputYesNo(String prompt, Validation validation): nhận câu trả lời Yes/No để quyết định có tiếp tục hay không.

### 3.4 File: src/view/Validation.java
- Là lớp kiểm tra dữ liệu đầu vào.
- Đảm bảo người dùng nhập đúng định dạng trước khi chương trình xử lý.

#### Các hàm chính và ý nghĩa:
- Validation(): constructor khởi tạo Scanner để đọc dữ liệu từ bàn phím.
- checkInputIntLimit(int min, int max): kiểm tra số nguyên nhập vào có nằm trong khoảng từ min đến max hay không.
- checkInputString(): kiểm tra chuỗi nhập vào không rỗng.
- checkInputDouble(): kiểm tra số thực nhập vào là số dương hoặc bằng 0.
- checkInputInt(): kiểm tra số nguyên nhập vào là số không âm.
- checkInputYN(): kiểm tra người dùng nhập đúng Y/N và trả về true/false tương ứng.

### 3.5 File: src/model/Fruit.java
- Đại diện cho một loại hoa quả trong kho.
- Lưu thông tin: ID, tên, giá, số lượng, nguồn gốc.

#### Các hàm chính:
- Getter và setter cho các thuộc tính.
- Constructor khởi tạo đối tượng Fruit.

### 3.6 File: src/model/Order.java
- Đại diện cho một mục trong đơn hàng.
- Lưu tên sản phẩm, số lượng, giá và tổng tiền của item đó.

#### Các hàm chính:
- Getter và setter cho các thuộc tính.
- Constructor khởi tạo đơn hàng item.
- getAmount(): tính tổng tiền của item.

### 3.7 File: src/model/FruitService.java
- Chứa logic nghiệp vụ liên quan đến kho hàng và đơn hàng.

#### Các hàm chính và ý nghĩa:
- FruitService(): constructor khởi tạo danh sách hoa quả và bản đồ đơn hàng rỗng.
- getOrdersMap(): lấy toàn bộ đơn hàng đã lưu trong hệ thống.
- isFruitIdExists(String id): kiểm tra xem ID hoa quả đã tồn tại trong kho hay chưa.
- addFruit(String id, String name, double price, int quantity, String origin): thêm một sản phẩm mới vào kho hàng.
- hasAvailableFruit(): kiểm tra xem hiện tại có ít nhất một loại hoa quả còn hàng không.
- getAvailableFruitList(): lấy danh sách các sản phẩm vẫn còn số lượng > 0 để bán.
- createOrderList(): tạo danh sách đơn hàng tạm thời cho một phiên mua hàng.
- addOrderItem(List<Order> orderList, Fruit fruit, int quantity): thêm sản phẩm vào đơn hàng hiện tại và đồng thời giảm số lượng tồn kho.
- saveOrder(String customerName, List<Order> orderList): lưu đơn hàng sau khi khách hoàn tất giao dịch.
- updateOrderList(List<Order> orderList, Fruit fruit, int quantity): cập nhật danh sách đơn hàng hiện tại, gom nhóm cùng loại sản phẩm nếu đã có trong đơn.
- findFruitById(String id): tìm một loại hoa quả trong kho bằng ID.

### 3.8 File: src/model/Constants.java
- Chứa các hằng số dùng chung cho chương trình.
- Không phải lớp xử lý logic mà chủ yếu lưu trữ:
  - thông báo menu,
  - thông báo lỗi,
  - câu nhắc nhập dữ liệu,
  - định dạng bảng,
  - thông báo hết hàng, thêm thành công, lưu đơn thành công.

### 3.9 File: src/manager/Main.java
- Là lớp khởi động của chương trình.
- Chứa phương thức main để chạy ứng dụng.

#### Các hàm chính và ý nghĩa:
- main(String[] args): điểm bắt đầu của chương trình, tạo đối tượng FruitController và gọi start() để kích hoạt vòng lặp chính.

## 4. Tóm tắt ngắn gọn

Chương trình là một ứng dụng console quản lý cửa hàng hoa quả đơn giản. Người dùng có thể thêm sản phẩm, mua hàng và xem đơn hàng. Mỗi lớp có trách nhiệm riêng:
- Controller điều phối.
- View hiện thị.
- Model xử lý dữ liệu và logic.

## 5. Câu hỏi và trả lời theo dạng interview 1:1

### Giảng viên: Chương trình này được xây dựng theo mô hình nào?
Sinh viên: Chương trình được xây dựng theo mô hình MVC, gồm ba thành phần là Model, View và Controller.

### Giảng viên: Vai trò của Main.java là gì?
Sinh viên: Main.java là điểm khởi đầu của chương trình. Nó tạo đối tượng FruitController và gọi phương thức start() để bắt đầu chạy chương trình.

### Giảng viên: FruitController làm nhiệm vụ gì?
Sinh viên: FruitController là lớp điều phối trung tâm. Nó nhận lựa chọn từ người dùng, gọi đúng chức năng tương ứng và kết nối giữa View và Model.

### Giảng viên: Luồng chạy chính của chương trình bắt đầu như thế nào?
Sinh viên: Khi chương trình chạy, hệ thống hiển thị menu. Người dùng chọn chức năng, sau đó controller sẽ điều hướng tới chức năng phù hợp như tạo sản phẩm, xem đơn hàng hoặc mua hàng.

### Giảng viên: Khi người dùng chọn chức năng tạo sản phẩm, chương trình xử lý thế nào?
Sinh viên: Hệ thống sẽ yêu cầu nhập ID, tên, giá, số lượng và nguồn gốc. Nếu ID đã tồn tại thì báo lỗi, còn nếu hợp lệ thì thêm vào danh sách sản phẩm.

### Giảng viên: Khi người dùng chọn mua hàng, chương trình làm gì?
Sinh viên: Trước tiên chương trình kiểm tra xem có sản phẩm còn hàng hay không. Nếu không còn thì báo out of stock. Nếu còn thì hiển thị danh sách sản phẩm và cho người dùng chọn.

### Giảng viên: Số lượng hàng bị giảm như thế nào?
Sinh viên: Khi người dùng xác nhận mua một số lượng nhất định, FruitService sẽ cập nhật lại số lượng tồn kho bằng cách trừ đi số lượng đã mua.

### Giảng viên: Đơn hàng được lưu ở đâu?
Sinh viên: Đơn hàng được lưu trong cấu trúc dữ liệu của FruitService, cụ thể là map ordersMap, nơi mỗi khách hàng có thể có một danh sách đơn hàng.

### Giảng viên: Tại sao cần tách View và Controller riêng?
Sinh viên: Vì View chỉ chịu trách nhiệm hiển thị, còn Controller chịu trách nhiệm điều phối logic. Việc tách riêng giúp code dễ đọc, dễ sửa và dễ bảo trì hơn.

### Giảng viên: Vai trò của Validation là gì?
Sinh viên: Validation dùng để kiểm tra đầu vào của người dùng, đảm bảo dữ liệu nhập vào hợp lệ trước khi xử lý.

### Giảng viên: Constants có ý nghĩa gì?
Sinh viên: Constants chứa các hằng số dùng chung như thông báo, prompt nhập liệu và định dạng bảng, giúp chương trình thống nhất và dễ quản lý.

## 6. Ý nghĩa của việc phân chia lớp

Việc phân tách này giúp chương trình dễ hiểu, dễ bảo trì và mở rộng hơn:
- Nếu muốn đổi giao diện, chỉ sửa View.
- Nếu muốn thay đổi logic kho hàng, chỉ sửa FruitService.
- Nếu muốn đổi luồng chương trình, chỉ sửa FruitController.
