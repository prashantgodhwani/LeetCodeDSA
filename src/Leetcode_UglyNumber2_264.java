import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode_UglyNumber2_264 {

    public static void main(String[] args) {
        int res = nthUglyNumber(25);
        System.out.println(res);
    }

    public static int nthUglyNumber(int n) {
        int[] arr = new int[n];

        int two = 0, three = 0, five = 0;

        arr[0] = 1;

        for(int i = 1; i < n; i++){

            int min = Math.min(2 * arr[two], Math.min(3 * arr[three], 5 * arr[five]));
            System.out.println("min = " + min);

            arr[i] = min;

            if(min == 2 * arr[two]) two++;
            if(min == 3 * arr[three]) three++;
            if(min == 5 * arr[five]) five++;

            System.out.println(Arrays.toString(arr));
        }

        return arr[n-1];
    }
}
