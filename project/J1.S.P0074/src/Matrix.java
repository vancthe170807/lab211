public class Matrix {
    private int[][] matrix;
    private int rows;
    private int cols;

    public Matrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Value of matrix is digit");
        }
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public Matrix additionalMatrix(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }

        int[][] resultMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrix[i][j] + other.matrix[i][j];
            }
        }
        return new Matrix(resultMatrix);
    }

    public Matrix subtractMatrix(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for subtraction.");
        }

        int[][] resultMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrix[i][j] - other.matrix[i][j];
            }
        }
        return new Matrix(resultMatrix);
    }

    public Matrix multiplicationMatrix(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Number of columns of the first matrix must be equal to the number of rows of the second matrix for multiplication.");
        }

        int[][] resultMatrix = new int[this.rows][other.cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    resultMatrix[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return new Matrix(resultMatrix);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
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
