import java.util.Random;
import java.util.Scanner;

public class Main {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean sorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                return;
            }
        }
    }

    // Method to print array in the format [1, 2, 3, 4]
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        System.out.println("===== [LAB211] J1.S.P0001 - BUBBLE SORT ======");
        System.out.print("Enter array size: ");
        int number = Validate.getPositiveInt();  // Using our fixed method
        int[] arr = new int[number];

        Random random = new Random(); // Correctly creating a Random instance

        System.out.print("Unsorted array: ");
        for (int i = 0; i < number; i++) {
            arr[i] = random.nextInt(100); // Fixing Random usage
        }
        printArray(arr); // Print array in required format

        // Sorting the array
        bubbleSort(arr);

        // Display sorted array
        System.out.print("Sorted array: ");
        printArray(arr); // Print array in required format
        System.out.println("===== END ======");
    }
}
