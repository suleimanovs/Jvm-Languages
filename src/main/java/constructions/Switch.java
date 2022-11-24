package constructions;

import java.util.Random;

import static constructions.WEEK.*;

public class Switch {

    public static void main(String[] args) {
        var weekDay = new Random().nextInt(8);

        /**
         * switch работает только с String, short, byte, int, char , enum
         */
        switch (weekDay) {
            case 1: {
                System.out.println("Понидельник");
                break;
            }
            case 2: {
                System.out.println("Вторник");
                break;
            }
            case 3: {
                System.out.println("Среда");
                break;
            }
            case 4: {
                System.out.println("Четверг");
                break;
            }
            case 5: {
                System.out.println("Пьятница");
                break;
            }
            case 6: {
                System.out.println("Субота");
                break;
            }
            case 7: {
                System.out.println("Восркесенье");
                break;
            }
            default:
                System.out.println("Фиг знает");
        }


        var enumWeekDay = WEEK.values()[new Random().nextInt(WEEK.values().length)];

        switch (enumWeekDay) {
            case Monday: {
                System.out.println(Monday);
                break;
            }
            case Tuesday: {
                System.out.println(Tuesday);
                break;
            }
            case Wednesday: {
                System.out.println(Wednesday);
                break;
            }
            case Thursday: {
                System.out.println(Thursday);
                break;
            }
            case Friday: {
                System.out.println(Friday);
                break;
            }
            case Saturday: {
                System.out.println(Saturday);
                break;
            }
            case Sunday: {
                System.out.println(Sunday);
                break;
            }
            default: {
                break;
            }
        }
    }

}

enum WEEK {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday
}
