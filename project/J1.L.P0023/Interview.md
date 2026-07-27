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

## 4. Các câu hỏi Interview OOP & Trả lời (Strict Lab Defense)

### 4.1 Fruit.java & Order.java (Encapsulation & Data Modeling)
1. **Câu hỏi 1**: Tại sao tất cả các thuộc tính (`fruitId`, `fruitName`, `price`, `quantity`, `origin`) trong lớp `Fruit` đều là `private`? Tại sao không dùng `public` hay `protected`?
   * **Trả lời**: Khai báo `private` để thực thi tính ẩn giấu dữ liệu (data hiding) và đóng gói (Encapsulation), bảo vệ trạng thái của đối tượng khỏi các sửa đổi ngoài ý muốn từ bên ngoài. Nếu dùng `public`, bất kì lớp nào cũng có thể gán lại giá trị trực tiếp. Còn `protected` sẽ mở quyền truy cập cho tất cả các lớp trong cùng package `model` và lớp con bên ngoài, làm suy giảm tính đóng gói.
2. **Câu hỏi 2**: Nếu tôi đổi từ `private` sang `protected`, những lớp nào bên ngoài package `model` có thể truy cập trực tiếp các thuộc tính này? Tại sao không làm như vậy?
   * **Trả lời**: Chỉ có các lớp con (subclasses) kế thừa từ lớp `Fruit` nhưng nằm ở package ngoài mới có quyền truy cập trực tiếp. Ta không làm vậy vì muốn đảm bảo mọi truy cập đến thuộc tính đều phải đi qua các hàm getter/setter công khai. Điều này giúp kiểm soát giá trị gán vào luôn hợp lệ (ví dụ: số lượng tồn kho `quantity` không được phép âm).
3. **Câu hỏi 3**: Tại sao lớp `Order` không chứa `fruitId` mà chỉ có `fruitName`? Thiết kế này có thể dẫn đến hậu quả gì nếu có nhiều loại quả khác nhau nhưng trùng tên (ví dụ: Táo Mỹ giá $5 và Táo Úc giá $3)?
   * **Trả lời**: Việc thiếu trường định danh duy nhất `fruitId` trong lớp `Order` là một lỗi thiết kế mô hình dữ liệu. Hậu quả là khi khách hàng chọn mua hai loại trái cây khác nhau nhưng trùng tên (như Táo Mỹ giá $5 và Táo Úc giá $3), hệ thống so sánh theo tên sẽ nhận diện chúng là một sản phẩm, dẫn đến cộng dồn số lượng sai lệch và tính toán sai tiền thanh toán của hóa đơn.
4. **Câu hỏi 4**: Tại sao hàm `getAmount()` trong `Order` lại tính toán động `price * quantity` thay vì lưu vào một thuộc tính `amount` riêng biệt và dùng setter? Nguyên tắc "Single Source of Truth" được áp dụng thế nào ở đây?
   * **Trả lời**: Để đảm bảo tính nhất quán dữ liệu (Data Consistency). `amount` (thành tiền) luôn là giá trị phái sinh từ `price` và `quantity`. Nếu tạo một thuộc tính và dùng setter, ta có nguy cơ cập nhật số lượng hoặc giá mà quên cập nhật thành tiền, dẫn đến mâu thuẫn dữ liệu. Tính toán động giúp lấy dữ liệu từ nguồn gốc duy nhất (Single Source of Truth) là `price` và `quantity`.
5. **Câu hỏi 5**: Tại sao lớp `Fruit` không kế thừa từ lớp `Order` hoặc ngược lại? Mối quan hệ "is-a" và "has-a" ở đây được định nghĩa như thế nào?
   * **Trả lời**: Vì giữa `Fruit` and `Order` không có quan hệ kế thừa "is-a" (Trái cây không phải là một dạng của Đơn hàng, và ngược lại). Chúng có quan hệ "has-a" (Đơn hàng chứa/sử dụng thông tin của Trái cây). Kế thừa sai mục đích sẽ vi phạm nguyên lý Liskov Substitution Principle (LSP) trong SOLID.

### 4.2 FruitService.java & Data Operations
6. **Câu hỏi 6**: Tại sao các trường dữ liệu `fruitList` và `ordersMap` trong `FruitService` lại được khai báo là `final`? Từ khóa `final` ở đây bảo vệ cái gì, và nó không bảo vệ cái gì?
   * **Trả lời**: Từ khóa `final` bảo vệ tham chiếu (reference) của biến `fruitList` và `ordersMap` không bị trỏ sang một đối tượng danh sách hoặc bản đồ khác. Tuy nhiên, nó KHÔNG bảo vệ dữ liệu bên trong tập hợp; ta vẫn có thể gọi các phương thức sửa đổi dữ liệu bên trong như `add()`, `remove()`, `clear()` hoặc gán đè phần tử bình thường.
