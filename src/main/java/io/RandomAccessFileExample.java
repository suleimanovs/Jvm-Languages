package io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {

    public static void main(String[] args) {

        var path = "file/lorem.txt";
        try (var randomAccess = new RandomAccessFile(path, "rw")) {

            /**
             * Перемещаем курсор на позицию 1000 в данном файле
             */
            randomAccess.seek(1000);
            var s = randomAccess.readLine();
            System.out.println(s);


            var pointerPositionNow = randomAccess.getFilePointer();
            System.out.println(pointerPositionNow); //1037 так как мы прочли всю строку с помощью readLine()

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
