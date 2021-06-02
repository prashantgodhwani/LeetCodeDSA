import java.util.Stack;

public class Leetcode_ValidateStackSequences_946 {

    public static void main(String[] args) {
        int[] pushed = {2,1,0};
        int[] popped = {1,2,0};
        boolean res = validateStackSequences(pushed, popped);
        System.out.println(res);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int idxPushed = 0, idxPopped = 0;

        while(idxPopped != popped.length && idxPushed != pushed.length) {

            while (idxPushed < pushed.length && pushed[idxPushed] != popped[idxPopped]) {
                stack.push(pushed[idxPushed]);
                idxPushed++;
            }

            if(idxPushed < pushed.length) stack.push(pushed[idxPushed++]);

            while (stack.size() > 0 && stack.peek() == popped[idxPopped]) {
                stack.pop();
                idxPopped++;
            }

        }

        while(idxPopped != popped.length){
            if(stack.pop() != popped[idxPopped]) return false;
            idxPopped++;
        }
        return (stack.size() == 0);
    }
}
