import java.awt.geom.Area;
import java.util.Arrays;

public class Leetcode_Fibonacci_509 {
    public static void main(String[] args) {
        System.out.println(fib2(6));
    }

    public static int fib(int n, int[] arr) {
        if(n <= 1){
            arr[n] = n;
            return n;
        }

        if(arr[n-1] == 0){
            return fib(n-1, arr) + fib(n-2, arr);
        }else return arr[n-1];
    }

    public static int fib2(int n) {
        if(n <= 1){
            return n;
        }

       else return memoisation(n)[n];
    }

    private static int[] memoisation(int n) {
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i <= n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr;
    }
}
