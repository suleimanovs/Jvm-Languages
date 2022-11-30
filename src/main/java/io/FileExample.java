package io;

import java.io.File;
import java.io.IOException;

public class FileExample {

    public static void main(String[] args) throws IOException {

        /**
         * Класс File позволяет управлять информацией о
         * файлах и директориях.
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



    }

}
