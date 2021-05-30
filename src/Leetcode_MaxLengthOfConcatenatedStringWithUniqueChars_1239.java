import java.util.ArrayList;
import java.util.List;

public class Leetcode_MaxLengthOfConcatenatedStringWithUniqueChars_1239 {
    public static void main(String[] args) {

        System.out.println(checkIfUnique("", "aaaaa"));
        List<String> q = new ArrayList<>();
        q.add("uq");
        q.add("iq");
        q.add("ue");
        List<String> res = new ArrayList<>();
        int r = printSubsequences(q, 0, res, "", q.size(), 0);
        int size = 0;
        for(String s : res){
            if(s.length() > size) size = s.length();
        }
        System.out.println(r);
        System.out.println(size);
    }

    public static int printSubsequences(List<String> arr, int idx, List<String> ss, String ans, int size, int max){

        for(int i = idx; i < size; i++){
            String s = arr.get(i);
            if(checkIfUnique(ans, s)) {
                String str = ans + s;
                if(max < str.length()) max = str.length();
                ss.add(str);
                max = printSubsequences(arr, i + 1, ss, ans + s, size, max);
            }
        }

        return max;
    }

    private static boolean checkIfUnique(String s1, String s2) {
        int[] arr = new int[26];
        int[] arr2 = new int[26];
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        for(char ch : ch1){
            if(arr[ch - 'a'] > 0) return false;
            else arr[ch-'a'] = 1;
        }

        for(char ch : ch2){
            if(arr2[ch - 'a'] > 0) return false;
            else arr2[ch-'a'] = 1;
        }

        for(char ch : ch2){
            if(arr[ch-'a'] > 0) return false;
        }

        return true;
    }
}
