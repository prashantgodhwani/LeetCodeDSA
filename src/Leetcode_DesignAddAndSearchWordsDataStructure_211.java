import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode_DesignAddAndSearchWordsDataStructure_211 {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println("now....");
        System.out.println(wordDictionary.search(".at"));
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search("a.d."));
        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));

    }


}

class WordDictionary {

    private Map<String, String> dictionary;
    private Set<String> strings;
    private Map<String, Boolean> results;
    private boolean updated = false;

    /** Initialize your data structure here. */
    public WordDictionary() {
        dictionary = new HashMap<>();
        strings = new HashSet<>();
        results = new HashMap<>();
    }

    public void addWord(String word) {
        dictionary.put(word, word);
        strings.add(word);
        updated = true;
    }

    public boolean search(String word){
        if(!updated && results.containsKey(word)) return results.get(word);

        boolean res = searchUtil(word);
        results.put(word, res);
        updated = false;
        return res;
    }

    public boolean searchUtil(String word) {
        if(dictionary.get(word) != null) return true;

        char[] charArray = word.toCharArray();
        first:
        for(String key : strings) {
            if(charArray.length != key.length()) continue;

            char[] keyArray = key.toCharArray();

            System.out.println("checking for "+word + " against "+ key);

            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == '.') continue;
                else if (charArray[i] == keyArray[i]) continue;
                else continue first;
            }
            return true;

        }

        return false;
    }
}
