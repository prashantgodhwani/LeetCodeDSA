package June_Challenge;

import java.util.Arrays;

public class Leetcode_InterleavingString_02June_97 {

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }

    public static boolean isInterleave(String s1, String s2, String s3, int s1p, int s2p, int s3p, int last, String asf) {
        if(s3p == s3.length()){
            if(s1p == s1.length() && s2p == s2.length()) {
                System.out.println("************" + asf);
                return true;
            }
            return false;
        }

        //last string was 2 : now send 1
        boolean res = false;
        if(last == 2){
            for(int i = s1p + 1; i <= s1.length(); i++){
                String tmp = s1.substring(s1p, i);
//                asf += tmp;
                if(tmp.equals(s3.substring(s3p, s3p + tmp.length()))) {
                    res = res || isInterleave(s1, s2, s3, i, s2p, s3p + tmp.length(), 1, asf + tmp);
//                    asf = asf.substring(0, tmp.length());
                }else return res;
            }
        }
        else{
            for(int i = s2p + 1; i <= s2.length(); i++){
                String tmp = s2.substring(s2p, i);
//                asf += s2.charAt(i);
//                System.out.println(asf + " " + s3.charAt(s3p));
                if(tmp.equals(s3.substring(s3p, s3p + tmp.length()))) {
                    res = res || isInterleave(s1, s2, s3, s1p, i, s3p + tmp.length(), 2, asf + tmp);
//                    asf = asf.substring(0, tmp.length());
                }else return res;
            }
        }

        return res;
    }

    public static boolean isInterleave(String s1, String s2, String s3) {

        if(s1.equals("")){
            return s3.equals(s2);
        }else if(s2.equals("")){
            return s3.equals(s1);
        }

        if(s1.length() + s2.length() != s3.length()) return false;

        Boolean[][][] dp = new Boolean[2][s1.length() + 1][s2.length() + 1];
        boolean res = isInterleaveUtil(s1, s2, s3, 0, 0, 0, 2, dp);
        res = res || isInterleaveUtil(s1, s2, s3, 0, 0, 0, 1, dp);
        return res;
    }

    public static boolean isInterleaveUtil(String s1, String s2, String s3, int s1p, int s2p, int s3p, int last, Boolean[][][] dp) {
        if(s3p == s3.length()){
            if(s1p == s1.length() && s2p == s2.length()) {
                return dp[last - 1][s1p][s2p] = true;
            }
            return dp[last - 1][s1p][s2p] = false;
        }

        if(null != dp[last - 1][s1p][s2p]) return dp[last - 1][s1p][s2p];

        //last string was 2 : now send 1
        boolean res = false;
        if(last == 2){
            for(int i = s1p + 1; i <= s1.length(); i++){
                String tmp = s1.substring(s1p, i);
                int len = tmp.length();
                if(s3p + len <= s3.length() && tmp.equals(s3.substring(s3p, s3p + len))) {
                    res = isInterleaveUtil(s1, s2, s3, i, s2p, s3p + len, 1, dp);
                    if(res) return res;
                }
            }
        }
        else{
            for(int i = s2p + 1; i <= s2.length(); i++){
                String tmp = s2.substring(s2p, i);
                int len = tmp.length();
                if(s3p + len <= s3.length() && tmp.equals(s3.substring(s3p, s3p + len))) {
                    res = isInterleaveUtil(s1, s2, s3, s1p, i, s3p + len, 2, dp);
                    if(res) return res;
                }
            }
        }

        return dp[last - 1][s1p][s2p] = res;
    }
}
