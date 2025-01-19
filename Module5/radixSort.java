package Module5;

public class radixSort {
    //method to find highest number in array to 
    //then discover the max digits
    private static int maxNum(int[] arr){
        int max = arr[0];
        for(int num : arr){
            if(num > max){
                max = num;
            }
        }
        return max;
    }
    public static void radix(int[] arr){
        int max = maxNum(arr);
        System.out.println("Max Number "+max);
        int digiMax = (int)Math.log10(max)+1;
        System.out.println("Max digits "+digiMax);
        int place =1;
        for(int i=0; i < digiMax; i++){
            sort(arr,place);
            place *=10;
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void sort(int[] arr, int place){
        for(int i=0; i < arr.length-1; i++){
            for(int j=i+1; j < arr.length; j++){
                int digitI =(arr[i] / place )% 10;
                int digitJ =(arr[j] / place )% 10;
                if(digitI > digitJ){
                    int temp =arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args){
        //int[] arr = {543, 356, 264, 472, 783, 182, 692, 94, 295, 491, 99};
        int[] arr = {783,99,472,182,264,543,356,295,692,491,94};
        radix(arr);
        //sort(arr, 100);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
//int[] arr = {783,99,472,182,264,543,356,295,692,491,94};