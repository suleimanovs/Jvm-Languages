package stringformat;


/**
 * Created by Osman on 16:41
 */
public class Main {
    public static void main(String[] args) {
        double random = Math.random();
        String info = String.format("%1.2f",random);
        System.out.println(info);
    }
}
