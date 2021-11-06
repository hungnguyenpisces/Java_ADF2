package buoi1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char gioiTinh = 'm';
        System.out.println("Gioi tinh");
        try {
            gioiTinh = (char) sc.nextInt();
            String str = null;
            System.out.println(str.length());
        } catch (InputMismatchException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("nhap num 1:");
            int num1 = sc.nextInt();
            System.out.println("nhap num2");
            int num2 = sc.nextInt();
            System.out.println(num1 + "/" + num2 + "=" + num1 / num2);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Finish");
        sc.close();
    }
}
