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
    String color;
    int speed;

    void run() {
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

## 🏗️ 7. Static Members

`static` cho phép **chia sẻ biến hoặc phương thức** giữa tất cả các đối tượng của lớp.

```java
class Student {
    static String school = "ĐH CNTT";
    String name;

    Student(String name) { this.name = name; }

    void showInfo() {
        System.out.println(name + " học tại " + school);
    }
}
```

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

| Modifier                 | Phạm vi                   | Mô tả                        |
| ------------------------ | ------------------------- | ---------------------------- |
| `public`                 | Toàn bộ chương trình      | Có thể truy cập ở mọi nơi    |
| `protected`              | Cùng package hoặc lớp con | Hạn chế hơn `public`         |
| `default` (không ghi gì) | Cùng package              | Không truy cập ngoài package |
| `private`                | Chỉ trong cùng class      | Bảo mật cao nhất             |

---

## 💡 11. Final Keyword

* `final class` → không thể kế thừa
* `final method` → không thể override
* `final variable` → hằng số (không thể thay đổi giá trị)

```java
final class A {}
final int MAX = 100;
```

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

## ⚙️ 14. OOP Best Practices

✅ Dùng **Encapsulation** để bảo vệ dữ liệu
✅ Dùng **Inheritance** hợp lý, không lạm dụng
✅ Áp dụng **Interface/Abstract Class** để tách biệt logic
✅ **Đặt tên class và method rõ ràng**
✅ Viết code **hướng đối tượng, không hướng thủ tục**

---

## 🎓 15. Tổng kết sơ đồ tư duy OOP Java

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
└── Interface & Abstract Class
```

---

Nếu bạn muốn, mình có thể **tạo cho bạn 1 file PDF tóm tắt “Từ A–Z OOP Java cho người mới”** có kèm **sơ đồ, ví dụ code, và bảng so sánh** để dễ ôn luyện.
👉 Bạn có muốn mình tạo luôn không?
