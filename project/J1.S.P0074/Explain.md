# GIẢI THÍCH LUỒNG CHẠY CHƯƠNG TRÌNH TÍNH MA TRẬN

## 1. TỔNG QUAN KIẾN TRÚC

Chương trình gồm 3 class chính:
- **Main.java**: Điều khiển luồng chính của chương trình
- **Matrix.java**: Xử lý các phép tính ma trận (cộng, trừ, nhân)
- **Validation.java**: Kiểm tra và xác thực dữ liệu đầu vào

---

## 2. LUỒNG CHẠY CHI TIẾT

### **Bước 1: Khởi động chương trình (Main.java)**

```
main() được gọi
    ↓
Vào vòng lặp while(true) - chương trình chạy liên tục
```

### **Bước 2: Hiển thị Menu**

```java
displayMenuAndGetChoice() được gọi
    ↓
Hiển thị:
    ======= Calculator Program =======
    1. Addition Matrix
    2. Subtraction Matrix
    3. Multiplication Matrix
    4. Quit
    ↓
Gọi validation.checkIntegerLimit(1, 4, "Your choice: ")
```

**Chi tiết checkIntegerLimit():**
- In ra "Your choice: "
- Đọc input từ user bằng `sc.nextLine()`
- Thử parse thành Integer
- Kiểm tra xem có trong khoảng [1, 4] không
- **Nếu SAI**: In "Please enter an integer between 1 and 4." → lặp lại
- **Nếu ĐÚNG**: Return giá trị choice

### **Bước 3: Xử lý lựa chọn**

#### **TH1: User chọn 1, 2, hoặc 3**

```
choice = 1 → In "------- Addition Matrix -------"
choice = 2 → In "------- Subtraction Matrix -------"
choice = 3 → In "------- Multiplication Matrix -------"
    ↓
Gọi Matrix.inputMatrix(1) → Tạo ma trận 1
    ↓
Gọi Matrix.inputMatrix(2) → Tạo ma trận 2
```

### **Bước 4: Nhập Ma Trận (Matrix.inputMatrix())**

**Quy trình nhập Matrix 1:**

```
1. Nhập số hàng:
   validation.checkInteger("Enter Row matrix 1: ")
   → Ví dụ: User nhập 2
   
2. Nhập số cột:
   validation.checkInteger("Enter Column matrix 1: ")
   → Ví dụ: User nhập 3
   
3. Tạo mảng 2 chiều: int[][] matrix = new int[2][3]

4. Vòng lặp nhập từng phần tử:
   For i = 0 → 1 (2 hàng)
       For j = 0 → 2 (3 cột)
           validation.checkInteger("Enter Matrix1[1][1]: ")
           validation.checkInteger("Enter Matrix1[1][2]: ")
           validation.checkInteger("Enter Matrix1[1][3]: ")
           validation.checkInteger("Enter Matrix1[2][1]: ")
           validation.checkInteger("Enter Matrix1[2][2]: ")
           validation.checkInteger("Enter Matrix1[2][3]: ")

5. Return new Matrix(matrix)
```

**Chi tiết checkInteger():**
- In ra message (VD: "Enter Matrix1[2][1]: ")
- Đọc input từ user
- Thử parse thành Integer
- **Nếu input không phải số (VD: "a", "1b")**:
    - Bắt NumberFormatException
    - In "**Value of matrix is digit**" (Lưu ý: code hiện tại là "Valid of matrix is digit")
    - **Lặp lại yêu cầu nhập** cho cùng vị trí đó
- **Nếu hợp lệ**: Return số nguyên

**Ví dụ nhập sai:**
```
Enter Matrix1[2][1]: a
Value of matrix is digit
Enter Matrix1[2][1]: 1b
Value of matrix is digit
Enter Matrix1[2][1]: 2
```

### **Bước 5: Thực hiện phép tính**

Sau khi có 2 ma trận, chương trình vào `switch(choice)`:

#### **Case 1: Addition (Cộng ma trận)**
```java
mtrxResult = mtrx1.additionalMatrix(mtrx2)
    ↓
Gọi Matrix.add(this, other)
    ↓
Kiểm tra: rows1 == rows2 && cols1 == cols2
    ↓
Nếu SAI → throw IllegalArgumentException
Nếu ĐÚNG → Tính:
    resultMatrix[i][j] = mtrx1[i][j] + mtrx2[i][j]
```

