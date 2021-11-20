package BT_File;

import java.util.Scanner;

public class DanhBaMain {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        String choose = null;
        boolean exit = false;
        QuanLyDanhBa QLDB= new QuanLyDanhBa();

        System.out.println("-----------menu------------");
        System.out.println("1. Thêm 1 danh bạ ( số điện thoại, tên người) ");
        System.out.println("2. Hiển thị nội dung của file danh bạ");
        System.out.println("3. Lưu danh bạ vào 1 mảng ArrayList");
        System.out.println("4. Tìm kiếm danh bạ theo số điện thoại");
        System.out.println("5. Xóa file danh bạ");
        System.out.println("6. Kết thúc chương trình");
        System.out.println("7. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
        choose = scanner.nextLine();
        while (true) {

            switch (choose) {
                case "1":
                    QLDB.addDb();
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                break;
            }
        }
    }
}
