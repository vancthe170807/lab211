public class Matrix {

    public int[][] inputMatrix(int n) {
        Validation validation = new Validation();
        int row = validation.checkInputInt("Enter Row Matrix: ");
        int col = validation.checkInputInt("Enter Colum Matrix: ");
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = validation.checkInputInt("Enter Matrix" + n + "[" + (i+1) + "]" + "[" + (j+1) + "]:");
            }
        }
        return matrix;
    }

    public void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        int row = matrix1.length;
        int col = matrix1[0].length;

        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
                System.out.print("[" + result[i][j] + "]");
            }
            System.out.println();
        }
        return result;
    }

    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("-------- Result --------");
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        int row = matrix1.length;
        int col = matrix1[0].length;

        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
                System.out.print("[" + result[i][j] + "]");
            }
            System.out.println();
        }
        return result;
    }

    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        System.out.println("-------- Result --------");
        // Display the matrices 1
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        if (col1 != row2) {
            System.err.println("Can't multiply");
            return null;
        }
        int[][] matrixResult = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
                System.out.print("[" + matrixResult[i][j] + "]");
            }
            System.out.println();
        }
        return matrixResult;
    }

}
