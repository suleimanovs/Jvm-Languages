package io;

import java.io.*;

public class BufferedReaderWriter {

    public static void main(String[] args) {


        /**
         * Использование буферизации в стримах позволяет достичь большей эффективности при чтении файла
         * или записи в него.
         */

        try (BufferedReader fileReader = new BufferedReader(new FileReader("file/lorem.txt"))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.print(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("file/lorem.txt"))) {
            String line = "Some txt";
            fileWriter.write(line);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
