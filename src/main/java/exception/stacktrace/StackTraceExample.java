package exception.stacktrace;

/**
 * Created by osmanboy on 3/2/2022
 * трассировка стека – это список методов, которые были вызваны до момента,
 * когда в программе произошло исключение. Обычно в случае исключений он вызывается по умолчанию.
 * Но его можно вызвать и в ручную.
 * См: {@link Test#method5()}
 */


class Test {

    public static void method1() {
        //не вызывает ничего
    }

    public static void method2() {
        method3();
        method4();
    }

    public static void method3() {
        //не вызывает ничего
    }

    public static void method4() {
        method5();
    }

    private static void method5() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements) {
            System.out.println(
                    "Метод: " + element.getMethodName() +
                            " класс: " + element.getClassName() +
                            " Строка: " + element.getLineNumber());
        }
    }
}

public class StackTraceExample {
    public static void main(String[] args) {

        Test.method1();
        Test.method2();
    }
}
