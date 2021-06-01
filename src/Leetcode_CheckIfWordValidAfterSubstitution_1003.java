import java.util.Stack;

public class Leetcode_CheckIfWordValidAfterSubstitution_1003 {

    public static void main(String[] args) {
        boolean res = isValid("cababc");
        System.out.println(res);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == 'a' || ch == 'b'){
                stack.push(ch);
            }
            else{
                if(stack.size() == 0) return false;
                char sec = stack.pop();
                if(stack.size() == 0) return false;
                char fir = stack.peek();
                String ss = String.valueOf(new char[]{fir, sec, ch});
                if(ss.equals("abc")){
                    stack.pop();
                }else{
                    stack.push(sec);
                    stack.push(ch);
                }
            }
        }

        return (stack.size() == 0);

    }
}
