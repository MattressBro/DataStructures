package Module5;
//Braden Heeney
//CS400-1
//1/19/2025
//Radix Sort
public class radixSort {
    //method to find highest number in array to 
    //then discover the max place value
    private static int maxNum(int[] arr){
        int max = arr[0];
        for(int num : arr){
            if(num > max){
                max = num;
            }
        }
        return max;
    }
    private static void sort(int[] arr, int place, int max) {
    //base case for recursion will trigger when place value is greater than max number in array:  783/1000 = 0
    if (max / place <= 0) {
        return;
    }
    bucketSort(arr, place);

    sort(arr, place * 10, max);//recursive call to sort array place value is mutliplied by 10 - 1*10 gets your to the tens place then hundreds etc...
    }
    //bucketSort method is called for every place value
    private static void bucketSort(int[] arr, int place) {
        int n = arr.length;
        int[][] buckets = new int[10][n];//2D array to hold all buckets
        int[] bCount = new int[10];
        System.out.println("Sorted array:   "+ java.util.Arrays.toString(arr));
        for (int i = 0; i < n; i++) {
            int bIndex = (arr[i] / place) % 10; //extracts current place value
            buckets[bIndex][bCount[bIndex]++] = arr[i];
        }

        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < bCount[i]; j++) {
                arr[index++] = buckets[i][j];
            }
        }
    }
        public static void main(String[] args){
        int[] arr = {783,99,472,182,264,543,356,295,692,491,94};
        int max = maxNum(arr);
        System.out.println("Original array: "+ java.util.Arrays.toString(arr));
        sort(arr, 1, max);
        System.out.println("Sorted array:   "+ java.util.Arrays.toString(arr));
    }
}
