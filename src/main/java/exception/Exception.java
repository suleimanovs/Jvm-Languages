package exception;

/**
 * Created by Osman on 16:23
 */
public class Exception {

    public static void main(String[] args) {
        int a = 0;
        try {
            int b = 7 / a;
            String s = "10";
            Integer.parseInt(s);

        } catch (NumberFormatException e) {
            System.err.println(e);
        } catch (ArithmeticException e) {
            System.err.println("Found a exception: " + e);
        } finally {
            System.out.println("Program is finished");
        }

    }
}
