import java.util.Arrays;
import java.util.Stack;

public class Leetcode_DailyTemperatures_739 {

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperatures(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] dailyTemperatures(int[] arr){
       int[] nextGreaterIndexArr = nextGreaterElementToRight(arr);

       for(int i = 0; i < nextGreaterIndexArr.length; i++){
           nextGreaterIndexArr[i] = nextGreaterIndexArr[i] - i;
       }

       return nextGreaterIndexArr;
    }

    private static int[] nextGreaterElementToRight(int[] arr){
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        int[] res = new int[arr.length];

        for(int i = 1; i < arr.length; i++){
            while(stack.size() > 0 && arr[stack.peek()] < arr[i]){
                res[stack.pop()] = i;
            }
            stack.push(i);
        }

        while(stack.size() > 0){
            int idx = stack.peek();
            res[stack.pop()] = idx;
        }

        return res;
    }
}
