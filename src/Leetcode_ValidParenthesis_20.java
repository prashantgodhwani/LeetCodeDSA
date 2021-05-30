import java.util.Stack;

public class Leetcode_ValidParenthesis_20 {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char ch : chars){
            switch (ch){
                case '(' :
                case '[' :
                case '{' :
                    stack.push(ch);
                    break;

                case ')' :
                    if(stack.size() > 0 && stack.peek() == '(')
                        stack.pop();
                    else return false;
                    break;
                case ']' :
                    if(stack.size() > 0 && stack.peek() == '[')
                        stack.pop();
                    else return false;
                    break;
                case '}' :
                    if(stack.size() > 0 && stack.peek() == '{')
                        stack.pop();
                    else return false;
                    break;
            }
        }

        return (stack.size() == 0);

    }
}
