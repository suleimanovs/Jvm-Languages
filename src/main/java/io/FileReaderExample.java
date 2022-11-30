package io;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {

    public static void main(String[] args) {


        /**
         * try with resources автоматически закрывает поток, это работает только с теми классами которые являются
         * {@link java.io.Closeable}. Вручную вызвать метод close в блоке finally не нужно.
         *
         * FileReader используется для работы с текстовыми файлами.
         */

        try (FileReader fileReader = new FileReader("file/instagram.txt")) {
            int character = -1;
            while ((character = fileReader.read()) != -1) {
                System.out.print((char)character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
