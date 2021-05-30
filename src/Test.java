import java.util.Optional;

public class Test {
    public static void main(String[] args) {
       Optional optional = Optional.of("GOT");

       String[] strings = new String[10];
       Optional o2 = Optional.ofNullable(strings[9]);
        System.out.println(optional.isPresent());
        System.out.println(o2.isPresent());
    }
}
