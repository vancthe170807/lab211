public class Matrix {
    private static Validation validation = new Validation();
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Value of matrix is digit");
        }
        this.matrix = matrix;
    }

    public static Matrix add(Matrix mtrx1, Matrix mtrx2) {
        int rows1 = mtrx1.matrix.length;
        int cols1 = mtrx1.matrix[0].length;

        int rows2 = mtrx2.matrix.length;
        int cols2 = mtrx2.matrix[0].length;

        if (rows1 != rows2 || cols1 != cols2) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }

        int[][] resultMatrix = new int[rows1][cols1];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                resultMatrix[i][j] = mtrx1.matrix[i][j] + mtrx2.matrix[i][j];
            }
        }
        return new Matrix(resultMatrix);
    }

    public Matrix additionalMatrix(Matrix other) {
        return add(this, other);
    }

    public static Matrix sub(Matrix mtrx1, Matrix mtrx2) {
        int rows1 = mtrx1.matrix.length;
        int cols1 = mtrx1.matrix[0].length;

        int rows2 = mtrx2.matrix.length;
        int cols2 = mtrx2.matrix[0].length;
        if (rows1 != rows2 || cols1 != cols2) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for subtraction.");
        }

        int[][] resultMatrix = new int[rows1][cols1];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                resultMatrix[i][j] = mtrx1.matrix[i][j] - mtrx2.matrix[i][j];
            }
        }
        return new Matrix(resultMatrix);
    }

    public Matrix subtractMatrix(Matrix other) {
        return sub(this, other);
    }

    public static Matrix multi(Matrix mtrx1, Matrix mtrx2) {
        int rows1 = mtrx1.matrix.length;
        int cols1 = mtrx1.matrix[0].length;

        int rows2 = mtrx2.matrix.length;
        int cols2 = mtrx2.matrix[0].length;

        if (cols1 != rows2) {
            throw new IllegalArgumentException("Number of columns of the first matrix must be equal to the number of rows of the second matrix for multiplication.");
        }

        int[][] resultMatrix = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    resultMatrix[i][j] += mtrx1.matrix[i][k] * mtrx2.matrix[k][j];
                }
            }
        }
        return new Matrix(resultMatrix);
    }

    public Matrix multiplicationMatrix(Matrix other) {
        return multi(this, other);
    }

    public static Matrix inputMatrix(int number) {
        int row = validation.checkInteger("Enter Row matrix " + number + ": ");
        int col = validation.checkInteger("Enter Column matrix " + number + ": ");

        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = validation.checkInteger("Enter Matrix " + number + " [" + (i + 1) + "][" + (j + 1) + "]: ");

            }
        }
        return new Matrix(matrix);
    }

    public static void displayResult(Matrix mtrx1, Matrix mtrx2, String operator, Matrix mtrxResult) {
        System.out.println("-------- Result --------");
        System.out.println(mtrx1);
        System.out.println(operator);
        System.out.println(mtrx2);
        System.out.println("=");
        System.out.println(mtrxResult);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int rows = this.matrix.length;
        int cols = this.matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append("[").append(matrix[i][j]).append("]");
            }
            if (i < rows - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
