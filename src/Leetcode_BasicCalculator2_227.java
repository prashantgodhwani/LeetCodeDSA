import java.util.Stack;

public class Leetcode_BasicCalculator2_227 {

    public static void main(String[] args) {
//        int res = basicCalculator("1*2-3/4+5*6-7*8+9/10");
        int ress = basicCalculator_optimized(" 3+5 / 2 ");
//        System.out.println(res);
        System.out.println(ress);
    }

    public static int basicCalculator(String exp){
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        char[] chars = exp.toCharArray();

        for(int i = 0; i < chars.length; i++){
            char ch = chars[i];

            if(ch == ' ') continue;

            /*
             * NUMBER
             * input the entire number
             */
            if(ch >= '0' && ch <= '9'){
                int num = ch - '0';
                while(i + 1 < exp.length() && exp.charAt(i + 1) >= '0' && exp.charAt(i + 1) <= '9'){
                    num = num * 10 + exp.charAt(i + 1) - '0';
                    i++;
                }
                numStack.add(num);
            }
            /*
             * OPERATION
             * check priority and perform operation
             */
            else{

                if(opStack.size() == 0 || opPriority(ch) > opPriority(opStack.peek())){
                    opStack.push(ch);
                }else{
                    while(opStack.size() > 0 && opPriority(ch) <= opPriority(opStack.peek())) {
                        int two = numStack.pop();
                        int one = numStack.pop();
                        int res = performOp(one, two, opStack.pop());
                        numStack.push(res);
                    }
                    opStack.push(ch);

                }
            }

            System.out.println(numStack);
        }

        int res = opHelper(numStack, opStack);
        return res;
    }

    public static int opHelper(Stack<Integer> numStack, Stack<Character> opStack){
        while(opStack.size() > 0){
            int two = numStack.pop();
            int one = numStack.pop();
            int res = performOp(one, two, opStack.pop());
            numStack.push(res);
            System.out.println(numStack);
        }

        return numStack.pop();
    }

    public static int opPriority(char op){
        switch (op){
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    public static int performOp(int n1, int n2, char op){
        System.out.println("performing " + op + " on " + n1 +" and " + n2);
        switch (op){
            case '*':
                return n1 * n2;
            case '/':
                return n1 / n2;
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            default:
                return 0;
        }
    }

    /*
     * The way we are traversing is that whenever we encounter an
     * operation, we do these things
     * if operation is +/-, it means that a more priority operation can come
     *      in such case we simply add the number with the sign in Stack
     * However if the operation is *\divide, it means that we have the
     *      operation with higher priority. So we pop the last element from
     *      stack and operate it with current number and push it.
     * In case of 1*2-3. When we are at (-), then we store the result of 1*2 in stack
     */
    public static int basicCalculator_optimized(String exp){
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);


            if(Character.isDigit(ch)){
                currentNumber = currentNumber * 10 + ch - '0';
            }

            if(!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == exp.length() - 1) {

                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }

                operation = ch;
                currentNumber = 0;
            }

            System.out.println(stack);
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static int basicCalculator_optimized2(String exp){
        int currentNumber = 0;
        char operation = '+';
        int lastNumber = 0, result = 0;

        for(int i = 0; i < exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch == ' ') continue;

            if(Character.isDigit(ch)){
                currentNumber = currentNumber * 10 + ch - '0';
            }

            if(!Character.isDigit(ch) || i == exp.length() - 1) {

                if (operation == '+') {
                    result += lastNumber;
                    lastNumber = currentNumber;
                } else if (operation == '-') {
                    result += lastNumber;
                    lastNumber = -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }

                operation = ch;
                currentNumber = 0;
            }
        }

      return result;
    }
}
