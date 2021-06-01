import java.util.Stack;

public class Leetcode_BaseballGame_682 {

    public static void main(String[] args) {
        int res = calPoints(new String[]{"5","2","C","D","+"});
        System.out.println(res);
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for(String op : ops){
            if(op.equals("C")){
                stack.pop();
            }
            else if(op.equals("D")){
                stack.push(2 * stack.peek());
            }
            else if(op.equals("+")){
                int f = stack.pop();
                int s = stack.peek();
                stack.push(f);
                stack.push(f + s);
            }
            else{
                stack.push(Integer.parseInt(op));
            }
        }

        int score = 0;
        while(stack.size() != 0){
            score += stack.pop();
        }

        return score;
    }
}
