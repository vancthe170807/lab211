/**
 * Represents a matrix and provides operations such as addition, subtraction,
 * and multiplication on matrices.
 */
public class Matrix {
    private static Validation validation = new Validation();
    private int[][] matrix;

    /**
     * Constructs a Matrix object.
     *
     * @param matrix A 2D array representing the matrix.
     * @throws IllegalArgumentException if the matrix is null, or empty.
     */
    public Matrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Value of matrix is digit");
        }
        this.matrix = matrix;
    }

    /**
     * Adds two matrices and returns the result as a new Matrix.
     *
     * @param mtrx1 First matrix.
     * @param mtrx2 Second matrix.
     * @return A new Matrix that is the result of adding mtrx1 and mtrx2.
     * @throws IllegalArgumentException if the dimensions of the matrices do not match.
     */
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

    /**
     * Adds this matrix with another matrix.
     *
     * @param other The other matrix to add.
     * @return A new Matrix that is the result of the addition.
     */
    public Matrix additionalMatrix(Matrix other) {
        return add(this, other);
    }

    /**
     * Subtracts the second matrix from the first matrix and returns the result.
     *
     * @param mtrx1 First matrix.
     * @param mtrx2 Second matrix.
     * @return A new Matrix that is the result of subtracting mtrx2 from mtrx1.
     * @throws IllegalArgumentException if the dimensions of the matrices do not match.
     */
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

    /**
     * Subtracts another matrix from this matrix.
     *
     * @param other The other matrix to subtract.
     * @return A new Matrix that is the result of the subtraction.
     */
    public Matrix subtractMatrix(Matrix other) {
        return sub(this, other);
    }

    /**
     * Multiplies two matrices and returns the result as a new Matrix.
     *
     * @param mtrx1 First matrix.
     * @param mtrx2 Second matrix.
     * @return A new Matrix that is the result of multiplying mtrx1 and mtrx2.
     * @throws IllegalArgumentException if the number of columns of mtrx1
     *                                  does not match the number of rows of mtrx2.
     */
    public static Matrix multi(Matrix mtrx1, Matrix mtrx2) {
        int rows1 = mtrx1.matrix.length;
        int cols1 = mtrx1.matrix[0].length;

        int rows2 = mtrx2.matrix.length;
        int cols2 = mtrx2.matrix[0].length;

        if (cols1 != rows2) {
            throw new IllegalArgumentException("Number of columns of the first matrix must be equal to the number "
                    + "of rows of the second matrix for multiplication.");
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

    /**
     * Multiplies this matrix with another matrix.
     *
     * @param other The other matrix to multiply with.
     * @return A new Matrix that is the result of the multiplication.
     */
    public Matrix multiplicationMatrix(Matrix other) {
        return multi(this, other);
    }

    /**
     * Accepts user input to create a matrix.
     *
     * @param number The identifier number of the matrix (used in display prompts).
     * @return A new Matrix created from user input.
     */
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

    /**
     * Displays the result of a matrix operation in a formatted manner.
     *
     * @param mtrx1       The first matrix.
     * @param mtrx2       The second matrix.
     * @param operator    The operator as a string (e.g., "+", "-", "*").
     * @param mtrxResult  The resulting matrix of the operation.
     */
    public static void displayResult(Matrix mtrx1, Matrix mtrx2, String operator, Matrix mtrxResult) {
        System.out.println("-------- Result --------");
        System.out.println(mtrx1);
        System.out.println(operator);
        System.out.println(mtrx2);
        System.out.println("=");
        System.out.println(mtrxResult);
    }

    /**
     * Converts the matrix to a formatted string for display.
     *
     * @return A string representation of the matrix.
     */
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
