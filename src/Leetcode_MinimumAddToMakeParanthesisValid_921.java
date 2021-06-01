import java.util.Stack;

public class Leetcode_MinimumAddToMakeParanthesisValid_921 {

    public static void main(String[] args) {
        int res = minAddToMakeValid2(
                "((())");
        System.out.println(res);
    }

    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int res = 0;

        for(char ch : s.toCharArray()){
            if(stack.size() == 0){
                stack.push(ch);
                res++;
            }else{
                if(ch == ')'){
                    if(stack.peek() == '('){
                        stack.pop();
                        res--;
                    }
                    else{
                        stack.push(ch);
                        res++;
                    }
                }else{
                    stack.push(ch);
                    res++;
                }
            }
        }

        return res;
    }

    public static int minAddToMakeValid2(String s) {
        int res = 0, left = 0, right = 0;

        for(int i = 0; i < s.length(); i++){
            int ch = s.charAt(i);
            if(i == 0) {
                if ((ch == '(')) {
                    left++;
                } else {
                    right++;
                }
            }else{
                if(ch == '(') left++;
                else{
                    if(left > 0) left--;
                    else right++;
                }
            }
            System.out.println(left + " : " + right);

        }

        return left + right;
    }
}
