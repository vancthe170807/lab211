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
* **`List` / `Set` / `Map`**: Các cấu trúc dữ liệu thuộc **Java Collections Framework** dùng để lưu trữ và quản lý tập hợp đối tượng. Xem chi tiết đầy đủ ở **Mục 15**.

---

## 📚 15. Java Collections Framework (Khung chứa dữ liệu)

Java Collections Framework (JCF) cung cấp một kiến trúc thống nhất để lưu trữ, quản lý và thao tác trên một tập hợp các đối tượng.

### 📌 15.1 Sơ đồ phân cấp tổng quan (Hierarchy)

```
       ┌───────────────── Interface Collection ─────────────────┐
       │                                                        │
┌──────┴──────┐          ┌──────────────┴──────────────┐  ┌─────┴──────┐
│  Interface  │          │          Interface          │  │ Interface  │
│    List     │          │             Set             │  │   Queue    │
└──────┬──────┘          └──────────────┬──────────────┘  └────────────┘
       ├─ ArrayList                     ├─ HashSet
       └─ LinkedList                    ├─ LinkedHashSet
                                        └─ TreeSet (SortedSet)

┌──────────────────────────────────────────────────────────────┐
│                      Interface Map                           │
└──────────────────────────────┬───────────────────────────────┘
                               ├─ HashMap
                               ├─ LinkedHashMap
                               └─ TreeMap (SortedMap)
```
*(Lưu ý: `Map` không kế thừa từ `Collection` interface nhưng vẫn là một phần quan trọng của Collections Framework).*

---

### 📂 15.2 List Interface (Danh sách có thứ tự)

**Đặc điểm**: Duy trì thứ tự phần tử lúc chèn vào (insertion order), cho phép phần tử trùng lặp (duplicate) và cho phép truy cập ngẫu nhiên qua chỉ số (index - 0-indexed).

#### 1. ArrayList
* **Khái niệm**: Sử dụng một **mảng động (dynamic array)** làm cấu trúc dữ liệu bên dưới. Khi mảng đầy, Java tự động tạo mảng mới lớn hơn (thường gấp 1.5 lần) và sao chép các phần tử cũ sang.
* **Thời gian thực thi (Time Complexity)**:
  * Lấy phần tử (`get(index)`): $O(1)$ - cực nhanh.
  * Thêm/Xóa ở cuối (`add(e)`, `remove(last)`): $O(1)$ (hoặc $O(n)$ khi mảng phải resize nhưng trung bình vẫn là $O(1)$).
  * Thêm/Xóa ở đầu/giữa (`add(index, e)`, `remove(index)`): $O(n)$ do phải dịch chuyển toàn bộ các phần tử đứng sau.
* **Khi nào nên dùng**:
  * Cần truy xuất (đọc) phần tử thường xuyên dựa trên chỉ số (index).
  * Kích thước dữ liệu ít thay đổi hoặc chỉ thêm ở cuối danh sách (ví dụ: hiển thị danh sách sản phẩm, danh sách sinh viên chỉ để đọc và tìm kiếm).
* **Khi nào không nên dùng**:
  * Cần thêm hoặc xóa các phần tử liên tục ở đầu hoặc giữa danh sách (làm giảm hiệu năng hệ thống đáng kể).

#### 2. LinkedList
* **Khái niệm**: Sử dụng cấu trúc **danh sách liên kết đôi (Doubly Linked List)**. Mỗi phần tử (Node) chứa dữ liệu và hai con trỏ trỏ đến Node đứng trước (`prev`) và Node đứng sau (`next`).
* **Thời gian thực thi (Time Complexity)**:
  * Lấy phần tử (`get(index)`): $O(n)$ - phải duyệt từ đầu hoặc cuối đến phần tử cần tìm.
  * Thêm/Xóa ở đầu/cuối (`addFirst()`, `removeFirst()`, `addLast()`, `removeLast()`): $O(1)$ - cực nhanh.
  * Thêm/Xóa ở giữa: $O(n)$ nếu cần tìm vị trí chèn, nhưng nếu đã có con trỏ trỏ tới vị trí đó thì chỉ mất $O(1)$ để thay đổi các liên kết.
* **Khi nào nên dùng**:
  * Thường xuyên chèn/xóa phần tử ở đầu/cuối danh sách.
  * Thích hợp làm các cấu trúc dữ liệu kiểu **Hàng đợi (Queue)**, **Ngăn xếp (Stack)** hoặc **Deque (Double-Ended Queue)**.
* **Khi nào không nên dùng**:
  * Cần truy cập phần tử ngẫu nhiên liên tục theo index (phải duyệt tuần tự rất tốn thời gian).
  * Ứng dụng hạn chế về bộ nhớ (vì mỗi Node trong LinkedList tiêu tốn thêm bộ nhớ để lưu trữ con trỏ `prev` và `next`).

#### Bảng so sánh ArrayList vs LinkedList

