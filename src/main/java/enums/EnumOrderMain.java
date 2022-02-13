package enums;

/**
 * Created by Osman on 2:13 PM
 */
public class EnumOrderMain {

    public void checkColor(Color color) {
        color.toString();
    }

    public static void main(String[] args) {
        /**
         * {@link Enum#ordinal()} - возвращат порядок обявления констант.
         */
        System.out.println(Color.BLACK.ordinal());
        System.out.println(Color.BLACK.toString());


        Color color = Color.BLACK;
        /**
         * для Enum в switch указать break не надо.
         */
        switch (color) {
            case RED:
                System.out.println("RED");
            case BLUE:
                System.out.println("BLUE");
            case BLACK:
                System.out.println("BLACK");
            case GREEN:
                System.out.println("GREEN");
            case WHITE:
                System.out.println("WHITE");
            case PURPLE:
                System.out.println("PURPLE");
        }
    }
}
