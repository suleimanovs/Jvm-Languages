package io.lesson1;

import java.io.File;
import java.io.IOException;

/**
 * Created by Osman on 12:50
 */
public class FileExample {

    public static void main(String[] args) {

        File directory = new File("folder1/folder2/folder3");
        File file1 = new File(directory.getPath() + "/Osman.txt");
        File file2 = new File(directory.getPath() + "/Sara.txt");
        File file3 = new File(directory.getPath() + "/Omar.txt");
        try {
            directory.mkdirs();
            file1.createNewFile();
            file2.createNewFile();
            file3.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File[] files = directory.listFiles((dir, name) -> name.contains("S") || name.contains("s"));
        for (File f : files) {
            System.out.println(f.getName());
        }
    }


}
