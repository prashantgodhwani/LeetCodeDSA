import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_WordBreak_139 {

    public static void main(String[] args) {
        String s = "bccdbacdbdacddabbaaaadababadad";
        List<String> dict = List.of("cbc","bcda","adb","ddca","bad","bbb","dad","dac","ba","aa","bd","abab","bb","dbda","cb","caccc","d","dd","aadb","cc","b","bcc","bcd","cd","cbca","bbd","ddd","dabb","ab","acd","a","bbcc","cdcbd","cada","dbca","ac","abacd","cba","cdb","dbac","aada","cdcda","cdc","dbc","dbcb","bdb","ddbdd","cadaa","ddbc","babb");
        Map<String, Boolean> dp = new HashMap<>();
        boolean res = wordBreak(s, dict, "", dp);
        System.out.println(res);
    }

    public static boolean wordBreak(String s, List<String> wordDict, String asf, Map<String, Boolean> dp) {
        System.out.println(asf);
        if(asf.length() == s.length()) {
                return true;
        }

        if(dp.containsKey(asf)) return dp.get(asf);

        boolean res = false;
        for(int i = 0; i < wordDict.size(); i++){
            String newAsf = (asf + wordDict.get(i));
            if((asf + wordDict.get(i)).length() <= s.length() && s.startsWith(newAsf))
                res = res | wordBreak(s, wordDict, newAsf, dp);
        }

        dp.put(asf, res);
        return res;
    }
}
