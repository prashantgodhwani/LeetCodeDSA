import java.util.Stack;

public class Leetcode_DecodeString_394 {

    public static void main(String[] args) {
        String str = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String res = decodeString_optimized(str);
        System.out.println(res);
    }

    public static String decodeString(String str) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> charStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int num = str.charAt(i) - '0';
                while (str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9') {
                    num = num * 10 + str.charAt(i + 1) - '0';
                    i++;
                }
                countStack.push(num);
            } else if (ch == '[') {
                charStack.push("[");
            } else if (ch == ']') {
                int not = 0;
                String s = "";
                if (countStack.size() > 0)
                    not = countStack.pop();
                StringBuilder ss = new StringBuilder();
                while (charStack.size() > 0 && !charStack.peek().equals("[")) {
                    ss.insert(0, charStack.pop());
                }
                System.out.println("ss = " + ss);
                if (charStack.size() > 0)
                    charStack.pop();
                StringBuilder finalString = new StringBuilder();
                for (int j = 0; j < not; j++) {
                    finalString.append(ss);
                }
                charStack.push(finalString.toString());
            } else {
                String s = "";
                if (charStack.size() > 0 && !charStack.peek().equals("["))
                    s = charStack.pop();
                charStack.push(s + ch);
            }

            System.out.println(charStack);
            System.out.println(countStack);

        }

        StringBuilder res = new StringBuilder();
        while (charStack.size() > 0) {
            res.insert(0, charStack.pop());
        }

        return res.toString();
    }

    public static String decodeString_optimized(String str) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> charStack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                int num = str.charAt(i) - '0';
                while (Character.isDigit(str.charAt(i + 1))) {
                    num = num * 10 + str.charAt(i + 1) - '0';
                    i++;
                }
                countStack.push(num);
            } else if (ch == '[') {
                charStack.push(res.toString());
                res.setLength(0);
            } else if (ch == ']') {
                int not = countStack.pop();

                StringBuilder finalString = new StringBuilder(charStack.pop());
                for (int j = 0; j < not; j++) {
                    finalString.append(res);
                }

                res = finalString;
            } else {
                res.append(ch);
            }

            System.out.println(res);
            System.out.println(charStack);
        }

        return res.toString();
    }
}
