import java.util.Stack;

public class Leetcode_RemoveOutermostParantheses_1021 {

    public static void main(String[] args) {

        String res = removeOuterParentheses("(()())(())(()(()))");
        System.out.println(res);
    }

    public static String removeOuterParentheses(String s) {
       StringBuilder res = new StringBuilder();
       int depth = 0;

       for(char ch : s.toCharArray()){
           if(ch == '('){
               if(depth  > 0){
                   res.append(ch);
               }
               depth++;
           }else{
               depth--;
               if(depth > 0){
                   res.append(ch);
               }
           }
       }

       return res.toString();
    }
}
