import java.util.Stack;

public class Leetcode_RemoveAllAdjacentDuplicatesInString2_1209 {

    public static void main(String[] args) {
        String res = removeDuplicates(
                "yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4);
        System.out.println(res);
    }

    public static String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        int[] map = new int[26];

        for(char ch : s.toCharArray()){
            System.out.println("evaluating " + ch + " ..." + map[ch - 'a']);
            if(stack.size() == 0 || stack.peek()[0] != ch - 'a'){
                int[] el = {ch - 'a', 1};
                stack.push(el);
                map[ch - 'a']++;
            }else{
                int[] tos = stack.pop();
                if(tos[1] < k - 1){
                    tos[1]++;
                    stack.push(tos);
                }
            }

            System.out.println(stack);
        }

        StringBuilder res = new StringBuilder();
        while(stack.size() > 0){
            int[] el = stack.pop();
            int times = el[1];
            while(times > 0) {
                res.append((char) (el[0] + 'a'));
                times--;
            }
        }

        return res.reverse().toString();
    }
}
