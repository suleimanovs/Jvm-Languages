package enums;

/**
 * Created by Osman on 2:13 PM
 */

/**
 * Enum - класс перечислений, класс содержащий некий набор констант которые обедняются неким типом.
 * Этот некий тип и есть имя Enum class. Enum способ ограничения определенного рода информаций
 * конкретным списком возможных вариантов.
 * enum является дочерним классом для java.lang.Enum
 */
enum Color {
    BLUE(0x3F44),
    RED(0x3F44),
    BLACK(0x3F44),
    WHITE(0x3F44),
    GREEN(0x3F44),
    PURPLE(0x3F44);

    public int hex;

    /**
     * Конструктор enum имеет access modifier private и не нуждается во внешнем вызове.
     * По этому все его объекты создаются внутри
     */
    private Color(int hex) {
    }
}

public class EnumOrderMain {

    public void checkColor(Color color) {
        color.toString();
    }

    public static void main(String[] args) {
        /**
         * {@link Enum#ordinal()} - возвращат порядок обявления констант.
         */
        System.out.println(Color.BLACK.ordinal());
        System.out.println(Color.BLACK);


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
