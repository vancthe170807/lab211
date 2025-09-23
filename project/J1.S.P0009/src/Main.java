//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("===== [LAB211] J1.S.P0009 - FIBONACCI =====");
        System.out.println("The 45 sequence fibonacci: ");
        fibonnaciHelper(45, 1, 0);
        System.out.println("\n===== END =====");
    }

    public static int fibonnaciHelper(int term, int lower, int higher) {
        if (term < 2) {
            return higher;
        }
        System.out.print(higher + " ");
        return fibonnaciHelper(term - 1, higher, higher + lower);
    }
}

/*
* Vai trò của hàm main là gì?
Hàm main là điểm khởi đầu của chương trình. Nó có nhiệm vụ in ra các dòng thông báo đầu và cuối, đồng thời gọi hàm
fibonnaciHelper với các tham số ban đầu (45, 1, 0) để bắt đầu quá trình tính toán và in chuỗi Fibonacci.

Ý nghĩa của các tham số (term, lower, higher)?
term: Đếm số lượng các số Fibonacci còn lại cần in ra.

higher: Là số Fibonacci hiện tại đang được xử lý và in ra màn hình.

lower: Là số Fibonacci liền trước đó, được dùng để tính toán số tiếp theo (higher + lower).

Điều kiện để dừng lại quá trình đệ quy là gì?
Quá trình đệ quy sẽ dừng lại khi tham số term nhỏ hơn 2 (tức là bằng 1 hoặc 0). Điều này được kiểm tra bằng câu lệnh
if (term < 2), đảm bảo rằng hàm không gọi lại chính nó mãi mãi.

Mục đích của giá trị trả về (return) là gì?
Hàm fibonnaciHelper trả về giá trị của số cuối cùng trong chuỗi Fibonacci (số thứ 45). Tuy nhiên, trong đoạn code này,
giá trị này chỉ được trả về để hoàn tất luồng của hàm đệ quy mà không được sử dụng vào mục đích tính toán hay lưu trữ
nào khác. Toàn bộ chuỗi Fibonacci đã được in ra trực tiếp bằng lệnh System.out.print trong quá trình hàm tự gọi lại.
* */