**Ví dụ cộng:**
```
Matrix1:        Matrix2:        Result:
[2][3][2]       [1][32][3]      [3][35][5]
[1][2][2]   +   [2][21][23]  =  [3][23][25]

Tính toán:
[0][0]: 2 + 1 = 3
[0][1]: 3 + 32 = 35
[0][2]: 2 + 3 = 5
[1][0]: 1 + 2 = 3
[1][1]: 2 + 21 = 23
[1][2]: 2 + 23 = 25
```

#### **Case 2: Subtraction (Trừ ma trận)**
```java
mtrxResult = mtrx1.subtractMatrix(mtrx2)
    ↓
Gọi Matrix.sub(this, other)
    ↓
Kiểm tra: rows1 == rows2 && cols1 == cols2
    ↓
Nếu SAI → throw IllegalArgumentException
Nếu ĐÚNG → Tính:
    resultMatrix[i][j] = mtrx1[i][j] - mtrx2[i][j]
```

#### **Case 3: Multiplication (Nhân ma trận)**
```java
mtrxResult = mtrx1.multiplicationMatrix(mtrx2)
    ↓
Gọi Matrix.multi(this, other)
    ↓
Kiểm tra: cols1 == rows2
    ↓
Nếu SAI → throw IllegalArgumentException
Nếu ĐÚNG → Tính nhân ma trận (xem phần dưới)
```

---

## 3. GIẢI THÍCH CHI TIẾT PHÉP NHÂN MA TRẬN

### **Điều kiện nhân ma trận:**
- Matrix A có kích thước: **m × n** (m hàng, n cột)
- Matrix B có kích thước: **n × p** (n hàng, p cột)
- **Số cột của A PHẢI BẰNG số hàng của B**
- Kết quả có kích thước: **m × p**

### **Công thức nhân ma trận:**

```
C[i][j] = Σ(k=0 đến n-1) A[i][k] × B[k][j]
```

Nghĩa là: **Phần tử C[i][j] = Tổng tích của hàng i trong A với cột j trong B**

### **Ví dụ cụ thể:**

```
Matrix A (2×3):          Matrix B (3×2):
[1][2][3]                [7][8]
[4][5][6]                [9][10]
                         [11][12]

Kết quả C (2×2):
```

**Tính C[0][0]** (hàng 0 của A × cột 0 của B):
```
C[0][0] = A[0][0]×B[0][0] + A[0][1]×B[1][0] + A[0][2]×B[2][0]
        = 1×7 + 2×9 + 3×11
        = 7 + 18 + 33
        = 58
```

**Tính C[0][1]** (hàng 0 của A × cột 1 của B):
```
C[0][1] = A[0][0]×B[0][1] + A[0][1]×B[1][1] + A[0][2]×B[2][1]
        = 1×8 + 2×10 + 3×12
        = 8 + 20 + 36
        = 64
```

**Tính C[1][0]** (hàng 1 của A × cột 0 của B):
```
C[1][0] = A[1][0]×B[0][0] + A[1][1]×B[1][0] + A[1][2]×B[2][0]
        = 4×7 + 5×9 + 6×11
        = 28 + 45 + 66
        = 139
```

**Tính C[1][1]** (hàng 1 của A × cột 1 của B):
```
C[1][1] = A[1][0]×B[0][1] + A[1][1]×B[1][1] + A[1][2]×B[2][1]
        = 4×8 + 5×10 + 6×12
        = 32 + 50 + 72
        = 154
```

**Kết quả:**
```
C = [58][64]
    [139][154]
```

### **Code thực hiện trong Matrix.multi():**

```java
int[][] resultMatrix = new int[rows1][cols2]; // 2×2

for (int i = 0; i < rows1; i++) {           // i: 0 → 1 (duyệt hàng A)
    for (int j = 0; j < cols2; j++) {       // j: 0 → 1 (duyệt cột B)
        for (int k = 0; k < cols1; k++) {   // k: 0 → 2 (duyệt để nhân)
            resultMatrix[i][j] += mtrx1.matrix[i][k] * mtrx2.matrix[k][j];
        }
    }
}
```

