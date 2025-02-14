import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    /**
     * Sorts an array using the QuickSort algorithm.
     *
     * @param arr the array to be sorted
     * @param low the starting index
     * @param high the ending index
     */
    public static void quickSort(int[] arr, int low, int high) {
        // Check if low index is less than high index
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(arr, low, high);

            // Recursively sort elements before the pivot
            quickSort(arr, low, pi - 1);

            // Recursively sort elements after the pivot
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
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
        System.out.println("===== [LAB211] J1.S.P0004 - QUICK SORT ======");

        // Ask for the size of the array
        System.out.print("Enter array size: ");
        int number = Validate.getPositiveInt();  // Ensure Validate class exists

        // Create an array of 'number' elements
        int[] arr = new int[number];

        // Create a Random instance
        Random random = new Random();

        // Fill the array with random numbers
        System.out.print("Unsorted array: ");
        for (int i = 0; i < number; i++) {
            arr[i] = random.nextInt(100);
        }
        printArray(arr); // Print unsorted array

        // Sort the array using Quick Sort algorithm
        quickSort(arr, 0, arr.length - 1);  // Fix: Pass correct parameters

        // Display sorted array
        System.out.print("Sorted array: ");
        printArray(arr); // Print sorted array

        System.out.println("===== END ======");
    }
}