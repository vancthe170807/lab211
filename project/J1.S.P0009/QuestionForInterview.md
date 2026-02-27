1. Vai trò của hàm main là gì?
    
Hàm main là điểm khởi đầu của chương trình. Nó có nhiệm vụ in ra các dòng thông báo đầu và cuối, đồng thời gọi hàm fibonnaciHelper với các tham số ban đầu (45, 1, 0) để bắt đầu quá trình tính toán và in chuỗi Fibonacci.

2. Ý nghĩa của các tham số (term, lower, higher)?
    
- term: Đếm số lượng các số Fibonacci còn lại cần in ra.

- higher: Là số Fibonacci hiện tại đang được xử lý và in ra màn hình.
    
- lower: Là số Fibonacci liền trước đó, được dùng để tính toán số tiếp theo (higher + lower).

3. Điều kiện để dừng lại quá trình đệ quy là gì?
    
Quá trình đệ quy sẽ dừng lại khi tham số term nhỏ hơn 2 (tức là bằng 1 hoặc 0). Điều này được kiểm tra bằng câu lệnh if (term < 2), đảm bảo rằng hàm không gọi lại chính nó mãi mãi.

4. Mục đích của giá trị trả về (return) là gì?
    Hàm fibonnaciHelper trả về giá trị của số cuối cùng trong chuỗi Fibonacci (số thứ 45). Tuy nhiên, trong đoạn code này, giá trị này chỉ được trả về để hoàn tất luồng của hàm đệ quy mà không được sử dụng vào mục đích tính toán hay lưu trữ nào khác. Toàn bộ chuỗi Fibonacci đã được in ra trực tiếp bằng lệnh System.out.print trong quá trình hàm tự gọi lại.
    
5. Giải thích cách hoạt động của hàm fibonnaciHelper?
    Hàm fibonnaciHelper hoạt động dựa trên nguyên tắc đệ quy để tính và in ra chuỗi Fibonacci. Khi hàm được gọi, nó kiểm tra điều kiện dừng (term < 2). Nếu điều kiện này đúng, hàm trả về giá trị của higher (số Fibonacci hiện tại). Nếu điều kiện không đúng, hàm in ra giá trị của higher, sau đó gọi lại chính nó với các tham số được cập nhật:
    - term giảm đi 1 (bởi vì một số Fibonacci đã được in ra).
    - higher được cập nhật thành higher + lower (tính số Fibonacci tiếp theo).
    - lower được cập nhật thành higher (số Fibonacci hiện tại trở thành số liền trước trong lần gọi tiếp theo).
    Quá trình này tiếp tục cho đến khi tất cả các số Fibonacci cần in ra đã được xử lý.
    
6. Ưu điểm và nhược điểm của việc sử dụng đệ quy trong hàm này? 
    
    Ưu điểm:
    
    - Mã nguồn ngắn gọn và dễ hiểu: Việc sử dụng đệ quy giúp mã nguồn trở nên ngắn gọn và dễ đọc hơn so với việc sử dụng vòng lặp.
    - Tính trực quan: Đệ quy thể hiện rõ ràng ý tưởng về việc tính toán chuỗi Fibonacci, giúp người đọc dễ dàng nắm bắt logic của chương trình.

    Nhược điểm:
    - Hiệu suất: Đệ quy có thể dẫn đến việc sử dụng nhiều bộ nhớ hơn do các lần gọi hàm lồng nhau, đặc biệt khi số lượng các số Fibonacci lớn.
    - Giới hạn đệ quy: Trong một số ngôn ngữ lập trình, có giới hạn về độ sâu của đệ quy, điều này có thể làm cho chương trình bị lỗi nếu quá sâu.
    - Khó kiểm soát: Việc theo dõi và gỡ lỗi các hàm đệ quy có thể khó khăn hơn so với các cấu trúc lặp truyền thống.
    
7. Làm thế nào để tối ưu hóa hàm này để tránh việc gọi đệ quy quá sâu?
    - Sử dụng vòng lặp thay vì đệ quy: Thay vì sử dụng đệ quy, có thể sử dụng vòng lặp để tính toán chuỗi Fibonacci, điều này sẽ tránh được vấn đề về độ sâu đệ quy.
    - Sử dụng kỹ thuật memo
    - ization: Lưu trữ các giá trị đã tính toán trước đó để tránh việc tính toán lại, giúp giảm số lần gọi hàm đệ quy.
    - Sử dụng đệ quy đuôi (tail recursion): Nếu ngôn ngữ lập trình hỗ trợ tối ưu hóa đệ quy đuôi, có thể viết lại hàm để tận dụng lợi ích này.
    - Giới hạn số lượng các số Fibonacci cần tính: Nếu chỉ cần một số lượng nhỏ các số Fibonacci, có thể giới hạn số lượng này để tránh việc gọi đệ quy quá sâu.
    - Sử dụng ngôn ngữ hoặc thư viện hỗ trợ: Một số ngôn ngữ hoặc thư viện có thể cung cấp các hàm tối ưu để tính toán chuỗi Fibonacci.
    
