package collections.list;

import java.util.*;

/**
 * Stack – устаревший synchronized класс. Использует принцип LIFO.
 * Не рекомендован для использования
 * LiFO - last in, first out. Последним положен, первым извлечен. Как пример можно привести стопок тарелок.
 * Этот же принцип используется и для Java Stack вызовов
 */
public class StackTest {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        stack.push("Misha");
        stack.push("Oleg");
        stack.push("Asan");
        stack.push("Dima");

        System.out.println(stack.pop()); //возвращает элемент сверху стэка и удаляет его
        System.out.println(stack.peek()); //возвращает элемент сверху стэка

    }

}
