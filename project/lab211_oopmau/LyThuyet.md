## 🧩 1. Khái niệm OOP (Object-Oriented Programming)

**OOP** (Object-Oriented Programming) là **lập trình hướng đối tượng**, một mô hình lập trình dựa trên **đối tượng (object)**.
Mục tiêu: mô phỏng thế giới thực vào chương trình bằng các **đối tượng có thuộc tính (property)** và **hành vi (behavior)**.

### 💡 Ví dụ:

* Đối tượng: `Xe`
* Thuộc tính (Attributes): màu, tốc độ, hãng sản xuất
* Hành vi (Methods): chạy(), dừng()

---

## 🧱 2. Class (Lớp)

**Class** là **khuôn mẫu (blueprint)** để tạo ra **đối tượng (object)**.
Nó định nghĩa **các thuộc tính (variables)** và **hành vi (methods)** của đối tượng.

### 🔍 Cú pháp:

```java
public class Car {
    private String color;
    private int speed;

    public void run() {
        System.out.println("Xe đang chạy ở tốc độ " + speed + " km/h");
    }
}
```

---

## 🚗 3. Object (Đối tượng)

**Object** là **thể hiện cụ thể** của một lớp (instance of a class).
Bạn có thể tạo nhiều object từ cùng một class.

### 🔍 Ví dụ:

```java
public class Main {
    public static void main(String[] args) {
        Car car1 = new Car();   // tạo đối tượng
        car1.color = "Đỏ";
        car1.speed = 100;
        car1.run();
    }
}
```

---

## 🧰 4. Constructor (Hàm khởi tạo)

**Constructor** là một **phương thức đặc biệt** được gọi khi tạo đối tượng (`new`).
Nó thường dùng để **khởi tạo giá trị ban đầu** cho các thuộc tính.

### 🔍 Ví dụ:

```java
public class Car {
    String color;
    int speed;

    // Constructor
    public Car(String color, int speed) {
        this.color = color;
        this.speed = speed;
    }

    void run() {
        System.out.println(color + " chạy ở tốc độ " + speed);
    }
}
```

---

## 🎯 5. Four Pillars of OOP (4 trụ cột OOP)

### 🧱 (1) Encapsulation — **Đóng gói**

Ẩn thông tin bên trong đối tượng và chỉ cho phép truy cập qua các **getter/setter**.

```java
public class Account {
    private double balance; // ẩn thông tin

    public void setBalance(double balance) {
        if (balance > 0) this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
```

---

### 🧬 (2) Inheritance — **Kế thừa**

Một lớp có thể **kế thừa thuộc tính & phương thức** từ lớp khác.
Giúp tái sử dụng code và mở rộng chức năng.

```java
class Animal {
    void eat() { System.out.println("Đang ăn"); }
}

class Dog extends Animal {
    void bark() { System.out.println("Gâu gâu"); }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();   // kế thừa từ Animal
        dog.bark();  // của riêng Dog
    }
}
```

---

### 🧠 (3) Polymorphism — **Đa hình**

Một hành động có thể **thực hiện theo nhiều cách khác nhau**.
Gồm 2 loại:

* **Compile-time polymorphism (Overloading)**
* **Runtime polymorphism (Overriding)**

#### 👉 Overloading (nạp chồng phương thức)

Cùng tên method, khác tham số.

```java
class MathUtil {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}
```

#### 👉 Overriding (ghi đè phương thức)

Lớp con định nghĩa lại phương thức của lớp cha.

```java
class Animal {
    void sound() { System.out.println("Animal sound"); }
}
class Dog extends Animal {
    @Override
    void sound() { System.out.println("Gâu gâu"); }
}
```

---

### 🧩 (4) Abstraction — **Trừu tượng hóa**

Ẩn chi tiết bên trong, chỉ hiển thị phần cần thiết.
Thực hiện bằng **abstract class** hoặc **interface**.

#### 👉 Abstract class

