import java.util.ArrayList;
import java.util.List;

public class Leetcode_KthLexicographicStringHappy_1415 {

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        int k = 7;
        printLexicograohicHappyString("abc", "abc", new StringBuilder(), 2, res);
        System.out.println(res);
        if(res.size() == 0 || res.size() <= k-1) System.out.println("");
        else System.out.println(res.size() <= k ? res.get(k-1) : "");
    }

    private static void printLexicograohicHappyString(String s, String qsf, StringBuilder asf, int n, List<String> res){
        if(n == asf.length()){
            res.add(asf.toString());
            return;
        }

        for(int i = 0; i < qsf.length(); i++) {
            int st = s.indexOf(qsf.charAt(i));
            String q = s.substring(0, st) + s.substring(st + 1);
            printLexicograohicHappyString(s, q, asf.append(qsf.charAt(i)), n, res);
            asf.setLength(asf.length() - 1);
        }
    }
}
