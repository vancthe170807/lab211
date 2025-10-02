
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        Menu menu = new Menu();
        System.out.println("----- [LAB211] J1.S.P0074 - MATRIX CALCULATOR -----");
        while (true) {
            int choice = menu.menu();
            switch (choice) {
                case 1: {
                    System.out.println("----- Addition -----");
                    int[][] matrix1 = matrix.inputMatrix(1);
                    int[][] matrix2 = matrix.inputMatrix(2);
                    matrix.additionMatrix(matrix1, matrix2);
                    break;
                }
                case 2: {
                    System.out.println("----- Subtraction -----");
                    int[][] matrix1 = matrix.inputMatrix(1);
                    int[][] matrix2 = matrix.inputMatrix(2);
                    matrix.subtractionMatrix(matrix1, matrix2);
                    break;
                }
                case 3: {
                    System.out.println("----- Multiplication -----");
                    int[][] matrix1 = matrix.inputMatrix(1);
                    int[][] matrix2 = matrix.inputMatrix(2);
                    matrix.multiplicationMatrix(matrix1, matrix2);
                    break;
                }
                case 4:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