```java
abstract class Animal {
    abstract void sound();
}

class Dog extends Animal {
    void sound() { System.out.println("Gâu gâu"); }
}
```

#### 👉 Interface

```java
interface Vehicle {
    void run();
}

class Car implements Vehicle {
    public void run() {
        System.out.println("Xe đang chạy");
    }
}
```

---

## 🧮 6. `this` và `super`

* `this`: tham chiếu đến **đối tượng hiện tại**
* `super`: tham chiếu đến **lớp cha**

```java
class Animal {
    String name = "Animal";
}

class Dog extends Animal {
    String name = "Dog";

    void printNames() {
        System.out.println(this.name);  // Dog
        System.out.println(super.name); // Animal
    }
}
```

---

## 🏗️ 7. Static vs Instance (Non-static) Members

Từ khóa `static` dùng để quản lý bộ nhớ và định nghĩa các thành viên thuộc về cấp độ **Lớp (Class)** thay vì cấp độ **Đối tượng (Instance)**.

### 📌 Phân biệt Static và Instance (Non-static)
| Đặc điểm | Static Members | Instance Members (Non-static) |
| :--- | :--- | :--- |
| **Bản chất** | Thuộc về **Lớp (Class)**, dùng chung bởi tất cả đối tượng. | Thuộc về từng **Đối tượng (Instance)** cụ thể. |
| **Cấp phát bộ nhớ** | Load một lần duy nhất vào vùng nhớ **Metaspace** khi class được load. | Cấp phát mới trên vùng nhớ **Heap** mỗi khi gọi `new`. |
| **Cách truy cập** | Gọi trực tiếp qua tên Lớp: `ClassName.member`. | Gọi qua đối tượng cụ thể: `objectName.member`. |
| **Mối quan hệ** | **Không thể** truy cập trực tiếp các Instance variables/methods. | **Có thể** truy cập cả Static lẫn Instance members. |

### ⚠️ Lưu ý chí mạng trong OOP: Không lạm dụng `public static` cho hàm (trừ `main`)
Trong lập trình hướng đối tượng, **tránh việc khai báo các hàm nghiệp vụ là `public static`** (ngoại trừ phương thức khởi chạy `main` và các hàm tiện ích thuần túy không trạng thái như `Math.sin`).
* **Lý do**: 
  1. **Phá vỡ tính đa hình (Polymorphism)**: Phương thức `static` liên kết tĩnh (static binding) lúc compile-time nên **không thể bị ghi đè (override)** bởi lớp con.
  2. **Vi phạm Đóng gói (Encapsulation)**: Hàm `static` không liên kết với trạng thái của đối tượng cụ thể nào, biến chương trình hướng đối tượng thành lập trình hướng thủ tục (Procedural Programming) với các hàm toàn cục.
  3. **Khó kiểm thử (Unit Testing)**: Các hàm static rất khó viết mã Mock khi thực hiện kiểm thử.

---

## 🧩 8. Inner Class (Lớp bên trong)

Lớp được định nghĩa **bên trong một lớp khác**.

```java
class Outer {
    class Inner {
        void show() {
            System.out.println("Bên trong lớp Inner");
        }
    }
}
```

---

## 🔁 9. Method Overriding vs Overloading – So sánh nhanh

| Tính năng         | Overloading  | Overriding           |
| ----------------- | ------------ | -------------------- |
| Thời điểm         | Compile-time | Runtime              |
| Cùng tên method   | ✅            | ✅                    |
| Tham số khác nhau | ✅            | ❌                    |
| Lớp               | Cùng lớp     | Khác lớp (cha – con) |

---

## 🧱 10. Access Modifiers (Phạm vi truy cập)

Access Modifiers định nghĩa khả năng hiển thị và mức độ bảo mật dữ liệu của các lớp, thuộc tính, và phương thức trong ứng dụng.

