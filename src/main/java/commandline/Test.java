package commandline;


/**
 * open cmd or powershell
 * 1.compile step:
 * javac Test.java
 * 2.run step
 * java Test "Ivan" "Sergei"
 */

public class Test {

    public static void main(String[] arg) {

        for (String s : arg) {
            System.out.println(s);
        }
    }
}