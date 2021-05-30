package Test;

import java.util.Arrays;

public class SortingTheSentence {

    public static void main(String[] args) {
        String s = sortSentence("Myself2 Me1 I4 and3");
        System.out.println(s);
    }

    public static String sortSentence(String s) {
        String[] strings = s.split(" ");

        String[] finalRes = new String[strings.length];

        for(int i = 0; i < strings.length; i++){
            char num = strings[i].charAt(strings[i].length() - 1);
            finalRes[num - '0' - 1] = strings[i].substring(0, strings[i].length() - 1);
        }

        return String.join(" ", finalRes);

    }
}
