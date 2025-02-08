package Module5;

import java.util.Arrays;

public class newRadixSort {

    // Method to find the highest number in array to determine the maximum place value
    private static int maxNum(int[] arr) {
        int max = Math.abs(arr[0]);
        for (int num : arr) {
            if (Math.abs(num) > max) {  // Find the max by absolute value
                max = Math.abs(num);
            }
        }
        return max;
    }

    // Radix sort logic
    private static void sort(int[] arr, int place) {
        int n = arr.length;
        int[][] buckets = new int[10][n]; // 2D array to hold all buckets
        int[] bCount = new int[10];

        // Separate numbers based on place value
        for (int i = 0; i < n; i++) {
            int bIndex = (Math.abs(arr[i]) / place) % 10;  // Extracts current place value
            buckets[bIndex][bCount[bIndex]++] = arr[i];
        }

        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < bCount[i]; j++) {
                arr[index++] = buckets[i][j];
            }
        }
    }

    private static void radixSort(int[] arr) {
        int max = maxNum(arr);
        for (int place = 1; max / place > 0; place *= 10) {
            sort(arr, place);
        }
    }

    public static void main(String[] args) {
        int[] arr = {783, -99, 472, -182, 264, -543, 356, -295, 692, 491, 94};
        System.out.println("Original array: " + Arrays.toString(arr));

        // Split the array into negative and positive arrays
        int[] positiveArr = new int[arr.length];
        int[] negativeArr = new int[arr.length];
        int posIndex = 0, negIndex = 0;

        // Fill in the positive and negative arrays
        for (int num : arr) {
            if (num >= 0) {
                positiveArr[posIndex++] = num;
            } else {
                negativeArr[negIndex++] = num;
            }
        }

        // Sort both arrays
        int[] positiveSorted = Arrays.copyOfRange(positiveArr, 0, posIndex);
        int[] negativeSorted = Arrays.copyOfRange(negativeArr, 0, negIndex);

        radixSort(positiveSorted);  // Sort positive numbers
        radixSort(negativeSorted);  // Sort negative numbers

        // Add back the negative sign to negative numbers after sorting
        for (int i = 0; i < negIndex; i++) {
            negativeSorted[i] = -Math.abs(negativeSorted[i]);  // Convert back to negative
        }

        // Combine the negative and positive arrays
        int[] sortedArr = new int[arr.length];
        int sortedIndex = 0;

        // Add negative numbers first (in reverse order)
        for (int i = negIndex - 1; i >= 0; i--) {
            sortedArr[sortedIndex++] = negativeSorted[i];
        }

        // Add positive numbers
        for (int i = 0; i < posIndex; i++) {
            sortedArr[sortedIndex++] = positiveSorted[i];
        }

        // Print the sorted array
        System.out.println("Sorted array:   " + Arrays.toString(sortedArr));
    }
}
