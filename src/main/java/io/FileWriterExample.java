package io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

    public static void main(String[] args) {


        /**
         * try with resources автоматически закрывает поток, это работает только с теми классами которые являются
         * {@link java.io.Closeable}. Вручную вызвать метод close в блоке finally не нужно.
         *
         * FileWriter используется для работы с текстовыми файлами.
         */

        try (FileWriter fileWriter = new FileWriter("file/instagram.txt", true)) {
            fileWriter.write("Insta: @suleimanov.me");
            fileWriter.write('\n');
            fileWriter.write("please follow me!");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
