package statement;


/**
 * этот пакет импортируется для всех java файлов, импортировать не нужно
 * что бы имортировать все классы внутри данного пакета, нужно в конце указать "*"
 */

import java.lang.*;


/**
 * import static позволяет импортировать статические переменные и методы, что бы в классе к ним можно было обращаться
 * напрямую, без имени класса, точнее без полного имени к переменной или методу.
 * что бы импортировать все статические методы и переменные, то требуется в конце указать "*"
 */
import static java.lang.Math.PI;
import static java.lang.Math.*;

public class Import {

    public static void main(String[] args) {
        variables.Char vChar = new variables.Char(); //либо писать полный путь к классу, точнее плное имя класса
        System.out.println("Число PI: " + PI);
        System.out.println("Число E: " + E);
        System.out.println(max(2,4)); // статисеский метод из класса Math
    }
}
