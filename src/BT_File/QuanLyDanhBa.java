package BT_File;

import java.util.List;
import java.util.Scanner;

public class QuanLyDanhBa {
    public static Scanner sc = new Scanner(System.in);
    private List<DanhBa> danhBaList;
    private DanhBaDao danhbadao;
    public QuanLyDanhBa(){
        danhbadao = new DanhBaDao();
        danhBaList = danhbadao.read();
    }
    public void addDb() {
        String name = inputName();
        String SDT = numberPhoneInPut();
    }
    private String inputName() {
        System.out.print("Nhap vao Ten: ");
        return sc.nextLine();
    }
    private String numberPhoneInPut(){
        System.out.println("Nhap SDT: ");
        return sc.nextLine();
    }
}
