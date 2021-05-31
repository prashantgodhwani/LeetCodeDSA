import java.util.Stack;

public class Leetcode_CrawlerLogFolder_1598 {

    public static void main(String[] args) {
        String[] logs = {"d1/","d2/","../","d21/","./"};
        int res = minOperations_withoutStack(logs);
        System.out.println(res);
    }

    public static int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();

        for(String log : logs){
            if(log.equals("./")){
                continue;
            }

            else if(log.equals("../")){
                if(stack.size() > 0){
                    stack.pop();
                }
            }

            else{
                stack.push(log);
            }
        }

        int count = 0;
        while(stack.size() > 0){
            stack.pop();
            count++;
        }

        System.out.println(count);

        return count;
    }

    public static int minOperations_withoutStack(String[] logs) {
        int count = 0;

        for(String log : logs){
            if(log.equals("./")){
                continue;
            }

            else if(log.equals("../")){
                if(count > 0){
                    count--;
                }
            }

            else{
                count++;
            }
        }

        return count;
    }
}
