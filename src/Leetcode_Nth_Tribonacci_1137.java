import java.util.Arrays;

public class Leetcode_Nth_Tribonacci_1137 {

    public static void main(String[] args) {
        System.out.println(nthTribonacciIterative(25));
    }

    public static int nthTribonacciRecursive(int n, int[] dic){
        if(n == 0){
            dic[n] = 0;
            return 0;
        }
        else if(n == 1 || n == 2){
            dic[n] = 1;
            return 1;
        }

       int first = 0, sec = 0, third = 0;
       if(n-1 >= 0){
           if(dic[n-1] != 0) {
               first = dic[n - 1];
           }else first = nthTribonacciRecursive(n-1, dic);
       }
        if(n-2 >= 0){
            if(dic[n-2] != 0) {
                sec = dic[n - 2];
            }else sec = nthTribonacciRecursive(n-2, dic);
        }
        if(n-3 >= 0){
            if(dic[n-3] != 0) {
                third = dic[n - 3];
            }else third = nthTribonacciRecursive(n-3, dic);
        }
       dic[n] = first + sec + third;
       return first + sec + third;
    }

    public static int nthTribonacciIterative(int n){

        int sum = 0, a = 0, b = 1, c = 1, d = 0, i = 0;

        if(n == 0) return a;
        else if(n == 1 || n == 2) return b;

        while(i < n-2){
           d = a + b + c;
           sum = d;
           a = b;
           b = c;
           c = d;
           i++;
        }
        return sum;
    }
}
