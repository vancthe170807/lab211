# 📄 Coding Convention & Quy định

## I. Format code

* `{` nằm ở cuối dòng, `}` nằm ở đầu dòng
* Dù block chỉ có 1 dòng cũng cần đặt trong `{}`
* 1 line (không bao gồm comment) không quá **100 ký tự**

➡️ Nếu line > 100 ký tự thì break tại:

* Sau toán tử logic (`and`, `or`, …)
* Hạn chế break giữa biểu thức trong `()`
* Trước toán hạng (`+`, `-`, …)

---

## II. Quy tắc viết code

### 1. Biến & khai báo

* Mỗi khai báo biến trên 1 dòng
* Khai báo array theo kiểu: `type[] arr`
* Biến được khai báo tập trung ở đầu mỗi block code
* Mỗi statement nằm trên 1 dòng

---

### 2. Khoảng trắng (spacing)

* Có 1 blank line:

  * Giữa các method
  * Giữa vùng khai báo biến và code
  * Trước block comment / line comment
  * Giữa các block logic

* Có 1 space ở:

  * Trước `(`
  * Sau `,`
  * Trước và sau toán tử (`=`, `+`, `-`, …)

---

### 3. Quy ước đặt tên biến

* Collection → kết thúc bằng `"List"`
* Set → `"Set"`
* Map → `"Map"`
* Array → `"Array"`

---

### 4. Constants

* Tất cả hằng số → đặt trong class riêng (`Constants.java`)
* Viết hoa + phân cách bằng `_`

  * Ví dụ: `MAX_SIZE`, `DEFAULT_VALUE`

---

## III. Naming Convention

### 1. Package

* Viết thường, thể hiện ý nghĩa chung

### 2. Class

* Bắt đầu bằng chữ hoa
* Tên là danh từ mô tả ý nghĩa
* Mỗi class chỉ thực hiện **1 nhiệm vụ**
* Exception class → kết thúc bằng `"Exception"`
* Interface → bắt đầu bằng `"I"`

---

### 3. Method

* Bắt đầu bằng chữ thường
* Tên là động từ mô tả chức năng
* Mỗi method chỉ thực hiện **1 nhiệm vụ**

---

## IV. Comment

* Viết ngắn gọn, rõ ràng
* Dùng **Javadoc** khi cần

Ví dụ:

```java
/** This method gets user by ID */
```

### Bắt buộc:

* Mỗi method phải có comment mô tả
* Mỗi block code phải có comment giải thích

---

## V. Kiến trúc (Model - View - Controller)

### 1. Model

* Không chứa I/O, không làm việc với View
* Entity (vd: `Student`) → chỉ chứa dữ liệu
* Service (vd: `StudentService`) → xử lý logic (CRUD, tìm kiếm)
* Validate dữ liệu hệ thống (vd: check trùng ID)

---

### 2. View

* Không chứa business logic
* Input từ người dùng phải được validate trước khi gửi Controller
* Các hàm nhập nên viết tổng quát để tái sử dụng

---

### 3. Controller

* Không trực tiếp xử lý logic
* Không xử lý thuật toán
* Là nơi duy nhất chứa `switch-case` điều hướng menu

---

## VI. Other Rules

* Không khai báo biến local trùng tên với biến global
* So sánh object (vd: String) → dùng `.equals()` không dùng `==`
* Không khai báo biến mà không sử dụng
* Tất cả input phải được validate đầy đủ
* Khi nối String → dùng `StringBuilder`, không dùng `String + String`

---
Luật đưa ra bởi giáo viên LinhNDM3 (Nguyễn Đình Mạnh Linh)