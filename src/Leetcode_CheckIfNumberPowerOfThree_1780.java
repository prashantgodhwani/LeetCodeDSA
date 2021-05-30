import java.util.Arrays;

public class Leetcode_CheckIfNumberPowerOfThree_1780 {
    public static void main(String[] args) {
        int i = 1, count = 1;
        while(i * 3 <= 27){
            i = i * 3;
            count++;
        }

        int[] arr = new int[count];
        for(int j = 0, k = 1; j < count; j++, k*=3){
            arr[j] = k;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(checkPowersOfThree(27, arr, 0, false));
    }

    public static boolean checkPowersOfThree(int n, int[] qsf, int idx, Boolean res) {
       if(n == 0){
           res = true;
           System.out.println("****found*****");
           return res;
       }
       else if(idx == qsf.length || n < 0) return res;

       res = checkPowersOfThree(n-qsf[idx], qsf, idx+1, res);
       System.out.println("second call going now...");
       res = checkPowersOfThree(n, qsf, idx+1, res);
       return res;
    }
}
