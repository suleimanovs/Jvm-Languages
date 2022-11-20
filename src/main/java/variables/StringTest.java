package variables;

/**
 * Created by osmanboy on 3/2/2022
 */
public class StringTest {

    public static void main(String[] args) {

        String string1 = new String("String");
        String string2 = new String("String");
        System.out.println(string1.equals(string2));
        System.out.println(string1.intern()==string2.intern());

    }
}
