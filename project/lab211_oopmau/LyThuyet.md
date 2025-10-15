**OOP (Lập trình hướng đối tượng) trong Java**

OOP là mô hình lập trình tổ chức mã nguồn bằng các đối tượng và lớp, hỗ trợ đóng gói, kế thừa, đa hình và trừu tượng.

**Ví dụ OOP bằng Java:**
```java
public class Animal {
    public void speak() {
        System.out.println("Animal speaks");
    }
}

public class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.speak(); // Kết quả: Dog barks
    }
}
```

---

**POP (Lập trình hướng thủ tục) trong Java**

Dù Java là ngôn ngữ hướng đối tượng, ta vẫn có thể viết theo kiểu thủ tục bằng cách sử dụng các phương thức tĩnh.

**Ví dụ POP bằng Java:**
```java
public class Main {
    public static void speak() {
        System.out.println("Animal speaks");
    }

    public static void main(String[] args) {
        speak();
    }
}
```

---

**Bảng so sánh OOP và POP trong Java:**

| OOP (Hướng đối tượng)                  | POP (Hướng thủ tục)                  |
|----------------------------------------|--------------------------------------|
| Tổ chức mã bằng lớp/đối tượng          | Tổ chức mã bằng phương thức tĩnh     |
| Hỗ trợ đóng gói, kế thừa, đa hình      | Không hỗ trợ các tính năng OOP       |
| Dễ quản lý hệ thống lớn, phức tạp      | Phù hợp chương trình nhỏ, đơn giản   |
| Dữ liệu và phương thức gắn kết trong đối tượng | Dữ liệu và phương thức tách biệt    |

---

## Khái niệm và từ khóa quan trọng trong OOP của Java (kèm ví dụ)

---

**public**  
Truy cập được từ bất kỳ lớp nào.

```java
public class CongKhai {
    public int x = 10;
    public void hienThi() {
        System.out.println("Đây là phương thức public");
    }
}
```

---

**private**  
Chỉ truy cập được trong chính lớp khai báo.

```java
public class RiengTu {
    private int soBiMat = 123;
    private void hienThi() {
        System.out.println("Đây là phương thức private");
    }
}
```

---

**protected**  
Truy cập được trong cùng package và các lớp con.

```java
public class BaoVe {
    protected String ten = "BaoVe";
    protected void hienThi() {
        System.out.println("Đây là phương thức protected");
    }
}
```

---

**default (không ghi gì)**  
Chỉ truy cập được trong cùng package.

```java
class MacDinh {
    int giaTri = 5;
    void hienThi() {
        System.out.println("Đây là phương thức default");
    }
}
```

---

**static**  
Thuộc về lớp, không thuộc về đối tượng.

```java
public class TinhChatStatic {
    public static int dem = 0;
    public static void hienThi() {
        System.out.println("Đây là phương thức static");
    }
}
```

---

**final**  
Không thể thay đổi sau khi gán.

```java
public class HangSo {
    public final int SO_PI = 3;
    public final void hienThi() {
        System.out.println("Phương thức này không thể override");
    }
}
```

---

**abstract**  
Dùng cho lớp không thể khởi tạo và phương thức phải được lớp con cài đặt.

```java
public abstract class DongVat {
    public abstract void keu();
}

public class Meo extends DongVat {
    @Override
    public void keu() {
        System.out.println("Meo kêu meo meo");
    }
}
```

---

**interface**  
Định nghĩa hành vi mà lớp phải thực hiện.

```java
public interface BayDuoc {
    void bay();
}

public class Chim implements BayDuoc {
    @Override
    public void bay() {
        System.out.println("Chim bay trên trời");
    }
}
```

---

**extends**  
Chỉ ra lớp kế thừa từ lớp cha.

```java
public class Cha {
    public void xinChao() {
        System.out.println("Xin chào từ Cha");
    }
}

public class Con extends Cha {
    // Kế thừa phương thức xinChao()
}
```

---

**implements**  
Chỉ ra lớp thực hiện một interface.

```java
public interface AnDuoc {
    void an();
}

public class Nguoi implements AnDuoc {
    @Override
    public void an() {
        System.out.println("Người đang ăn");
    }
}
```

---

**this**  
Tham chiếu đến đối tượng hiện tại.

```java
public class SuDungThis {
    int x;
    public SuDungThis(int x) {
        this.x = x;
    }
}
```

---

**super**  
Tham chiếu đến lớp cha của đối tượng hiện tại.

```java
public class Cha {
    public void xinChao() {
        System.out.println("Xin chào từ Cha");
    }
}

public class Con extends Cha {
    public void xinChaoCon() {
        super.xinChao();
        System.out.println("Xin chào từ Con");
    }
}
```

---

**constructor**  
Phương thức đặc biệt dùng để khởi tạo đối tượng.

```java
public class NhanVien {
    String ten;
    public NhanVien(String ten) {
        this.ten = ten;
    }
}
```

---

**instance variable**  
Biến khai báo trong lớp, mỗi đối tượng có một bản sao riêng.

```java
public class ViDuBien {
    int tuoi; // instance variable
}
```

---

**method overloading**  
Định nghĩa nhiều phương thức cùng tên nhưng khác tham số.

```java
public class NapChong {
    public void hienThi() {
        System.out.println("Không có tham số");
    }
    public void hienThi(String ten) {
        System.out.println("Tên: " + ten);
    }
}
```

---

**method overriding**  
Ghi đè phương thức của lớp cha trong lớp con.

```java
public class DongVat {
    public void keu() {
        System.out.println("Động vật kêu");
    }
}

public class Cho extends DongVat {
    @Override
    public void keu() {
        System.out.println("Chó sủa gâu gâu");
    }
}
```

---

Đây là các khái niệm và ví dụ về từ khóa OOP phổ biến trong Java.