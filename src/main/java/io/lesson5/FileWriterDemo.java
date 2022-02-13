package io.lesson5;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Osman on 1:55 PM
 */
public class FileWriterDemo {

    public static void main(String[] args) {

        File file = new File("D:\\Java\\src\\main\\java\\file\\myFile");
        Scanner scanner = new Scanner(System.in);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPath(),true))) {
            writer(scanner, writer,file);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }

    private static void writer( Scanner scanner, BufferedWriter writer,File file) throws IOException {
            System.out.print("input message:");
            String line = scanner.nextLine();

            if(line.equals("delete")){
            writer.close();
            file.deleteOnExit();
        }else if(!line.equals("stop")) {
                writer.write(line);
                writer(scanner,writer,file);
                writer.newLine();
            }

        }



}
