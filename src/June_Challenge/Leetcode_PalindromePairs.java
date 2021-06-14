package June_Challenge;

import java.util.*;

public class Leetcode_PalindromePairs {

    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> finalRes = new ArrayList<>();
        palindromePairs(words,  0, 0, new LinkedList<>(), finalRes);
        System.out.println(finalRes);
    }

    public static void palindromePairs(String[] words, int len, int idx, LinkedList<Integer> lst, List<List<Integer>> finalRes) {
        if(len == 2){
            System.out.println(lst);
            ArrayList<Integer> bres = new ArrayList<>();
            if(checkPalindrome(words[lst.get(0)] + words[lst.get(1)])) {
                bres.add(lst.get(0));
                bres.add(lst.get(1));
                finalRes.add(bres);
            }
            bres = new ArrayList<>();
            if(checkPalindrome(words[lst.get(1)] + words[lst.get(0)])) {
                bres.add(lst.get(1));
                bres.add(lst.get(0));
                finalRes.add(bres);
            }
            return;
        }

        for(int i = idx; i < words.length; i++){
            lst.add(i);
            palindromePairs(words, len + 1, i + 1, lst, finalRes);
            lst.removeLast();
        }
    }
    
    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> finalRes = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        //empty String
        if (map.containsKey("")) {
            int eidx = map.get("");
            for (String s : map.keySet()) {
                if (!s.equals("") && checkPalindrome(s)) {
                    finalRes.add(Arrays.asList(map.get(s), eidx));
                    finalRes.add(Arrays.asList(eidx, map.get(s)));
                }
            }
        }

        //relection
        for (int i = 0; i < words.length; i++) {
            String rev = new StringBuilder(words[i]).reverse().toString();
            if (map.containsKey(rev) && map.get(rev) != i) {
                finalRes.add(Arrays.asList(i, map.get(rev)));
            }
        }

        //tricky case
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            for (int j = 1; j < curr.length(); j++) {
                String left = curr.substring(0, j);
                String right = curr.substring(j);
                if(checkPalindrome(left)){
                    String revRight = new StringBuilder(right).reverse().toString();
                    if(map.containsKey(revRight)){
                        finalRes.add(Arrays.asList(i, map.get(revRight)));
                    }
                }

                if(checkPalindrome(right)){
                    String revLeft = new StringBuilder(left).reverse().toString();
                    if(map.containsKey(revLeft)){
                        finalRes.add(Arrays.asList(i, map.get(revLeft)));
                    }
                }
            }
        }

        return finalRes;
    }

    private static boolean checkPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++; right--;
        }

        return true;
    }
}
