package buoi1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GhiFileDemo {
    public static void main(String[] args) {
        String product = "DT, IP13,iPhone 13, iPhone 13 pro max, 30000000";
        File file_dssp = new File("tailieu\\products.txt");
        try (PrintWriter pw = new PrintWriter(file_dssp); Scanner sc = new Scanner(file_dssp)) {
            for (int i = 0; i < 7; i++) {
                pw.write(product + "\n");
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    // public static void main2(String[] args) {
    // PrintWriter pw = null;
    // try {
    // pw = new PrintWriter(file_dssp);
    // for (int i = 0; i < 5; i++) {
    // pw.write(product + "\n");
    // }
    // } catch (FileNotFoundException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // } finally {
    // if (pw != null) {
    // pw.close();
    // }

    // }
    // }

}
