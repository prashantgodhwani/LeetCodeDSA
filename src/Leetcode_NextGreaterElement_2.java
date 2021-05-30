import java.util.Arrays;
import java.util.Stack;

public class Leetcode_NextGreaterElement_2 {

    public static void main(String[] args) {
        int[] arr= {0, -2, -3};
        nextGreaterElementToRight(arr);
    }

    private static int[] nextGreaterElementToRight(int[] arr){
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        int[] res = new int[arr.length];
        Arrays.fill(res, Integer.MIN_VALUE);

        for(int i = 1, j = 1; i < 2 * arr.length; i++, j++){

            j = j % arr.length;
            System.out.println("i = " + i + ", j = " + j);

            while(stack.size() > 0 && arr[stack.peek()] < arr[j]){
                res[stack.pop()] = arr[j];
            }
            stack.push(j);
        }

        System.out.println(Arrays.toString(res));
        System.out.println(stack);

        while(stack.size() > 0){
            if(res[stack.peek()] == Integer.MIN_VALUE) {
                res[stack.pop()] = -1;
            }else{
                stack.pop();
            }
        }

        System.out.println(Arrays.toString(res));
        return res;
    }
}
