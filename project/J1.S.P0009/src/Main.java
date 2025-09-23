public class Main {
    public static void main(String[] args) {
        System.out.println("===== [LAB211] J1.S.P0009 - FIBONACCI =====");
        System.out.println("The 45 sequence fibonacci: ");
        fibonacciHelper(46, 1, 0);
        System.out.println("\n===== END =====");
    }

    public static int fibonacciHelper(int term, int lower, int higher) {
        if (term < 2) {
            return higher;
        }
        System.out.print(higher + " ");
        return fibonacciHelper(term - 1, higher, higher + lower);
    }
}
