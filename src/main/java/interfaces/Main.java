package interfaces;

/**
 * Created by Osman on 9:59
 */
public class Main {
    /**
     * в качестве анонимной функции используеться абстрактный метод {@link Flyable#fly()}
     */
    static Flyable flyable = () -> System.out.println("Fly!");

    public static void main(String[] args) {
        testTurnLeft();
        testTurnRight();
    }

    public static void testTurnLeft() {
        //flyable.turnLeft();  - не доступно
        Flyable.turnLeft(); // - доступно
    }


    public static void testTurnRight() {
        flyable = new Flyable() {
            @Override
            public void fly() {
                System.out.println("I'm Fly!");
            }

            @Override
            public void turnRight() {
                System.out.println("I'm turning to Right");

            }
        };


        flyable.fly();
        flyable.turnRight();
    }
}
