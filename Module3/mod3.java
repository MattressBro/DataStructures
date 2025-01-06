package Module3;

public class mod3 {
    public static void main(String[] args){
        int[] numArr = {3,6,5,1,4};
        int maxSum = ((numArr.length+1) * (numArr.length+2))/2; //sum of integers formula with the addition of n+1 
        for(int i=0; i < numArr.length; i++){
            maxSum = maxSum - numArr[i];
        }
        System.out.println("Missing number from array is " + maxSum+".");
    }
}
