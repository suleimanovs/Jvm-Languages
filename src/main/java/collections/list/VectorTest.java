package collections.list;

import java.util.Vector;

/**
 * Vector – устаревший synchronized класс. В своей основе содержит массив элементов Object.
 * Не рекомендован для использования. Так как он очень медленный из-за синхронизаций. Использовалась ког
 * альтернатива ArrayList, но для многопоточность, так как он потока безопасный.
 * На данный момент для потока безопасности рекомендуется другие классы из пакета link{@java.util.concurrent}
 */
public class VectorTest {

    public static void main(String[] args) {
        var vector = new Vector<String>();
        vector.add("Misha");
        vector.add("Oleg");
        vector.add("Asan");
        vector.add("Dima");
        vector.add("Marsel");

        vector.firstElement();
        vector.lastElement();


    }


}
