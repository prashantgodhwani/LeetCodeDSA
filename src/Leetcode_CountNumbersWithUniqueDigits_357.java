import java.lang.reflect.Array;
import java.util.Arrays;

public class Leetcode_CountNumbersWithUniqueDigits_357 {
    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits_optimized(3));
    }

    public static int countNumbersWithUniqueDigitsUtil(int n) {
        boolean[] arr = null;
        int count = 0;

        first:
        for(int i = 0; i < n; i++){
            arr = new boolean[10];
            int k = i;
            while(k != 0){
                int p = k % 10;
                if(arr[p]) continue first;
                arr[p] = true;
                k/=10;
            }

            count++;
        }
        return count;
    }

    public static int countNumbersWithUniqueDigits_optimized(int n){
        if(n == 0) return 1;
        if(n == 1) return 10;
        if(n == 2) return 81;

        int totalUnique = 0, num, base = 91;
        for(int i = 3; i <= n; i++) {
            totalUnique = 81;
            num = 8;
            int k = i;
            while (k-2 != 0) {
                totalUnique *= num;
                --num;
                --k;
            }
            totalUnique += base;
            System.out.println("i = " + i + ", val = " + totalUnique);
            base = totalUnique;
        }

        return totalUnique;
    }


}
