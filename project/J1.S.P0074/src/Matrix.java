public class Matrix {
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Value of matrix is digit");
        }
        this.matrix = matrix;
    }

    public Matrix additionalMatrix(Matrix other) {
        int rows1 = this.matrix.length;
        int cols1 = this.matrix[0].length;

        int rows2 = other.matrix.length;
        int cols2 = other.matrix[0].length;

        if (rows1 != rows2 || cols1 != cols2) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }

        int[][] resultMatrix = new int[rows1][cols1];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                resultMatrix[i][j] = matrix[i][j] + other.matrix[i][j];
            }
        }
        return new Matrix(resultMatrix);
    }

    public Matrix subtractMatrix(Matrix other) {
        int rows1 = this.matrix.length;
        int cols1 = this.matrix[0].length;

        int rows2 = other.matrix.length;
        int cols2 = other.matrix[0].length;
        if (rows1 != rows2 || cols1 != cols2) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for subtraction.");
        }

        int[][] resultMatrix = new int[rows1][cols1];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                resultMatrix[i][j] = matrix[i][j] - other.matrix[i][j];
            }
        }
        return new Matrix(resultMatrix);
    }

    public Matrix multiplicationMatrix(Matrix other) {
        int rows1 = this.matrix.length;
        int cols1 = this.matrix[0].length;

        int rows2 = other.matrix.length;
        int cols2 = other.matrix[0].length;

        if (cols1 != rows2) {
            throw new IllegalArgumentException("Number of columns of the first matrix must be equal to the number of rows of the second matrix for multiplication.");
        }

        int[][] resultMatrix = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    resultMatrix[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return new Matrix(resultMatrix);
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
