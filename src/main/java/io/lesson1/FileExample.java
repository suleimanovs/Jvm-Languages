package io.lesson1;

import java.io.File;
import java.io.IOException;

/**
 * Created by Osman on 12:50
 */
public class FileExample {

    public static void main(String[] args) throws IOException {

        /**
         * Класс File позволяет управлять информацией оmфайлах и директориях.
         * File file = new File (“test1.txt”);
         * getAbsolutePath isAbsolute isDirectory exists
         * createNewFile mkdir length delete listFiles
         * isHidden canRead canWrite canExecute
         */
        var file = new File("file/sub/package/","some.txt");
        file.createNewFile();
        file.mkdirs();
        System.out.println(file.canWrite());;
        System.out.println(file.canRead());;

        File directory = new File("file/sub/person");
        directory.mkdirs();

        File file1 = new File(directory.getPath() + "/Osman.txt");
        File file2 = new File(directory.getPath() + "/Sara.txt");
        File file3 = new File(directory.getPath() + "/Omar.txt");
        file1.createNewFile();
        file2.createNewFile();
        file3.createNewFile();

        File[] files = directory.listFiles((dir, name) -> name.contains("S") || name.contains("s"));
        for (File f : files) {
            System.out.println(f.getName());
        }
    }


}
