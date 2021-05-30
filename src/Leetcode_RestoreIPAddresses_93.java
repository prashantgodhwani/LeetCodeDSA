import java.util.ArrayList;
import java.util.List;

public class Leetcode_RestoreIPAddresses_93 {

    public static void main(String[] args) {
        List<String> finalRes = new ArrayList<>();
        restoreIpAddresses("101023", "", finalRes, 0, "101023".length());
        System.out.println(finalRes);
    }

    public static void restoreIpAddresses(String qsf, String asf, List<String> finalRes, int idx, int size) {
        int s = asf.length();
        if(s == size + 4){
            finalRes.add(asf.substring(0, s - 1));
            return;
        }


        for(int i = 1; i <= 3 && idx < 4 && i <= qsf.length(); i++){
            String substr = qsf.substring(0, i);
            if(Integer.parseInt(substr) >= 0 && Integer.parseInt(substr) <= 255 && (substr.length() == 1 || (substr.length() > 1 && substr.charAt(0) != '0'))){
                restoreIpAddresses(qsf.substring(i), asf+substr+".", finalRes, idx  + 1, size);
            }
        }

    }
}
