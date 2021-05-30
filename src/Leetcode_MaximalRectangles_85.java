import java.util.Arrays;
import java.util.Stack;

public class Leetcode_MaximalRectangles_85 {

    public static void main(String[] args) {
        int[][] arr = {
                {1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,0,0,1,0}
        };

        int res = maximalRectangles(arr);
        System.out.println(res);
    }

    private static int maximalRectangles(int[][] arr){
        int oMax = 0;
        int[] curr = arr[0];

        for(int i = 0; i < arr.length; i++){

            oMax = Math.max(oMax, largetAreaHistogram(curr));

            if(i != arr.length - 1) {
                for (int j = 0; j < curr.length; j++) {
                    if(arr[i + 1][j] == 0){
                        curr[j] = 0;
                    }else {
                        curr[j] += 1;
                    }
                }
            }
        }

        return oMax;
    }

    private static int largetAreaHistogram(int[] arr){
        int[] lsi = nextSmallerOnLeft(arr);
        int[] rsi = nextSmallerOnRight(arr);
        int maxArea = 0;

        for(int i = 0; i < arr.length; i++){
            int width = rsi[i] - lsi[i] - 1;
            maxArea = Math.max(maxArea, width * arr[i]);
        }

        return maxArea;
    }

    private static int[] nextSmallerOnLeft(int[] arr){
        Stack<Integer> stack = new Stack<>();

        stack.push(arr.length - 1);

        int[] res = new int[arr.length];

        for(int i = arr.length - 2; i >= 0; i--){
            while(stack.size() > 0 && arr[stack.peek()] > arr[i]){
                res[stack.pop()] = i;
            }

            stack.push(i);

            System.out.println(stack);
        }

        while(stack.size() > 0){
            res[stack.pop()] = -1;
        }

        return res;
    }

    private static int[] nextSmallerOnRight(int[] arr){
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        int[] res = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            while(stack.size() > 0 && arr[stack.peek()] > arr[i]){
                res[stack.pop()] = i;
            }

            stack.push(i);

            System.out.println(stack);
        }

        while(stack.size() > 0){
            res[stack.pop()] = arr.length;
        }

        return res;
    }
}