8. Chức năng phụ: 

    8.1. Thêm số thứ tự vào chuỗi Fibonacci được in ra.
    Để thêm số thứ tự vào chuỗi Fibonacci được in ra, ta có thể bổ sung một tham số mới vào hàm fibonnaciHelper để theo dõi số thứ tự hiện tại.
    Dưới đây là cách thực hiện:

    ```java
    public class Main {
        public static void main(String[] args) {
            System.out.println("===== [LAB211] J1.S.P0009 - FIBONACCI =====");
            System.out.println("The 45 sequence fibonacci: ");
            fibonacciHelper(46, 0, 1, 1); // Bắt đầu với số thứ tự là 1
            System.out.println("\n===== END =====");
        }
    
        public static int fibonacciHelper(int term, int higher, int lower, int index) {
            if (term < 2) {
                return higher;
            } else {
                System.out.println(index + ": " + higher + " "); // In số thứ tự cùng với giá trị Fibonacci
                return fibonacciHelper(term - 1, higher + lower, higher, index + 1); // Tăng số thứ tự lên 1
            }
        }
    }
    ```

   Trong đoạn mã trên, tham số `index` được thêm vào hàm `fibonnaciHelper` để theo dõi số thứ tự của mỗi số Fibonacci. Mỗi lần in ra một số Fibonacci, ta cũng in kèm theo số thứ tự tương ứng. Khi gọi lại hàm đệ quy, ta tăng giá trị của `index` lên 1 để chuẩn bị cho lần in tiếp theo.

   8.2. Fibonacci đảo

   ```java
    public class Main {

        public static void fibonacciReverse(int term, int lower, int higher) {
    
            // Khi term đạt giá trị này => DỪNG
            if (term <= 0) {
                return;
            }
    
            fibonacciHelper(term - 1, higher, higher + lower);
    
            System.out.print(higher + ", ");
        }

        public static void main(String[] args) {
            System.out.println("===== [LAB211] J1.S.P0009 - FIBONACCI =====");
            System.out.println("The 45 sequence fibonacci: ");
            fibonacciReverse(45, 1, 0);
            System.out.println("\n===== END =====");
        }
    }

   ```
    8.3. Tìm số thuộc Fibonacci

    ```java

    import java.util.Scanner;
    
    public class Main {
    
        // Hàm 1: In dãy số (Code cũ của bạn đã sửa lại void)
        public static void fibonacciHelper(int count, int lower, int higher) {
            if (count <= 0) return;
            System.out.print(higher + ", ");
            fibonacciHelper(count - 1, higher, higher + lower);
        }
    
        // Hàm 2: Kiểm tra số thuộc dãy (Logic MỚI)
        // target: số người dùng muốn kiểm tra
        public static boolean checkFibonacci(int target, int lower, int higher) {
            // Trường hợp 1: Tìm thấy!
            if (higher == target) {
                return true;
            }
    
            // Trường hợp 2: Số hiện tại đã lớn hơn số cần tìm -> Không bao giờ tìm thấy nữa
            // Ví dụ: target = 4. Dãy chạy: 0, 1, 1, 2, 3, 5... (5 > 4 nên dừng luôn)
            if (higher > target) {
                return false;
            }
    
            // Trường hợp 3: Số hiện tại vẫn nhỏ hơn target -> Gọi đệ quy để kiểm tra số kế tiếp
            return checkFibonacci(target, higher, higher + lower);
        }
    
        public static void main(String[] args) {
            // --- Phần 1: In dãy cũ ---
            System.out.println("The 10 sequence fibonacci: ");
            fibonacciHelper(10, 1, 0);
            System.out.println("\n--------------------------");
    
            System.out.print("Input an integer number for check: ");
    
            // --- Phần 2: Kiểm tra số thuộc dãy ---
            int numberToCheck = new Scanner(System.in).nextInt(); // Thử thay số này bằng 5 hoặc 8 để test
    
            // Gọi hàm kiểm tra bắt đầu từ số đầu tiên của dãy (lower=1, higher=0)
            boolean isFibo = checkFibonacci(numberToCheck, 1, 0);
    
            if (isFibo) {
                System.out.println(numberToCheck + " is a member of Fibonacci Number.");
            } else {
                System.out.println(numberToCheck + " isn't a member of Fibonacci Number.");
            }
        }
    }
    ```
