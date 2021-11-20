package Session3.Assignment1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLiDanhBa {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        File fileDB = new File("danhba.txt");
        if (!fileDB.exists()) {
            fileDB.createNewFile();
        }
        String confirm = "";
        boolean isError = false;
        do {
            try {
                mainMenu();
                int choose = scanner.nextInt();
                switch (choose) {
                case 1:
                    FileWriter fw = new FileWriter(fileDB, Charset.defaultCharset(), true);
                    PrintWriter pw = new PrintWriter(fw);
                    System.out.println("1. Thêm 1 danh bạ");
                    DanhBa danhBa = new DanhBa();
                    danhBa.nhapDanhBa();
                    pw.println(danhBa.toString());
                    pw.close();
                    break;
                case 2:
                    FileReader fr = new FileReader(fileDB);
                    Scanner sc = new Scanner(fr);
                    System.out.println("2. Hiển thị danh bạ");
                    while (sc.hasNextLine()) {
                        System.out.println(sc.nextLine());
                    }
                    break;
                case 3:
                    System.out.println("3. Lưu danh sách danh bạ");
                    // danh ba to arraylist
                    FileReader fr1 = new FileReader(fileDB);
                    Scanner sc1 = new Scanner(fr1);
                    ArrayList<DanhBa> danhBaList = new ArrayList<DanhBa>();
                    while (sc1.hasNextLine()) {
                        String[] arr = sc1.nextLine().split(" : ");
                        DanhBa danhBa1 = new DanhBa(arr[0], arr[1]);
                        danhBaList.add(danhBa1);
                    }
                    // duyet list
                    System.out.println("danh sach danh ba trong arlisst");
                    for (DanhBa danhBa2 : danhBaList) {
                        System.out.println(danhBa2.toString());
                    }
                    break;
                case 4:
                    // tim danh ba
                    System.out.println("4. Tìm danh bạ");
                    System.out.println("Nhập sđt cần tìm");
                    scanner.nextLine();
                    String sdt = scanner.nextLine();
                    FileReader fr2 = new FileReader(fileDB);
                    Scanner sc2 = new Scanner(fr2);
                    boolean isFound = false;
                    while (sc2.hasNextLine()) {
                        String[] arr = sc2.nextLine().split(" : ");
                        DanhBa danhBa3 = new DanhBa(arr[0], arr[1]);
                        if (danhBa3.getSdt().equals(sdt)) {
                            System.out.println(danhBa3.toString());
                            isFound = true;
                        }
                    }
                    if (!isFound) {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:
                    System.out.println("Please choose again!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Lua chon khong hop le");
                isError = true;
            }
            scanner.nextLine();
            System.out.println("Ban co muon tiep tuc? (n = no)");
            confirm = scanner.nextLine();
        } while (!"n".equalsIgnoreCase(confirm) || isError);
    }

    public static void mainMenu() {
        System.out.println("---------MAIN MENU---------");
        System.out.println("1. Thêm 1 danh bạ");
        System.out.println("2. Hiển thị danh bạ");
        System.out.println("3. Lưu danh sách danh bạ");
        System.out.println("4. Tìm danh bạ theo sđt");
        System.out.println("5. Xóa file danh bạ");
        System.out.println("6. Thoát");
    }
}

class DanhBa implements Serializable {
    private String sdt;
    private String ten;
    Scanner scanner = new Scanner(System.in);

    public DanhBa() {
        super();
    }

    public DanhBa(String sdt, String ten) {
        super();
        this.sdt = sdt;
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void nhapDanhBa() {
        System.out.println("Nhập số điện thoại: ");
        this.sdt = scanner.nextLine();
        System.out.println("Nhập tên: ");
        this.ten = scanner.nextLine();
    }

    @Override
    public String toString() {
        return sdt + " : " + ten;
    }
}