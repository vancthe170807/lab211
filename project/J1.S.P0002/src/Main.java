import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    /**
     * Method to sort an array of integers using Selection Sort algorithm.
     * @param arr the array to be sorted.
     */
    public static void selectionSort (int[] arr) {
        // loop through the array
        for (int i = 0; i < arr.length - 1; i++) {
            // find the minimum element in the unsorted part of the array
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap the minimum element with the first element of the unsorted part
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    /**
     * Prints an array in the format [1, 2, 3, 4].
     * @param arr the array to be printed.
     */
    public static void printArray(int[] arr) {
        // Start with a '['
        System.out.print("[");
        // Loop through the elements of the array
        for (int i = 0; i < arr.length; i++) {
            // Print the current element
            System.out.print(arr[i]);
            // If the current element is not the last element
            if (i < arr.length - 1) {
                // Print a comma followed by a space
                System.out.print(", ");
            }
        }
        // End with a ']'
        System.out.println("]");
    }

    /**
     * Entry point of the application.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        System.out.println("===== [LAB211] J1.S.P0002 - SELECTION SORT ======");

        // Ask for the size of the array
        System.out.print("Enter array size: ");
        int number = Validate.getPositiveInt();  // Using our fixed method

        // Create an array of 'number' elements
        int[] arr = new int[number];

        // Create a Random instance
        Random random = new Random(); // Correctly creating a Random instance

        // Fill the array with random numbers
        System.out.print("Unsorted array: ");
        for (int i = 0; i < number; i++) {
            arr[i] = random.nextInt(100); // Fixing Random usage
        }
        // Print the array in the format [1, 2, 3, 4]
        printArray(arr); // Print array in required format

        // Sort the array using Selection Sort algorithm
        selectionSort(arr);

        // Display sorted array
        System.out.print("Sorted array: ");
        // Print the array in the format [1, 2, 3, 4]
        printArray(arr); // Print array in required format

        // Finish the program
        System.out.println("===== END ======");
    }
}