7. **Câu hỏi 7**: Tại sao `ordersMap` lại dùng kiểu `Map<String, List<Order>>` với key là `customerName` (String)? Chuyện gì xảy ra nếu hai khách hàng khác nhau cùng tên là "An" mua hàng? Làm cách nào để sửa thiết kế này mà không làm hỏng tính đóng gói?
   * **Trả lời**: Dùng `customerName` (String) làm key của Map sẽ gây lỗi ghi đè hoặc gộp chung hóa đơn của các khách hàng có cùng tên `"An"`. Để sửa, cần dùng một thực thể `Customer` có trường `id` hoặc số điện thoại độc nhất để làm key của Map thay vì dùng String tên đơn giản.
8. **Câu hỏi 8**: Trong hàm `updateOrderList` của `FruitService`, tại sao bạn lại so sánh tên quả bằng `order.getFruitName().equals(fruit.getFruitName())`? Tại sao không so sánh bằng `fruitId`?
   * **Trả lời**: Do lớp `Order` không lưu trữ thuộc tính `fruitId` để định danh sản phẩm trong giỏ hàng. Đây là hạn chế lớn trong thiết kế, lẽ ra lớp `Order` phải chứa `fruitId` để so sánh và phân biệt chính xác các sản phẩm khi giỏ hàng được cập nhật.
9. **Câu hỏi 9**: Tại sao các phương thức trong `FruitService` không nhận trực tiếp đối tượng `Scanner` để nhập liệu mà phải nhận các tham số nguyên thủy hoặc đối tượng đã được chuẩn hóa? Điều này liên quan gì đến nguyên tắc Single Responsibility Principle (SRP)?
   * **Trả lời**: Giúp tách biệt logic xử lý nghiệp vụ với giao diện nhập liệu của người dùng. `FruitService` chỉ có nhiệm vụ tính toán, thêm bớt dữ liệu kho chứ không quan tâm dữ liệu đến từ console hay tệp tin. Nếu nhận trực tiếp `Scanner`, Service sẽ bị liên kết cứng với giao diện console, vi phạm SRP.
10. **Câu hỏi 10**: Tại sao phương thức `getAvailableFruitList()` lại trả về một `ArrayList` mới thay vì trả về trực tiếp reference của `fruitList`? Việc trả về direct reference của một private collection sẽ gây ra lỗ hổng bảo mật nào trong OOP (Representation Exposure)?
    * **Trả lời**: Trả về danh sách mới để ngăn chặn lỗ hổng rò rỉ chi tiết cài đặt (Representation Exposure). Nếu trả về trực tiếp reference của `fruitList`, các lớp bên ngoài có thể gọi `clear()` hoặc `remove()` trực tiếp trên danh sách này để sửa đổi kho hàng mà không đi qua các phương thức nghiệp vụ của `FruitService`, phá vỡ tính đóng gói dữ liệu của Service.

### 4.3 Constants.java & Utility Classes
11. **Câu hỏi 11**: Tại sao các hằng số ở đây lại là `public static final`?
    * **Trả lời**: `public` để mọi lớp khác đều có thể sử dụng. `static` để biến thuộc về cấp độ Class, nạp duy nhất một lần vào Metaspace nhằm tiết kiệm bộ nhớ Heap. `final` để biến chúng thành hằng số chỉ đọc, ngăn chặn việc gán lại giá trị trong suốt quá trình ứng dụng thực thi.
12. **Câu hỏi 12**: Tại sao lớp `Constants` lại có một constructor `private Constants()` rỗng và không làm gì cả? Chuyện gì xảy ra nếu tôi cố tình viết `new Constants()` ở các lớp khác?
    * **Trả lời**: Constructor `private` để ngăn chặn việc khởi tạo thực thể (instantiation) của lớp `Constants`. Lớp này chỉ chứa các hằng số tĩnh nên việc tạo đối tượng của nó là dư thừa và gây lãng phí bộ nhớ Heap. Nếu cố tình viết `new Constants()` ở lớp khác, trình biên dịch sẽ báo lỗi cú pháp ngay lập tức.
13. **Câu hỏi 13**: So sánh class `Constants` này với class `Constants` trong project `J1.L.P0021` (không dùng static). Hãy chỉ ra sự khác biệt về cách cấp phát bộ nhớ và hiệu năng giữa hai thiết kế này.
    * **Trả lời**: Trong P0023, vì dùng `public static final` nên các hằng số được lưu trữ một lần duy nhất tại vùng nhớ Metaspace khi nạp lớp, các đối tượng dùng chung một vùng nhớ. Trong P0021, do thiếu từ khóa `static`, các hằng số là biến thực thể; mỗi lần gọi `new StudentView()` hay `new StudentController()`, Java phải cấp phát vùng nhớ Heap để sao chép lại toàn bộ các hằng số đó, làm lãng phí Heap và làm giảm hiệu năng hệ thống do Garbage Collector phải dọn dẹp các đối tượng rác liên tục.