**Giải thích vòng lặp:**
- **i**: Chỉ số hàng trong ma trận A (và kết quả C)
- **j**: Chỉ số cột trong ma trận B (và kết quả C)
- **k**: Chỉ số để duyệt qua các phần tử để nhân (cột của A, hàng của B)

**Diễn giải từng bước:**
```
i=0, j=0: resultMatrix[0][0] = A[0][0]*B[0][0] + A[0][1]*B[1][0] + A[0][2]*B[2][0]
i=0, j=1: resultMatrix[0][1] = A[0][0]*B[0][1] + A[0][1]*B[1][1] + A[0][2]*B[2][1]
i=1, j=0: resultMatrix[1][0] = A[1][0]*B[0][0] + A[1][1]*B[1][0] + A[1][2]*B[2][0]
i=1, j=1: resultMatrix[1][1] = A[1][0]*B[0][1] + A[1][1]*B[1][1] + A[1][2]*B[2][1]
```

---

## 4. HIỂN THỊ KẾT QUẢ

Sau khi tính toán xong, gọi:
```java
Matrix.displayResult(mtrx1, mtrx2, operator, mtrxResult)
```

Hàm này in ra:
```
-------- Result --------
[2][3][2]
[1][2][2]
+
[1][32][3]
[2][21][23]
=
[3][35][5]
[3][23][25]
```

**toString()** được gọi tự động khi in Matrix:
```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        sb.append("[").append(matrix[i][j]).append("]");
    }
    if (i < rows - 1) {
        sb.append("\n"); // Xuống dòng giữa các hàng
    }
}
```

---

## 5. XỬ LÝ LỖI

Nếu có lỗi (kích thước không khớp), catch exception:
```java
catch (IllegalArgumentException e) {
    System.out.println(e.getMessage());
}
```

**Ví dụ lỗi:**
- Cộng/Trừ: Ma trận 2×3 với 3×2 → "Matrices must have the same dimensions"
- Nhân: Ma trận 2×3 với 2×2 → "Number of columns of the first matrix must be equal to the number of rows of the second matrix"

---

## 6. QUAY LẠI MENU

Sau khi hiển thị kết quả hoặc lỗi, vòng lặp `while(true)` tiếp tục → quay lại menu.

#### **TH2: User chọn 4**
```
choice = 4
    ↓
In "Exiting the program. Goodbye!"
    ↓
break → Thoát vòng lặp → Kết thúc chương trình
```

---

## 7. TÓM TẮT LUỒNG CHẠY

```
START
  ↓
[MENU] Hiển thị 4 lựa chọn
  ↓
[INPUT] Nhận choice từ user (1-4)
  ↓
[CHECK] choice == 4?
  ├─ YES → Thoát chương trình
  └─ NO → Tiếp tục
       ↓
  [INPUT MATRIX] Nhập Matrix 1 (row, col, các phần tử)
       ↓
  [INPUT MATRIX] Nhập Matrix 2 (row, col, các phần tử)
       ↓
  [CALCULATE] Thực hiện phép tính theo choice:
       ├─ 1: Addition (Cộng)
       ├─ 2: Subtraction (Trừ)
       └─ 3: Multiplication (Nhân)
       ↓
  [VALIDATE] Kiểm tra điều kiện phép tính
       ├─ Hợp lệ → Tính toán
       └─ Không hợp lệ → Hiển thị lỗi
       ↓
  [DISPLAY] Hiển thị kết quả
       ↓
  Quay lại [MENU]
```

---

## 8. CÁC ĐIỂM QUAN TRỌNG

1. **Validation liên tục**: Nếu user nhập sai, chương trình sẽ yêu cầu nhập lại ngay vị trí đó
2. **Vòng lặp vô hạn**: Chương trình chỉ dừng khi user chọn 4
3. **Try-catch**: Xử lý lỗi kích thước ma trận không hợp lệ
4. **Static methods**: Matrix.add(), Matrix.sub(), Matrix.multi() là static để gọi dễ dàng
5. **Encapsulation**: Ma trận được lưu trong mảng 2 chiều private, chỉ thao tác qua methods

---

**Hy vọng giải thích này giúp bạn hiểu rõ luồng chạy của chương trình!** 🚀