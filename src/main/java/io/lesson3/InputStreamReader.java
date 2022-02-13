package io.lesson3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

/**
 * Created by osmanboy on 1/30/2022
 */
public class InputStreamReader {
    public static void main(String[] args) throws IOException {
        File file = new File("Package1/lesson2/names.txt");

            file.createNewFile();



        try (Reader reader = new java.io.InputStreamReader(new FileInputStream(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] array = new char[20];
            int count = reader.read(array);
            while (count > 0) {
                stringBuilder.append(new String(array, 0, count));
                count = reader.read(array);
            }
            String[] names = stringBuilder.toString().split(" ");
            Arrays.stream(names).filter((name) -> name.startsWith("A")).forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
