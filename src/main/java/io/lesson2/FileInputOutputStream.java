package io.lesson2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStream {

    public static void main(String[] args) {


        /**
         * FileInputStream и FileOutputStream используются для
         * работы с бинарными файлами. Они читают по байтово, не символьно
         *
         * FileInputStream - читает
         * FileOutputStream - записывает
         *
         * InputStream - абстрактный класс, позволяет преобразовать данные в поток байтов.
         * FileInputStream - наследник InputStream, позволяет преобразовать файл в поток байтов
         *
         * Для побайтового чтения данных используется абстрактный класс InputStream.
         * Метод read возвращает значение прочитанного байта в пределах от 0 до 255 или -1, если данных в потоке больше нет.
         * Try c ресурсами автоматически освобождает ресурсы по завершении операции, для этого передаваемый объект должен
         * реализовать интерфейс Closeable.
         *
         */

        var srcPath = "C:\\Users\\osmanboy\\Downloads\\night.png";
        var destPath = "file/night.png";
        try (
                var fileInputStream = new FileInputStream(srcPath);
                var fileOutputStream = new FileOutputStream(destPath);
        ) {
            int bit;
            while ((bit = fileInputStream.read()) != -1) {
                fileOutputStream.write(bit);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