### 📌 Bảng so sánh chi tiết phạm vi truy cập
| Modifier | Trong cùng Lớp (Class) | Cùng Package | Lớp con (Subclass) khác Package | Khác Package (Mọi nơi) |
| :--- | :---: | :---: | :---: | :---: |
| `private` | ✅ | ❌ | ❌ | ❌ |
| `default` (không ghi gì) | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

* **`private`**: Mức độ bảo mật cao nhất. Thường áp dụng cho tất cả các thuộc tính của lớp để bảo vệ trạng thái nội bộ.
* **`default`**: Cho phép truy cập nội bộ trong cùng một thư mục/package.
* **`protected`**: Dành cho mối quan hệ kế thừa. Lớp con ở package khác vẫn có quyền truy cập.
* **`public`**: Mức độ công khai cao nhất, truy cập ở bất kỳ đâu trong dự án.

---

## 💡 11. Final vs Non-Final Keyword

Từ khóa `final` trong Java biểu diễn tính chất **bất biến (không thể thay đổi)** của phần tử được áp dụng.

### 📌 Phân biệt Final và Non-Final (Bình thường)
* **Đối với Biến (Variables)**:
  * `final variable`: Trở thành hằng số (Constant), chỉ được gán giá trị một lần duy nhất và không thể thay đổi trong suốt runtime.
  * `non-final variable`: Biến bình thường, giá trị có thể thay đổi liên tục bằng phép gán.
* **Đối với Phương thức (Methods)**:
  * `final method`: Ngăn chặn hoàn toàn việc lớp con ghi đè (`@Override`) phương thức đó.
  * `non-final method`: Lớp con có thể tự do override để thay đổi hành vi nghiệp vụ.
* **Đối với Lớp (Classes)**:
  * `final class`: Lớp bị đóng băng, không cho phép bất kỳ lớp nào khác kế thừa (`extends`) từ nó.
  * `non-final class`: Lớp bình thường, có thể kế thừa và mở rộng tính năng.

---

## 🧠 12. Object Class

Mọi class trong Java đều **kế thừa ngầm từ `Object`**.
Một số phương thức hay dùng:

* `toString()`
* `equals()`
* `hashCode()`
* `clone()`

---

## 🧹 13. Garbage Collection (Thu gom rác)

Java tự động xóa đối tượng không còn được tham chiếu để **giải phóng bộ nhớ**.
Không cần `delete` như C++.

---

## 📦 14. Java Data Types (Các kiểu dữ liệu trong Java)

Java chia các kiểu dữ liệu thành hai nhóm chính: **Kiểu dữ liệu nguyên thủy (Primitive Types)** và **Kiểu dữ liệu tham chiếu (Reference Types)**. Việc chọn đúng kiểu dữ liệu giúp tối ưu bộ nhớ và tránh lỗi logic.

### 📌 14.1 Kiểu dữ liệu nguyên thủy (Primitive Types)
Lưu trực tiếp giá trị vào bộ nhớ Stack, hiệu năng cao.

* **`int` (Integer)**: Kiểu số nguyên 32-bit (Phạm vi khoảng $\pm 2$ tỷ).
  * *Khái niệm*: Kiểu dữ liệu biểu diễn số nguyên không có phần thập phân.
  * *Khi nào dùng*: Sử dụng cho các số đếm, số lượng phần tử, chỉ số vòng lặp, tuổi tác, hoặc mã ID dạng số thông thường.
* **`double`**: Kiểu số thực 64-bit (Độ chính xác kép).
  * *Khái niệm*: Kiểu dữ liệu số thực có phần thập phân.
  * *Khi nào dùng*: Điểm số học tập, chiều cao, cân nặng, tọa độ, tỷ lệ phần trăm.
  * *Lưu ý*: Tránh dùng `double` cho các phép tính tài chính/tiền tệ đòi hỏi độ chính xác tuyệt đối do sai số dấu phẩy động; thay vào đó hãy dùng `BigDecimal`.
