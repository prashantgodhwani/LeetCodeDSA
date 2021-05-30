import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_PalindromePartioning_131 {

    public static void main(String[] args) {
        List<List<String>> finalRes = new ArrayList<>();
        partition("aab", "", 0, 0, finalRes, new ArrayList<>());
        System.out.println(finalRes);
    }

    public static void partition(String s, String asf, int start, int end, List<List<String>> res, List<String> nS){

        if(end == s.length()){
            res.add(new ArrayList<>(nS));
            return;
        }


        for(int i = 1; i <= s.length() && end + i <= s.length(); i++){
            String str = s.substring(start, end+i);
            if(isPalindrome(str)) {
                nS.add(str);
                partition(s, asf, start + i, end + i, res, nS);
                nS.remove(nS.size() - 1);
            }
        }

    }

    public static void partitionIterative(String s) {

        List<List<String>> finalRes = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            List<String> res = new ArrayList<>();
            for(int j = i+1; j <= s.length(); j++){
                if(isPalindrome(s.substring(i, j)))  res.add(s.substring(i, j));
            }
            finalRes.add(res);
        }

        System.out.println(finalRes);
    }

    private static boolean isPalindrome(String res) {
        if(res.length() == 1) return true;
        else{
            int i = 0, j = res.length() - 1;
            while(i < j){
                if(res.charAt(i) == res.charAt(j)){
                    i++; j--;
                }else return false;
            }
            return true;
        }
    }
}
