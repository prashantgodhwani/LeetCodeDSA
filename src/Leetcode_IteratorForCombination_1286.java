import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Leetcode_IteratorForCombination_1286 {
    public static void main(String[] args) {
        CombinationIterator combinationIterator = new CombinationIterator("abc", 2);
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
    }

    public static void findCombinations(String str, String asf){
        if(asf.length() == 2){
            System.out.println(asf);
            return;
        }

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String qsf = str.substring(0, i) + str.substring(i+1);
            findCombinations(qsf, asf + ch);
        }
    }
}

class CombinationIterator {

    private String str;
    private int limit;
    private Deque<String> combinations ;
    private int curr = 0;
    private int size = 0;

    public CombinationIterator(String characters, int combinationLength) {
        combinations = new ArrayDeque<>();
        this.str = characters;
        this.limit = combinationLength;
        findCombinations2(str, "", 0, 0);
    }

    public String next() {
        String res = combinations.poll();
        curr++;
        return res;
    }

    public boolean hasNext() {
       return curr != size;
    }

    public void findCombinations2(String str, String asf, int idx, int len){
        if(len == this.limit){
            this.combinations.offer(asf);
            ++size;
            return;
        }

        for(int i = idx; i < str.length(); i++){
            char ch = str.charAt(i);
            findCombinations2(str, asf + ch, i + 1, len+1);
        }
    }
}
