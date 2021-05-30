import java.util.ArrayList;
import java.util.List;

public class Leetcode_LetterCasePermutation_784 {

    public static void main(String[] args) {
        System.out.println((int)'a');
        List<String> finalRes = new ArrayList<>();
        letterCasePermutation("a1b2".toLowerCase(), finalRes, 0,"", "a1b2".length());
        System.out.println(finalRes);
    }

    public static void letterCasePermutation(String S, List<String> finalRes, int idx, String asf, int len) {
        if(idx == len){
            finalRes.add(asf);
            return;
        }

        char ch = S.charAt(idx);
        letterCasePermutation(S, finalRes, idx +1, asf + ch, len);
        if(ch >= 48 && ch <= 57){
            return;
        } else{
            ch = (char)(ch - 32);
        }
        letterCasePermutation(S, finalRes, idx +1, asf + ch, len);
    }
}