14. **Câu hỏi 14**: Tại sao không chuyển `Constants` thành một `interface` và implements nó ở các lớp khác để sử dụng trực tiếp các hằng số? Giải thích tại sao hành động đó lại bị coi là một thiết kế tồi.
    * **Trả lời**: Đây là Constant Interface Pattern, một lỗi thiết kế (Anti-pattern). Interface dùng để định nghĩa hành vi và cam kết triển khai API công khai của lớp con. Việc implements interface chỉ để sử dụng các hằng số tĩnh sẽ làm rò rỉ chi tiết triển khai nội bộ ra ngoài, gây khó khăn cho việc bảo trì và vi phạm các nguyên tắc thiết kế OOP.
15. **Câu hỏi 15**: Tại sao bạn lại khai báo hằng số `YES = "Y"` và `NO = "N"`? Tại sao không dùng trực tiếp kiểu dữ liệu `boolean` hoặc một `enum` chuyên biệt cho các lựa chọn này?
    * **Trả lời**: Dùng String `"Y"`/`"N"` làm tăng nguy cơ sai kiểu dữ liệu (lack of type safety) và dễ gõ sai chuỗi gây lỗi runtime. Lẽ ra nên dùng kiểu `boolean` (đúng/sai) hoặc cấu trúc `enum` để kiểm soát kiểu chặt chẽ từ thời điểm biên dịch (Compile-time Type Safety).

### 4.4 FruitController.java & FruitView.java (Architecture & Control Flow)
16. **Câu hỏi 16**: Tại sao `FruitController` lại nhận các đối tượng `FruitService`, `FruitView` và `Validation` qua constructor (Dependency Injection)? Tại sao không dùng từ khóa `new` để tự khởi tạo chúng ngay bên trong controller?
    * **Trả lời**: Nhận thông qua constructor giúp giảm liên kết cứng (Loose Coupling). Điều này giúp `FruitController` trở nên linh hoạt hơn vì ta có thể dễ dàng truyền các lớp cài đặt khác nhau hoặc truyền đối tượng Mock khi viết các kiểm thử đơn vị (Unit Tests) mà không cần chỉnh sửa code của Controller.
17. **Câu hỏi 17**: Khi người dùng chọn mua hàng, làm sao để Controller đảm bảo rằng số lượng người dùng nhập không vượt quá số lượng tồn kho của loại hoa quả đó trong Model? Logic kiểm tra này thuộc về Model, View, hay Controller? Tại sao?
    * **Trả lời**: Logic kiểm tra số lượng phải nằm ở Model (trong `FruitService` hoặc đối tượng `Fruit`), vì Model chịu trách nhiệm quản lý dữ liệu và thực thi các quy tắc nghiệp vụ. Controller chỉ làm nhiệm vụ điều hướng: nhận số lượng từ View, gửi yêu cầu tới Model để kiểm tra xem có đủ hàng không, nhận kết quả và điều khiển View hiển thị lỗi nếu không đủ.
18. **Câu hỏi 18**: Tại sao `FruitView` không giữ một tham chiếu nào đến `FruitService`? Nếu View tự gọi Service để lấy dữ liệu in ra màn hình mà bỏ qua Controller thì chuyện gì sẽ xảy ra?
    * **Trả lời**: Nhằm duy trì tính Separation of Concerns (phân tách trách nhiệm). Nếu View tự gọi Service, View sẽ phụ thuộc trực tiếp vào nghiệp vụ của Model. Khi logic lưu trữ hoặc xử lý dữ liệu thay đổi, ta phải sửa lại cả code View, làm giảm tính độc lập và khả năng tái sử dụng của View.
19. **Câu hỏi 19**: Tại sao phương thức `displayError(String message)` trong `FruitView` lại dùng `System.err.println` thay vì `System.out.println`? Sự khác biệt về mặt luồng xuất dữ liệu (Output Stream) ở đây là gì?
    * **Trả lời**: `System.err` hướng đầu ra tới Standard Error Stream (luồng lỗi tiêu chuẩn), trong khi `System.out` hướng tới Standard Output Stream (luồng xuất tiêu chuẩn). Việc này giúp tách biệt lỗi khỏi đầu ra thông thường của chương trình, cho phép hệ thống chuyển hướng ghi log lỗi ra một tệp tin riêng để theo dõi và xử lý.
20. **Câu hỏi 20**: Nếu yêu cầu thay đổi cấu trúc lưu trữ đơn hàng từ `Map` sang một File hoặc Cơ sở dữ liệu (Database), những lớp nào sẽ phải thay đổi code và lớp nào hoàn toàn không bị ảnh hưởng? Kiến trúc hiện tại đã đạt được tính độc lập dữ liệu chưa?
    * **Trả lời**: Chỉ có lớp `FruitService` (hoặc lớp Repository chịu trách nhiệm truy xuất dữ liệu) là phải thay đổi mã nguồn. Các lớp `FruitView` và `FruitController` hoàn toàn không bị ảnh hưởng do chúng giao tiếp qua các phương thức trừu tượng của Service. Thiết kế đã đạt được tính độc lập dữ liệu rất cao.

