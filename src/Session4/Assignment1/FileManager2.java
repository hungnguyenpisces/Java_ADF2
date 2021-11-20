package Session4.Assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class FileManager2 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String thumuc = System.getProperty("user.dir");

        File thumucgoc = new File(thumuc + "\\thumucgoc");
        File thumucbk = new File(thumuc + "\\thumucbk");

        if (!thumucgoc.exists()) {
            thumucgoc.mkdir();
        }

        if (!thumucbk.exists()) {
            thumucbk.mkdir();
        }

        readFile rf = new readFile(thumucgoc, thumucbk);
        checkSpace cp = new checkSpace(thumucbk);
        rf.start();
        cp.start();

        System.out.println("nhập tên file :");
        String name = sc.nextLine();
        File file = new File(thumucgoc + "\\" + name);
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
    }

}

class readFile extends Thread {
    File thumucgoc, thumucbk;

    public readFile(File thumucgoc, File thumucbk) {
        this.thumucgoc = thumucgoc;
        this.thumucbk = thumucbk;
    }

    @Override
    public void run() {
        try {
            File[] files = thumucgoc.listFiles();
            if (files.length == 0 || files == null) {
                System.out.println("thư mục trống");
                wait();
            }
            for (File file : files) {
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class checkSpace extends Thread {
    File thumucbk;

    public checkSpace(File thumucbk) {
        this.thumucbk = thumucbk;
    }

    @Override
    public void run() {
        while (true) {
            File[] files = thumucbk.listFiles();
            long total = 0;
            for (File file : files) {
                try {
                    total += Files.size(file.toPath());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            // System.out.println("tổng dung lượng file trong thư mục bk : " + total);
            if (total >= 10) {
                System.out.println("thư mục sắp đầy");
                try {
                    wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}