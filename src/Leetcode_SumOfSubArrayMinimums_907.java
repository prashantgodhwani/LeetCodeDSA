import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Leetcode_SumOfSubArrayMinimums_907 {

    public static void main(String[] args) {
        int[] arr = {11,81,94,43,3};
        int res = sumSubarrayMins(arr);
        System.out.println(res);
    }

    public static int sumSubarrayMins(int[] arr) {
        int[] mol = getMOL(arr);
        int[] mor = getMOR(arr);
        int count = 0;

        System.out.println(Arrays.toString(mol));
        System.out.println(Arrays.toString(mor));

        for(int i = 0; i < arr.length; i++){
            int leftCount = (i - mol[i]);
            int rightCount = mor[i] - i;
            System.out.println(leftCount + ", " + rightCount);
            count += arr[i] * (leftCount * rightCount);
        }

        return count;
    }

    private static int[] getMOL(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] mol = new int[arr.length];
        //mor
        stack.push(0);
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] > arr[stack.peek()]){
                stack.push(i);
            }else{
                while(stack.size() > 0 && arr[stack.peek()] > arr[i]){
                    mol[stack.pop()] = i;
                }
                stack.push(i);
            }
        }
        while(stack.size() > 0){
            mol[stack.pop()] = -1;
        }

        return mol;
    }

    private static int[] getMOR(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] mor = new int[arr.length];
        //mor
        stack.push(0);
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[stack.peek()]){
                stack.push(i);
            }else{
                while(stack.size() > 0 && arr[stack.peek()] > arr[i]){
                    mor[stack.pop()] = i;
                }
                stack.push(i);
            }
        }
        while(stack.size() > 0){
            mor[stack.pop()] = arr.length;
        }

        System.out.println(Arrays.toString(mor));
        return mor;
    }
}
