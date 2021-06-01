public class Leetcode_HTMLEntityParser_1410 {

    public static void main(String[] args) {
        String res = entityParser(
                "&&&amp&&&gt;&&");
        System.out.println(res);
    }

    public static String entityParser(String text) {

        StringBuilder str = new StringBuilder();
        StringBuilder ress = new StringBuilder();
        int size =  text.length();

        for(int i = 0; i < size; i++){
            char ch = text.charAt(i);
            if(ch == '&' && size > i + 1 && text.charAt(i + 1) != '&'){
                while(text.charAt(i) != ';'){
                    str.append(text.charAt(i));
                    i++;
                    if(text.charAt(i) =='&'){
                        str.append(text.charAt(i));
                        break;
                    }
                }
                if(text.charAt(i) == ';') str.append(";");
                String tmp = str.toString();
                str.setLength(0);

                if(tmp.equals("&quot;")){
                    ress.append("\"");
                }
                else if(tmp.equals("&apos;")){
                    ress.append("'");
                }
                else if(tmp.equals("&amp;")){
                    ress.append("&");
                }
                else if(tmp.equals("&gt;")){
                    ress.append(">");
                }
                else if(tmp.equals("&lt;")){
                    ress.append("<");
                }
                else if(tmp.startsWith("&frasl;")){
                    ress.append("/");
                }
                else{
                    ress.append(tmp);
                }
            }else{
                ress.append(ch);
            }
        }
        return ress.toString();
    }
}
