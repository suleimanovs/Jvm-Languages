package exception;

import java.io.*;

/**
 * Runtime Exceptions(Unchecked Exceptions) - исключения времени выполнения.(непроверяемые исключения).Runtime exception
 * бывают в коде, в котором присутствуют ошибочные выражения. То есть в выбросе данных исключений виноват сам программист
 * Checked Exceptions - проверяемые исключения
 */
public class ExceptionType {
    public static void main(String[] args) {
        //Unchecked Exceptions
       new ArithmeticException();
       new IndexOutOfBoundsException();
       new ArrayIndexOutOfBoundsException();
       new NullPointerException();

        //Checked Exceptions
        new InterruptedException();
        new FileNotFoundException();

    }

    /**
     * Мы говорим компилятору, что данный метод может бросить исключение.
     * Но при этом, во всех местах где мы захотим использовать данный метод нужно
     * будет обработать это исключение
     * @throws FileNotFoundException
     */
    private static void readFile() throws FileNotFoundException{
        File file = new File(("folder/file.txt"));
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
    }


}
