package io.lesson5;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * Created by Osman on 17:38
 */
public class RandomAccessDemo {

    public static void main(String[] args) {
        File file = new File("Package1/lesson2/names.txt");

        try(RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rw")){
            randomAccessFile.seek(10);
            randomAccessFile.writeBytes("\n**********************\n");

            randomAccessFile.seek(20);
            randomAccessFile.writeBytes("\n$$$$$$$$$$$$$$$$$$$$$$\n");

            randomAccessFile.seek(40);
            randomAccessFile.writeBytes("\n########################\n");

            randomAccessFile.seek(0);
            byte[] array = new byte[224];
            int count = randomAccessFile.read(array);
            System.out.println(new String(array));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