| Đặc điểm | ArrayList | LinkedList |
| :--- | :--- | :--- |
| **Cấu trúc bên dưới** | Mảng động (Dynamic Array) | Danh sách liên kết đôi (Doubly Linked List) |
| **Vùng nhớ** | Liên tục (Contiguous memory) | Phân tán trên Heap (Non-contiguous memory) |
| **Truy cập ngẫu nhiên (`get(index)`)** | **$O(1)$** (Rất nhanh) | **$O(n)$** (Phải duyệt tuần tự) |
| **Thêm/Xóa ở đầu/giữa** | **$O(n)$** (Phải dịch chuyển phần tử) | **$O(1)$** (Nếu đã đứng tại vị trí cần chèn) |
| **Thêm/Xóa ở cuối** | **$O(1)$** (Amortized) | **$O(1)$** |
| **Chi phí bộ nhớ** | Thấp (Chỉ lưu trữ phần tử thực tế) | Cao (Tốn thêm bộ nhớ lưu liên kết `next`/`prev`) |

---

### 📂 15.3 Set Interface (Tập hợp không trùng lặp)

**Đặc điểm**: Không cho phép lưu trữ các phần tử trùng lặp (nếu thêm phần tử đã tồn tại, phương thức `add()` sẽ trả về `false` và không ghi đè). Thường dùng để loại bỏ trùng lặp hoặc kiểm tra nhanh sự tồn tại của phần tử.

#### 1. HashSet
* **Khái niệm**: Sử dụng cơ chế bảng băm (**HashTable**) dưới dạng ngầm định của `HashMap`.
* **Đặc tính**: Không duy trì bất kỳ thứ tự nào của các phần tử khi duyệt. Cho phép lưu giá trị `null` (tối đa 1 phần tử).
* **Hiệu năng**: Thêm (`add`), xóa (`remove`), tìm kiếm (`contains`): $O(1)$ trung bình.
* **Khi nào nên dùng**: Chỉ cần lọc trùng lặp và kiểm tra sự tồn tại của phần tử nhanh nhất có thể mà không quan tâm đến thứ tự.
* **Khi nào không nên dùng**: Cần duy trì thứ tự chèn hoặc sắp xếp các phần tử.

#### 2. LinkedHashSet
* **Khái niệm**: Kế thừa từ `HashSet` nhưng bổ sung một **LinkedList** chạy qua các phần tử để liên kết chúng lại.
* **Đặc tính**: **Duy trì thứ tự chèn (insertion order)**. Phần tử nào thêm trước sẽ xuất hiện trước khi duyệt.
* **Hiệu năng**: Thêm, xóa, tìm kiếm: $O(1)$. Hiệu năng hơi kém hơn `HashSet` một chút do phải tốn chi phí cập nhật các liên kết.
* **Khi nào nên dùng**: Cần lọc trùng lặp dữ liệu nhưng vẫn muốn giữ nguyên thứ tự xuất hiện ban đầu của phần tử.

#### 3. TreeSet
* **Khái niệm**: Sử dụng cấu trúc **Cây đỏ-đen (Red-Black Tree)** để lưu trữ phần tử.
* **Đặc tính**: **Tự động sắp xếp các phần tử** theo thứ tự tự nhiên (tăng dần) hoặc theo một `Comparator` tự định nghĩa. Không cho phép chứa giá trị `null` (sẽ ném ra `NullPointerException`).
* **Hiệu năng**: Thêm, xóa, tìm kiếm: $O(\log n)$ do phải tái cân bằng cây khi thay đổi dữ liệu.
* **Khi nào nên dùng**: Cần lưu trữ các phần tử không trùng lặp và yêu cầu danh sách luôn được sắp xếp theo thứ tự (ví dụ: lấy ra các số điểm từ thấp đến cao không trùng lặp).

#### Bảng so sánh các triển khai của Set

| Đặc điểm | HashSet | LinkedHashSet | TreeSet |
| :--- | :--- | :--- | :--- |
| **Cấu trúc dữ liệu** | HashTable | HashTable + LinkedList | Cây đỏ-đen (Red-Black Tree) |
| **Thứ tự phần tử** | Không xác định (Unordered) | Thứ tự chèn (Insertion order) | Được sắp xếp (Sorted order) |
| **Tốc độ (`add/remove/contains`)** | **$O(1)$** (Nhanh nhất) | **$O(1)$** (Hơi chậm hơn HashSet) | **$O(\log n)$** (Chậm nhất) |
| **Chấp nhận `null`** | ✅ Có (Tối đa 1 phần tử) | ✅ Có (Tối đa 1 phần tử) | ❌ Không (Ném Exception) |

---

### 📂 15.4 Map Interface (Tập hợp Khóa - Giá trị)

**Đặc điểm**: Quản lý dữ liệu dưới dạng các cặp **Khóa - Giá trị (Key - Value)**. Mỗi Key là duy nhất (không được trùng lặp), còn Value có thể trùng lặp. Nếu thêm một Key đã tồn tại với Value mới, Value cũ sẽ bị ghi đè.

