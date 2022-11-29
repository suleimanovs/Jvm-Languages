package scan;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {

        var consoleScanner = new Scanner(System.in);

        var str = consoleScanner.nextLine();
        System.out.println(str);

        var integer = consoleScanner.nextInt();
        System.out.println(str);

        var doubles = consoleScanner.nextDouble();
        System.out.println(str);

        var bool = consoleScanner.nextBoolean();
        System.out.println(str);

        var stringScanner = new Scanner("Hello, how are you?" + "\n What do you doing?" + "\nGood bye!");
        while (stringScanner.hasNextLine()){
            System.out.println(stringScanner.nextLine());
        }


    }
}
