import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    /**
     * Sorts an array of integers using the insertion sort algorithm.
     * @param arr the array of integers to be sorted.
     */
    public static void insertionSort(int[] arr) {
        // Loop through the array
        for (int i = 1; i < arr.length; i++) {
            // Hold the current element in a variable
            int key = arr[i];
            // Initialize the index of the previous element
            int j = i - 1;
            // Loop until the previous element is smaller than the current element
            while (j >= 0 && arr[j] > key) {
                // Shift the previous element to the right
                arr[j + 1] = arr[j];
                // Decrement the index
                j--;
            }
            // Place the current element in the correct position
            arr[j + 1] = key;
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
        System.out.println("===== [LAB211] J1.S.P0003 - INSERTION SORT ======");

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
        insertionSort(arr);

        // Display sorted array
        System.out.print("Sorted array: ");
        // Print the array in the format [1, 2, 3, 4]
        printArray(arr); // Print array in required format

        // Finish the program
        System.out.println("===== END ======");
    }
}