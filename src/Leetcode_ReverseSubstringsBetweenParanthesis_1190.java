import java.util.Stack;

public class Leetcode_ReverseSubstringsBetweenParanthesis_1190 {

    public static void main(String[] args) {
        String res = reverse(  "a(bcdefghijkl(mno)p)q");
        System.out.println(res);
    }

    public static String reverse(String exp){
        Stack<String> stack = new Stack<>();
        StringBuilder ss = new StringBuilder();

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == ')'){
                if(ss.length() > 0){
                    stack.push(ss.toString());
                    ss.setLength(0);
                }
                StringBuilder s = new StringBuilder();
                while(stack.size() > 0 && !stack.peek().equals("(")){
                    s.append(new StringBuilder(stack.pop()).reverse());
                }
                stack.pop();
                stack.push(s.toString());
            }
            else{

                if(ch == '('){
                    if(ss.length() > 0) {
                        stack.push(ss.toString());
                        ss.setLength(0);
                    }
                    stack.push("(");
                }else{
                    ss.append(ch);
                }
            }

        }

        if(ss.length() > 0){
            stack.push(ss.toString());
            ss.setLength(0);
        }

        StringBuilder res = new StringBuilder();

        while(stack.size() > 0){
            res.insert(0, stack.pop());
        }

        return res.toString();
    }
}
