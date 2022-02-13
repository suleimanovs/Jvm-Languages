package io.lesson1;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Created by osmanboy on 1/30/2022
 */
public class HomeWork {

    public static void main(String[] args) {

        File directories = new File("Package1/Package2/Package3/");

        directories.mkdirs();
        for (int i = 0; i < 100; i++) {
            String[] listFilesName = {"add", "aso", "mixo", "okio", "tench", "avd"};
            File generateRandomFile = new File(directories.getPath()+"/" + listFilesName[(int)(Math.random() * listFilesName.length)] + ".txt");
            try {
                generateRandomFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File[] files = directories.listFiles((file, s) -> s.startsWith("a"));
        for (File file :files){
            System.out.println(file.getName());
            System.out.println(file.getAbsolutePath());
        }
    }
}
