import java.util.Arrays;
import java.util.Stack;

public class Leetcode_RemoveAllAdjacentDuplicate_1047 {

    public static void main(String[] args) {
        String res = removeDuplicates2("abbaca");
        System.out.println(res);
    }

    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(stack.size() > 0 && stack.peek() == ch){
                stack.pop();
            }else stack.push(ch);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(stack.size() > 0){
            stringBuilder.insert(0, stack.pop());
        }

        return stringBuilder.toString();
    }

    public static String removeDuplicates2(String s) {
        char[] stack = new char[s.length()];
        int tos = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(tos == 0) stack[tos++] = ch;

            else if(tos > 0){
                if(stack[tos - 1] != ch){
                    stack[tos++] = ch;
                }else{
                    --tos;
                }
            }

            System.out.println(Arrays.toString(stack));

        }

        return new String(stack, 0, tos);
    }
}
