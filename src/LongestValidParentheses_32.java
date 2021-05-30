import java.util.Stack;

public class LongestValidParentheses_32 {

    public static void main(String[] args) {
        //)()()())
        System.out.println(longestValidParentheses("())"));
    }

    public static int longestValidParentheses(String s) {
        Stack<String> characterStack = new Stack<>();
        int count = 0;

        for(char c : s.toCharArray()){
            if(characterStack.size() > 0 && characterStack.lastElement().contains("(") && c == ')'){
                characterStack.pop();
                count+=2;
            }
            else{
                characterStack.push(""+c + count);
            }
            System.out.println(characterStack);
            System.out.println(count);
        }

        return (characterStack.size() > 0 && (Integer.parseInt(characterStack.lastElement().substring(1))) != 0) ?
                ((Integer.parseInt(characterStack.lastElement().substring(1))==s.length() - 1) ?
                        Integer.parseInt(characterStack.lastElement().substring(1)) - 1 :
                        Integer.parseInt(characterStack.lastElement().substring(1))):
                count;
    }
}
