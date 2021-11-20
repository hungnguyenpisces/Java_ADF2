package Session4.Assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class FileManager {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String rootPath = System.getProperty("user.dir");

        File thumucgoc = new File(rootPath + "\\thumucgoc");
        File thumucbk = new File(rootPath + "\\thumucbk");

        if (!thumucgoc.exists()) {
            thumucgoc.mkdir();
        }

        if (!thumucbk.exists()) {
            thumucbk.mkdir();
        }

        ThuMucQuanLy thumucquanly = new ThuMucQuanLy(thumucgoc, thumucbk);
        ThreadReadFile tr = new ThreadReadFile(thumucquanly);
        ThreadCheckSpace ts = new ThreadCheckSpace(thumucquanly);
        tr.start();
        ts.start();

        String choose = "";
        do {
            File file = null;
            System.out.println("nhập tên để tạo file :");
            String name = sc.nextLine();
            file = new File(thumucgoc + "\\" + name);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e) {
                    System.out.println("không thể tạo file");
                }
            }
            // input data from keyboard
            System.out.println("nhập dữ liệu vào file :");
            String data = sc.nextLine();
            try {
                FileWriter fw = new FileWriter(file);
                fw.write(data);
                fw.close();
            } catch (Exception e) {
                System.out.println("không thể ghi file");
            }
            System.out.println("bạn có muốn thêm file (y/n)");
            choose = sc.nextLine();
            thumucquanly.newFile(file.getAbsolutePath());
        } while (!"n".equalsIgnoreCase(choose));

    }
}

class ThreadReadFile extends Thread {
    ThuMucQuanLy thuMucQuanLy;

    public ThreadReadFile(ThuMucQuanLy thuMucQuanLy) {
        this.thuMucQuanLy = thuMucQuanLy;
    }

    @Override
    public void run() {
        while (true) {
            thuMucQuanLy.readFile();
        }
    }
}

class ThreadCheckSpace extends Thread {
    ThuMucQuanLy thuMucQuanLy;

    public ThreadCheckSpace(ThuMucQuanLy thuMucQuanLy) {
        this.thuMucQuanLy = thuMucQuanLy;
    }

    @Override
    public void run() {
        while (true) {
            thuMucQuanLy.checkSpace();
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class ThuMucQuanLy {
    File thumucgoc, thumucbk;

    public ThuMucQuanLy(File thumucgoc, File thumucbk) {
        this.thumucgoc = thumucgoc;
        this.thumucbk = thumucbk;
    }

    public synchronized void newFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            notify();
        }
    }

    public synchronized void readFile() {
        File[] files = thumucgoc.listFiles();
        if (files.length == 0 || files == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (File file : files) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                br.close();
                fr.close();
                File newFile = new File(thumucbk.getAbsolutePath() + "\\" + file.getName());
                file.renameTo(newFile);
                file.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        notify();
    }

    public synchronized void checkSpace() {
        File[] files = thumucbk.listFiles();
        long total = 0;
        for (File file : files) {
            try {
                total += Files.size(file.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (total <= 200) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("--------Cảnh báo!!! thumucbk săp đầy!!!----------");
        }
    }
}