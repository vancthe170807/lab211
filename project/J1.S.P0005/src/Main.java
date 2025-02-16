import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    /**
     * Sorts an array using the Merge Sort algorithm.
     *
     * @param arr the array to be sorted
     * @param left the starting index
     * @param right the ending index
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively sort the first half
            mergeSort(arr, left, mid);

            // Recursively sort the second half
            mergeSort(arr, mid + 1, right);

            // Merge the two halves
            merge(arr, left, mid, right);
        }
    }

    /**
     * Merges two subarrays of arr[].
     * First subarray is arr[left..mid]
     * Second subarray is arr[mid+1..right]
     *
     * @param arr the array to be merged
     * @param left the starting index
     * @param mid the middle index
     * @param right the ending index
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // Merge the temp arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
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
        System.out.println("===== [LAB211] J1.S.P0005 - MERGE SORT ======");

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

        // Sort the array using Merge Sort algorithm
        mergeSort(arr, 0, arr.length - 1);  // Use Merge Sort

        // Display sorted array
        System.out.print("Sorted array: ");
        printArray(arr); // Print sorted array

        System.out.println("===== END ======");
    }
}
