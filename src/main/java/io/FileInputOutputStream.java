package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStream {

    public static void main(String[] args) {


        /**
         * FileInputStream и FileOutputStream используются для
         * работы с бинарными файлами. Они читают по байтово, не символьно
         *
         * FileInputStream - читает
         * FileOutputStream - записывает
         */

        var srcPath = "C:\\Users\\osmanboy\\Downloads\\night.png";
        var destPath = "file/night.png";
        try (var fileInputStream = new FileInputStream(srcPath); var fileOutputStream = new FileOutputStream(destPath)) {
            int bit;
            while ((bit=fileInputStream.read())!=-1){
                fileOutputStream.write(bit);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
