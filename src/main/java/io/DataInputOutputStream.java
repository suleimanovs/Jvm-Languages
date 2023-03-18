package io;

import java.io.*;

public class DataInputOutputStream {

    public static void main(String[] args) {
        /**
         * DataInputStream и DataOutputStream позволяют
         * записывать в файл и читать из него примитивные
         * типы данных.
         */


        var path = "file/binary.bin";
        try (var dataOutputStream = new DataOutputStream(new FileOutputStream(path));
             var dataInputStream = new DataInputStream(new FileInputStream(path));
        ) {

            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeByte(23);
            dataOutputStream.writeDouble(343.544);
            dataOutputStream.writeChar('x');
            dataOutputStream.writeInt(356647);


            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readByte());
            System.out.println(dataInputStream.readDouble());
            System.out.println(dataInputStream.readChar());
            System.out.println(dataInputStream.readInt());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
