package June_Challenge;

import java.util.*;

public class Leetcode_NumberOfMatchingSubsequences_22June {

    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a","bb","acd","ace"};
        System.out.println(numMatchingSubseq3_mostOptimized(s, words));
//        Map<Character, Integer> map = new HashMap<>();
//        char[] chars = s.toCharArray();
//
//        for (int i = 0; i < chars.length; i++) {
//            if (!map.containsKey(chars[i])) map.put(chars[i], i);
//        }
//        int count = 0;
//        HashMap<Character, ArrayList<String>> dp = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//            if (map.containsKey(words[i].charAt(0))) {
//                Character ch = words[i].charAt(0);
//                System.out.println("checking for word = " + words[i]);
//                if (dp.containsKey(ch)) {
//                    if (findIfStringPresent(dp.get(ch), words[i])) count++;
//                } else {
//                    ArrayList<String> tempDp = new ArrayList<>();
//                    boolean found = numMatchingSubseq(s, "", map.get(ch), tempDp, map.get(ch), words[i]);
//                    dp.put(ch, tempDp);
//                    if (found) count++;
//                }
//            }
//        }

//        System.out.println(dp);
//        System.out.println(count);
    }

    private static boolean findIfStringPresent(ArrayList<String> strings, String word) {
        System.out.println(strings + " and " + word);
        for (String w : strings) {
            if (w.equals(word)) return true;
        }
        return false;
    }

    public static boolean numMatchingSubseq(String s, String asf, Integer idx, ArrayList<String> dp, int org, String word) {
        if (idx == s.length()) {
            dp.add(asf);
            if (word.equals(asf)) return true;
            return false;
        }

        boolean res = false;
        res = res | numMatchingSubseq(s, asf + s.charAt(idx), idx + 1, dp, org, word);
        if (idx > org) res = res | numMatchingSubseq(s, asf, idx + 1, dp, org, word);
        return res;
    }
    /*
     * 1) Find positions of all characters of string
     * 2) The information is store in an array like "abacbca" ---> POS = ['a', 'b', 'c'] = [ [0,2,6], [1,4], [3,5] ]
     * 3) pos[0] contains indexes in the string where 'a' is present, pos[2] contains indexes where c is present in String
     * 4) while iterating words, for each character of each word, we check if we can choose a position from POS, and the position must follow an increasing order.
          For example: word = "acb"
          * 'a' we choose 0
          * 'c' we choose 3
          * 'b' we choose 4
          * [0,3,4] is an increasing order, so "acb" is a subsequence of our input.
     * 5) We use modified binary Search to do the following
     *      return the element if present
     *      return the next greater value if value is not present
     */
    public static int numMatchingSubseq2(String s, String[] words) {
        int count = 0;
        ArrayList<Integer>[] pos = findPositions(s);

        int prevIdx;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            int k = 0;
            prevIdx = -1;
            while (k < word.length()) {
                char sw = word.charAt(k);
                prevIdx = search(pos[sw - 'a'], prevIdx);
                if (prevIdx == -1) {
                    break;
                }
                k++;
                prevIdx++;
            }
            if (prevIdx != -1){
                count++;
                System.out.println("for word = " + word + ", count = " + count);
            }
        }
        return count;
    }

    public static ArrayList<Integer>[] findPositions(String s) {
        ArrayList<Integer>[] pos = new ArrayList[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pos[ch - 'a'] == null) pos[ch - 'a'] = new ArrayList<>();
            pos[ch - 'a'].add(i);
        }

        return pos;

    }

    private static int search(List<Integer> ns, int n) {
        System.out.println("ns = " + ns + ", n = " + n);
        if (ns == null) return -1;
        int lo = 0, hi = ns.size() - 1;
        if (ns.get(lo) >= n) return ns.get(lo);
        if (ns.get(hi) < n) return -1;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (ns.get(mi) == n) return ns.get(mi);
            if (ns.get(mi) < n) lo = mi + 1;
            else hi = mi;
        }
        return ns.get(hi);
    }

    /*
     * 1) Create a Hashmap with <Char, List<String>>
     * 2) Store the words in the hashmap based on their first character
     * 3) traverse the given string character by character and remove the occurred character from the string and store under new <Character>
     * 4) if the given word become "" then the word is a subset of the given string - increment the count by 1
     * 5) return count;
     */
    public static int numMatchingSubseq3_mostOptimized(String s, String[] words){
        Map<Character, Queue<String>> map = new HashMap<>();
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            map.putIfAbsent(ch, new LinkedList<>());
        }

        for(String word : words){
            if(map.containsKey(word.charAt(0))){
                map.get(word.charAt(0)).offer(word);
            }
        }

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            Queue<String> q = map.get(ch);
            int size = q.size();
            while(size > 0){
                String str = q.poll();
                size--;
                String nStr = str.substring(1);
                if(nStr.length() == 0){
                    count++;
                }else{
                    if(map.containsKey(nStr.charAt(0)))
                        map.get(nStr.charAt(0)).offer(nStr);
                }
            }

        }

        return count;
    }

}
