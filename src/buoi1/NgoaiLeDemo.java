package buoi1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NgoaiLeDemo {
    public static void main(String[] args) {
        // File file = new File("C:\\Users\\nguye\\Desktop\\abc.txt");
        Scanner scanner = null;
        File file = new File("tailieu\\ngoaile.txt");
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line.charAt(100));
                System.out.println(line);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            System.out.println("finally");
            if (scanner != null) {
                scanner.close();
            }
        }
        System.out.println("End");
    }
}
