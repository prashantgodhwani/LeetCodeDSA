import java.util.Optional;

public class Test {
    public static void main(String[] args) {
       char ch = 't';
//       String s = "a";
//       System.out.println(ch + s);
//       System.out.println(s + ch);

       String s = "prashant";
       StringBuilder ss = new StringBuilder("");
       ss.append("pras");

       String s2 = s;
        System.out.println(s.hashCode());
        s += "g";
        System.out.println(s.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s2);
    }
}
