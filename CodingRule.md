# LAB211 - Coding Convention & Guidelines

## 1. Formatting & Structure

### 1.1. General Rules
- `{` nằm cuối line, `}` nằm đầu line
- Dù block chỉ có 1 dòng vẫn phải dùng `{ }`
- 1 line (không bao gồm comment) ≤ 100 ký tự
- Nếu > 100 ký tự thì break tại:
  - Sau toán tử logic (`and`, `or`, ...)
  - Trước toán hạng (`+`, `-`, ...)
  - Hạn chế break trong `()`

### 1.2. Variables & Statements
- Mỗi khai báo biến trên 1 dòng
- Mỗi statement trên 1 dòng
- Biến được khai báo tập trung ở đầu block

### 1.3. Array & Collection
- Array khai báo theo kiểu: `type[] arrayName`
- Naming convention:
  - List → kết thúc bằng `List`
  - Set → kết thúc bằng `Set`
  - Map → kết thúc bằng `Map`
  - Array → kết thúc bằng `Array`

### 1.4. Spacing
- Có 1 khoảng trắng:
  - Trước `(`
  - Sau `,`
  - Trước và sau toán tử (`=`, `+`, `-`, ...)

### 1.5. Blank Line
- Có 1 dòng trống:
  - Giữa các method
  - Giữa vùng khai báo biến và phần còn lại
  - Trước block comment / line comment
  - Giữa các block xử lý logic

---

## 2. Naming Convention

### 2.1. Package
- Viết thường
- Mang ý nghĩa tổng quát

### 2.2. Class
- Bắt đầu bằng chữ hoa
- Là danh từ mô tả chức năng
- Mỗi class chỉ làm 1 nhiệm vụ
- Exception class → kết thúc bằng `Exception`

### 2.3. Interface
- Bắt đầu bằng `I`

### 2.4. Method
- Bắt đầu bằng chữ thường
- Là động từ mô tả chức năng
- Mỗi method chỉ làm 1 nhiệm vụ

---

## 3. Constants
- Tất cả hằng số đặt trong class riêng (`Constants.java`)
- Viết IN HOA
- Phân cách bằng `_`

---

## 4. Commenting

### 4.1. Nguyên tắc
- Ngắn gọn, rõ ràng
- Dùng Javadoc khi cần

### 4.2. Ví dụ
```java
/**
 * This method gets user by ID
 */
```

### 4.3. Bắt buộc

* Mỗi method phải có comment mô tả
* Mỗi block logic phải có comment giải thích

---

## 5. Architecture Rules

### 5.1. Model

* Không chứa I/O
* Không làm việc với View
* Chỉ chứa dữ liệu (Entity)
* Business logic nằm ở Service
* Validate dữ liệu hệ thống (vd: check trùng ID)

### 5.2. View

* Không chứa logic nghiệp vụ
* Validate input trước khi gửi Controller
* Method nhập nên viết reusable

### 5.3. Controller

* Không xử lý Scanner trực tiếp
* Không chứa thuật toán
* Là nơi duy nhất chứa `switch-case` điều hướng menu

---

## 6. Best Practices

* Không khai báo biến local trùng tên biến cấp cao hơn
* So sánh String dùng `.equals()` (không dùng ==)
* Không khai báo biến mà không sử dụng
* Tất cả input phải validate
* Nối chuỗi dùng `StringBuilder` (không dùng `+`)

---

## 7. Checklist trước khi nộp

* [ ] Code đúng format
* [ ] Naming đúng convention
* [ ] Không có biến dư
* [ ] Validate đầy đủ input
* [ ] Có comment đầy đủ
* [ ] Phân tầng đúng Model - View - Controller
* [ ] Không có business logic trong View
* [ ] Không có I/O trong Model
