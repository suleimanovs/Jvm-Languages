package io.lesson5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Osman on 1:55 PM
 */
public class FileReaderDemo {

    public static void main(String[] args) {

        String line;
        /**
         * В таком случае файл будет закрыт автоматически
         */
        try (BufferedReader reader = new BufferedReader(
                new FileReader("D:\\Java\\src\\main\\java\\file\\myFile"))) {
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
