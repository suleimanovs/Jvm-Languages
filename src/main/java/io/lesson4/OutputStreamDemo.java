package io.lesson4;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Osman on 15:09
 */
public class OutputStreamDemo {

    public static void main(String[] args) {
        File file = new File("Package/lesson4/names.txt");
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, true))) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter next: ");
            String next = scanner.nextLine();
            while (!next.equals("Exit")) {
                bufferedOutputStream.write(next.getBytes());
                bufferedOutputStream.write('\n');
                next = scanner.nextLine();
            }

            try (InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))) {
                StringBuilder result = new StringBuilder();
                byte[] bytes = new byte[10];
                int count = bufferedInputStream.read(bytes);
                while (count > 0) {
                    result.append(new String(bytes, 0, count));
                    count = bufferedInputStream.read(bytes);
                }
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