#### 1. HashMap
* **Khái niệm**: Sử dụng **bảng băm (HashTable)** để lưu trữ cặp Key-Value.
* **Đặc tính**: Không duy trì thứ tự của các Key. Cho phép **1 key null** và nhiều value null.
* **Hiệu năng**: Thêm (`put`), tìm (`get`), xóa (`remove`): $O(1)$ trung bình.
* **Khi nào nên dùng**: Cần quản lý dữ liệu dạng từ điển (tra cứu thông tin theo mã/id định danh) với hiệu năng tối ưu và không quan tâm đến thứ tự của dữ liệu.
* **Khi nào không nên dùng**: Cần sắp xếp hoặc lưu giữ thứ tự chèn của các Key.

#### 2. LinkedHashMap
* **Khái niệm**: Kế thừa `HashMap` kết hợp thêm cấu trúc **LinkedList** liên kết giữa các Node.
* **Đặc tính**: **Duy trì thứ tự chèn (insertion order)** của các Key, hoặc thứ tự truy cập gần nhất (dùng để làm bộ nhớ đệm Cache LRU).
* **Hiệu năng**: Thêm, tìm, xóa: $O(1)$. Tốn nhiều bộ nhớ hơn HashMap để lưu liên kết.
* **Khi nào nên dùng**: Cần tra cứu nhanh theo khóa và bắt buộc dữ liệu phải hiển thị đúng theo thứ tự chèn vào.

#### 3. TreeMap
* **Khái niệm**: Sử dụng cấu trúc **Cây đỏ-đen (Red-Black Tree)** để lưu trữ các cặp Key-Value.
* **Đặc tính**: **Tự động sắp xếp các Key** theo thứ tự tự nhiên hoặc theo `Comparator` tự định nghĩa. **Không cho phép key null** (gây lỗi `NullPointerException`), nhưng cho phép nhiều value null.
* **Hiệu năng**: Thêm, tìm, xóa: $O(\log n)$.
* **Khi nào nên dùng**: Cần dữ liệu Key-Value luôn được sắp xếp theo Key (ví dụ: in ra bảng thống kê doanh số sắp xếp theo mã sản phẩm tăng dần).

#### Bảng so sánh các triển khai của Map

| Đặc điểm | HashMap | LinkedHashMap | TreeMap |
| :--- | :--- | :--- | :--- |
| **Cấu trúc dữ liệu** | HashTable | HashTable + LinkedList | Cây đỏ-đen (Red-Black Tree) |
| **Thứ tự của Key** | Không xác định | Thứ tự chèn (Insertion order) | Sắp xếp tăng dần theo Key |
| **Tốc độ (`put/get/remove`)** | **$O(1)$** (Nhanh nhất) | **$O(1)$** (Hơi chậm hơn HashMap) | **$O(\log n)$** (Chậm nhất) |
| **Chấp nhận Key `null`** | ✅ Có (Tối đa 1 key null) | ✅ Có (Tối đa 1 key null) | ❌ Không (Ném Exception) |

---

### 📊 15.5 Bảng so sánh tổng quan giữa List, Set và Map

| Tiêu chí | List | Set | Map |
| :--- | :--- | :--- | :--- |
| **Bản chất** | Danh sách phần tử tuyến tính. | Tập hợp phần tử độc nhất. | Tập hợp các cặp Khóa - Giá trị. |
| **Trùng lặp dữ liệu** | ✅ Cho phép. | ❌ Không cho phép. | Khóa: ❌ Không trùng.<br>Giá trị: ✅ Cho phép trùng. |
| **Truy cập phần tử** | Thông qua chỉ số index: `list.get(i)`. | Phải duyệt qua `Iterator` hoặc `for-each` (không lấy qua index). | Thông qua khóa (Key): `map.get(key)`. |
| **Phương thức cơ bản** | `add(e)`, `get(index)`, `remove(index)` | `add(e)`, `contains(e)`, `remove(e)` | `put(k, v)`, `get(k)`, `remove(k)` |
| **Khi nào nên dùng** | Khi cần lưu trữ danh sách theo thứ tự cụ thể, cho phép trùng lặp, cần thao tác qua index. | Khi cần lưu danh sách không trùng lặp và kiểm tra nhanh một phần tử có tồn tại hay không. | Khi dữ liệu có cặp liên kết khóa-giá trị rõ ràng, cần tìm kiếm thông tin cực nhanh bằng khóa. |

---

## ⚙️ 16. OOP Best Practices

- Dùng **Encapsulation** để bảo vệ dữ liệu

- Dùng **Inheritance** hợp lý, không lạm dụng

- Áp dụng **Interface/Abstract Class** để tách biệt logic
- **Đặt tên class và method rõ ràng**
- Viết code **hướng đối tượng, không hướng thủ tục**

---

## 🎓 17. Tổng kết sơ đồ tư duy OOP Java

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
├── Java Collections Framework (List, Set, Map...)
└── Interface & Abstract Class
```

---

Nếu bạn muốn, mình có thể **tạo cho bạn 1 file PDF tóm tắt “Từ A–Z OOP Java cho người mới”** có kèm **sơ đồ, ví dụ code, và bảng so sánh** để dễ ôn luyện.
👉 Bạn có muốn mình tạo luôn không?
