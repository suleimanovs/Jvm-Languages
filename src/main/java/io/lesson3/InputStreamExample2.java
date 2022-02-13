package io.lesson3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by osmanboy on 1/30/2022
 * Класс String - immutable(неизменяемый), поэтому если нaм нужно формировать строку в цикле, прикрепляя к ней новые
 * символы, то нужно использовать класс {@link java.lang.StringBuilder}
 *
 * Если нужно сделать тоже самое, но из разных потоков, тогда стоит использовать класс {@link java.lang.StringBuffer}
 *
 * Читать по одному байту очень долга операция, поэтому лучше использовать чтение в массив.
 *
 * Если вам нжуно читать именно символы а не байты, тогда мржно использовать класс Reader, котторый в качестве параметра
 * в контсруктор принимает InputStream. Ему по желанию можно указать кодировку.
 */
public class InputStreamExample2 {
    public static void main(String[] args) {
        File file1 = new File("Package1/lesson2/names.txt");

        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (InputStream inputStream = new FileInputStream(file1)) {
            StringBuilder stringBuilder = new StringBuilder();
            byte[] array = new byte[20];
            int count = inputStream.read(array);
            while (count > 0) {
                stringBuilder.append(new String(array, 0, count));
                count = inputStream.read(array);
            }
            System.out.println(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
