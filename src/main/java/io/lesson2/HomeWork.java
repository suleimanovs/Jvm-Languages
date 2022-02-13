package io.lesson2;

import java.io.*;

import static kotlin.io.ConsoleKt.readLine;

/**
 * Created by osmanboy on 1/30/2022
 */
public class HomeWork {

    public static void main(String[] args) throws IOException {
        File directory = new File("Package1/lesson2/");
        File file = new File(directory.getPath() + "/names.txt");
        directory.mkdirs();
        file.createNewFile();

        try (InputStream inputStream = new FileInputStream(file)) {
            int line = inputStream.read();
            while (line != -1){
                System.out.print((char) line);
                line = inputStream.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
