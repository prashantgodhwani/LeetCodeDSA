import java.util.Stack;

public class Leetcode_MinimumInsertionsToBalanceParanthesis_1541 {

    public static void main(String[] args) {
        int res = minInsertions("))(()()))()))))))()())()(())()))))()())(()())))()("
        );
        System.out.println(res);
    }

    public static int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0, endCount = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            System.out.println("ch = " + i);
            if(ch == '('){
                stack.push(ch);
            }else{
                if(i + 1 < s.length() && s.charAt(i + 1) == ch){
                    if(stack.size() > 0 && stack.peek() == '('){
                        stack.pop();
                        i++;
                    }else{
                        count += 1;
                        i++;
                    }
                }else{
                    if(stack.size() > 0 && stack.peek() == '('){
                        stack.pop();
                        count++;
                    }else{
                        count += 2;
                    }
                }
            }

            System.out.println(stack + ", count = " +count);
        }
        System.out.println("" + stack);

        while(stack.size() != 0){
            char ch = stack.pop();
            if(ch == '(' && endCount == 0){ // (
                count += 2;
                System.out.println("..");
            }else if(ch == '(' && endCount == 1){ // ()
                endCount = 0;
                count += 1;
                System.out.println("....");
            }else if(ch == ')' && endCount == 2){ // ))
                endCount = 0;
                count += 1;
                System.out.println("......");
            }
            else if(ch == ')' && endCount == 1){ // ))
                endCount = 0;
                count += 1;
                System.out.println(".........");
            }
            else if(ch == ')' && stack.size() == 0){
                count += 2;
                endCount = 0;
                System.out.println("..............");
            }
            else{
                endCount += 1;
            }
            System.out.println("ch = " + ch + ", count = " + count);
        }

        return count;
    }
}
