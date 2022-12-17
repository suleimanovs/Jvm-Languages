package io.lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {

    public static void main(String[] args) {


        /**
         * try with resources автоматически закрывает поток, это работает только с теми классами которые являются
         * {@link java.io.Closeable}. Вручную вызвать метод close в блоке finally не нужно.
         *
         * FileReader используется для работы с текстовыми файлами.
         *
         * Если вам нужно читать именно символы, а не байты, тогда можно использовать класс Reader, который в качестве параметра
         * в конструктор принимает InputStream. Ему по желанию можно указать кодировку.
         */

        try (FileReader fileReader = new FileReader("file/instagram.txt")) {
            int character = -1;
            while ((character = fileReader.read()) != -1) {
                System.out.print((char)character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        String line;
        /**
         * В таком случае файл будет закрыт автоматически
         */
        try (var reader = new BufferedReader(new FileReader("file/instagram.txt"))) {
            line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }

}
