package io.lesson2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Osman on 13:10
 * InputStream - абстрактный класс, позволяет преобразовать данные в поток байтов.
 * FileInputStream - наследник InputStream, позволяет преобразовать файл в поток байтов
 *
 * Для побайтового чтения данных используется абстрактный класс InputStream.
 * Метод read возвращает значение прочитанного байта в пределах от 0 до 255 или -1, если данных в потоке больше нет.
 * Try c ресурсами автоматически освобождает ресурсы по завершении операции, для этого передаваемый объект должен
 * реализовать интерфейс Closeable.
 */
public class InputStreamExample {

    public static void main(String[] args) {
        File file = new File("names1.txt");

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder result = new StringBuilder();
        try (InputStream fileInputStream = new FileInputStream(file)) {

            int a = fileInputStream.read();
            while (a != (-1)) {
                result.append((char) a);
                a = fileInputStream.read();
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
