import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_PalindromicSubsequences_647 {

    public static void main(String[] args) {
        String s = "dbabcccbcdbbbadabbdabaabcbbabaacdadcdbbbbdddbcbbbcbcabacacdaadaadcdccbacdaadadcbaacabbddabdadcabbccadacadaaacbbddaaababacaabbbacaccbcbbabddbbcccaaacbcdcabcbacdbddcdcadaaadcbccbbcabbcbdaadcbddaacacdadacbbdabcdcdadccaccdbdddddcabdbcdbaadacadadbabdcdbbadaacdbadcdabdbbcabbbdaacaaaaadcaabaaaadabaaddcaabdddcbcadcbdbbdbcbcdbadcadacbbcdccddaccccacbacaacbbdadadcacabdabadbbcdbcaaccdbdcabcadbacbccddbabbdacbcbbcbcabcacdaacccaadcdbdccabcaaacaddadcabacdccaaaddaaadbccdbbcccdddababcdbcddcbdddbbbdaadaccbcaabbcbdbadbabbacdbbbdaaccdcabddacadabcccacdabacbcdbcbdabddacacbdbcaacacaabbaaccddabaadbbaabaddbcacbacdbbbacdccabbcdbbbdbdbbcacabdddbdbaaabbcdcbabcbbbccdcdcdcaaddadccbabbacaddcaddcadcdccaccacabbaababdbbcbdcdccccccdadbdbdcdbdadcdcacdaabaacabaacdacdbaaccadbcddbdccabbcabcadcbdadbcdadbbbccacbcbbcaaaabdacbadacaadcadaacdacddcbbabdacacaabccdaccbbcbbcbcaacdabdcbcdbccdbcbcbddaacdacaaaddcaddcadccacbaddbbbccbbbcbbcbadcabbccbbaadaacacabddbdbddcadbdaaccadbcccabdcdbadbbacbcbbcdcabcddcddddabddbdabdcabdbdbbbcdbcdabbdcb";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = countSubstrings_dp(s, dp);
        System.out.println(res);
    }

    public static int countSubstrings_memo(String s, Boolean[][] dp) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(isPalindrome(s, dp, i, j)){
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isPalindrome(String s, Boolean[][] dp, int i, int j){
        if(i == j) return true;

        if(dp[i][j] != null) return dp[i][j];

        boolean b = s.charAt(i) == s.charAt(j);

        if(i + 1 == j){
            return dp[i][j] = b;
        }

        if(b){
            return isPalindrome(s, dp, ++i, --j);
        }

        return false;
    }

    public static int countSubstrings_dp(String s, boolean[][] dp) {
        int count = 0;
        for(int g = 0; g < s.length(); g++){
            for(int i = 0, j = g; j < dp.length; i++, j++){
                if(g == 0){
                    dp[i][j] = true;
                }
                else if(g == 1){
                     dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else{
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            if(dp[i][j]) count++;
            }

        }

        return count;
    }

}
