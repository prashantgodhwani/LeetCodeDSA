package Test.BiWeekly53;

import java.util.Arrays;

public class MinimiseMaximumPairSumInArray {

    public static void main(String[] args) {
        int res = minimiseMaximumPairSum(new int[] {3,5,2,3});
        System.out.println(res);
    }

    public static int minimiseMaximumPairSum(int[] arr){

        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;

        int j = arr.length - 1;
        for(int i = 0; i < arr.length / 2; i++){
            max = Math.max(max, arr[i] + arr[j]);
            j--;
        }

        return max;
    }
}