* **`boolean`**: Kiểu logic chỉ nhận `true` (đúng) hoặc `false` (sai).
  * *Khái niệm*: Biểu diễn trạng thái nhị phân.
  * *Khi nào dùng*: Lưu trạng thái hệ thống (ví dụ: `isDeleted`, `isActive`), các cờ kiểm tra (flag), hoặc kết quả của biểu thức điều kiện.
* **`char`**: Kiểu ký tự đơn 16-bit.
  * *Khái niệm*: Lưu trữ một ký tự Unicode duy nhất.
  * *Khi nào dùng*: Lưu trữ các ký tự lựa chọn đơn (như `'Y'` hoặc `'N'`), phím tắt, hoặc ký hiệu viết tắt.
* *Các kiểu khác*:
  * **`long`**: Dùng khi số nguyên vượt quá phạm vi của `int` (như thời gian epoch miliseconds, ID cơ sở dữ liệu lớn).
  * **`float`**: Số thực đơn 32-bit, ít dùng hơn `double` trừ khi cần tiết kiệm bộ nhớ trong các mảng số thực cực lớn.

### 📌 14.2 Kiểu dữ liệu tham chiếu (Reference Types)
Lưu địa chỉ tham chiếu trỏ đến vùng nhớ Heap nơi đối tượng thực tế được tạo.

* **`String`**: Chuỗi ký tự (là đối tượng bất biến - Immutable).
  * *Khái niệm*: Đối tượng biểu diễn một chuỗi gồm nhiều ký tự.
  * *Khi nào dùng*: Tên người, địa chỉ, email, đoạn văn bản, hoặc các ID có chứa chữ cái.
* **`enum` (Enumeration)**: Kiểu dữ liệu đại diện cho một tập hợp các hằng số cố định.
  * *Khái niệm*: Một class đặc biệt định nghĩa một danh sách các lựa chọn được định danh trước.
  * *Khi nào dùng*: Khi dữ liệu chỉ được phép nhận một trong số các giá trị cố định và biết trước (ví dụ: Giới tính `MALE`/`FEMALE`, Trạng thái học tập `ACTIVE`/`INACTIVE`, Các ngày trong tuần, Các hướng `NORTH`/`SOUTH`/`EAST`/`WEST`). Sử dụng `enum` thay vì String hoặc số nguyên giúp đảm bảo an toàn kiểu dữ liệu (Type Safety) lúc compile-time.
* **`List` / `ArrayList`**: Tập hợp dữ liệu tuyến tính động.
  * *Khái niệm*: Cấu trúc dữ liệu danh sách có kích thước co giãn động.
  * *Khi nào dùng*: Quản lý danh sách đối tượng (như danh sách học sinh, danh sách đơn hàng) khi chưa biết trước số lượng phần tử tối đa hoặc cần thêm/xóa phần tử thường xuyên.

---

## ⚙️ 15. OOP Best Practices

- Dùng **Encapsulation** để bảo vệ dữ liệu

- Dùng **Inheritance** hợp lý, không lạm dụng

- Áp dụng **Interface/Abstract Class** để tách biệt logic
- **Đặt tên class và method rõ ràng**
- Viết code **hướng đối tượng, không hướng thủ tục**

---

## 🎓 16. Tổng kết sơ đồ tư duy OOP Java

```
OOP Java
│
├── Class / Object
│
├── 4 Pillars
│   ├── Encapsulation
│   ├── Inheritance
│   ├── Polymorphism
│   └── Abstraction
│
├── Constructor / this / super
├── Access Modifiers
├── Static / Final
├── Data Types (int, double, String, enum...)
└── Interface & Abstract Class
```

---

Nếu bạn muốn, mình có thể **tạo cho bạn 1 file PDF tóm tắt “Từ A–Z OOP Java cho người mới”** có kèm **sơ đồ, ví dụ code, và bảng so sánh** để dễ ôn luyện.
👉 Bạn có muốn mình tạo luôn không?
