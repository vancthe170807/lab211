public class Main {

    // Chỉ có những thằng static thì mới chơi với nhau, ko cần phải tạo đối tượng thì vẫn gọi được static :))))
    public static int fibonacciHelper(int term, int lower, int higher) {

        // in ra 2 giá trị đầu tiên
        if (term < 2) {
            return higher;
        }
        System.out.print(higher + ", ");
        return fibonacciHelper(term - 1, higher, higher + lower);
        // lower này sẽ là higher cũ, còn higher này sẽ là (higher trước đó + lower trước đó nữa)
    }

    public static void main(String[] args) {
        System.out.println("===== [LAB211] J1.S.P0009 - FIBONACCI =====");
        System.out.println("The 45 sequence fibonacci: ");
        fibonacciHelper(46, 1, 0);
        System.out.println("\n===== END =====");
    }
}
