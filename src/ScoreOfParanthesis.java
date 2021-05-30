import java.util.Stack;

public class ScoreOfParanthesis {

    public static void main(String[] args) {
        int res = scoreOfParentheses2_optimised("(()(()))");
        System.out.println(res);
    }

    public static int scoreOfParentheses(String s) {
        Stack<String> stack = new Stack<>();
        int count = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch + "");
            } else {
                if (ch == ')') {
                    if (stack.peek().equals("(")) {
                        stack.pop();
                        stack.push("1");
                    } else {
                        int n = Integer.parseInt(stack.pop());
                        int sec = 0;
                        while (stack.size() > 0 && !stack.peek().equals("(")) {
                            sec += Integer.parseInt(stack.pop());
                        }
                        stack.pop();
                        stack.push(2 * (n + sec) + "");
                    }
                }
            }

        }

        while (stack.size() != 0) {
            count += Integer.parseInt(stack.pop());
        }
        return count;
    }

    public static int scoreOfParentheses2_optimised(String s) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(0);
            } else {
                if (stack.peek() == 0) {
                    stack.pop();
                    stack.push(1);
                } else {
                    int n = 0;
                    while (stack.peek() != 0) {
                        n += stack.pop();
                    }
                    stack.pop();
                    stack.push(2 * n);
                }
            }
            System.out.println(stack);

        }
        while (stack.size() != 0) {
            count += stack.pop();
        }

        return count;

    }
}
