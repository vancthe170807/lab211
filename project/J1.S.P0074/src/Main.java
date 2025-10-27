public class Main {
    private static final Validation validation = new Validation();

    public static void main(String[] args) {
        while (true) {
            int choice = displayMenuAndGetChoice();
            if (choice >= 1 && choice <= 3) {
                if (choice == 1) {
                    System.out.println("------- Addition Matrix -------");
                } else if (choice == 2) {
                    System.out.println("------- Subtraction Matrix -------");
                } else {
                    System.out.println("------- Multiplication Matrix -------");
                }
                Matrix mtrx1 = Matrix.inputMatrix(1);
                Matrix mtrx2 = Matrix.inputMatrix(2);

                Matrix mtrxResult = null;
                String operator = "";
                try {
                    switch (choice) {
                        case 1:
                            mtrxResult = mtrx1.additionalMatrix(mtrx2);
                            operator = "+";
                            break;
                        case 2:
                            mtrxResult = mtrx1.subtractMatrix(mtrx2);
                            operator = "-";
                            break;
                        case 3:
                            mtrxResult = mtrx1.multiplicationMatrix(mtrx2);
                            operator = "*";
                            break;
                    }
                    Matrix.displayResult(mtrx1, mtrx2, operator, mtrxResult);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }
        }
    }

    private static int displayMenuAndGetChoice() {
        System.out.println("======= Calculator Program =======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");

        return validation.checkIntegerLimit(1, 4, "Your choice: ");
    }


}
