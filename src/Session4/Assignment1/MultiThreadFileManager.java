// package Session4.Assignment1;

// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.nio.file.Files;
// import java.util.Scanner;

// // Thread Main: create 4 files in thumucgoc and input data from keyboard
// // Thread 1: read data from files in thumucgoc and print to console then move file to thumucbk then delete file in thumucgoc
// // Thread 2: when new file move to thumucbk check total space thumucbk if full print notification to console
// public class MultiThreadFileManager {

//     public static void main(String[] args) {
//         String thumuc = System.getProperty("user.dir");

//         File thumucgoc = new File(thumuc + "\\thumucgoc");
//         File thumucbk = new File(thumuc + "\\thumucbk");

//         if (!thumucgoc.exists()) {
//             thumucgoc.mkdir();
//         }

//         if (!thumucbk.exists()) {
//             thumucbk.mkdir();
//         }

//         FileManager fm = new FileManager(thumucgoc, thumucbk);

//         new Thread() {
//             @Override
//             public void run() {
//                 fm.createFile();
//             }
//         }.start();

//         new Thread() {
//             @Override
//             public void run() {
//                 fm.readFile();
//             }
//         }.start();

//         new Thread() {
//             @Override
//             public void run() {
//                 fm.checkSpace();
//             }
//         }.start();
//     }

// }

// class FileManager {
//     public static Scanner sc = new Scanner(System.in);
//     File thumucgoc, thumucbk;

//     public FileManager(File thumucgoc, File thumucbk) {
//         this.thumucgoc = thumucgoc;
//         this.thumucbk = thumucbk;
//     }

//     synchronized public void createFile() {
//         // create new file in thumucgoc
//         System.out.println("nhập tên file :");
//         String name = sc.nextLine();
//         File file = new File(thumucgoc + "\\" + name);
//         if (!file.exists()) {
//             try {
//                 file.createNewFile();
//             } catch (Exception e) {
//                 System.out.println("không thể tạo file");
//             }
//         }
//         // input data from keyboard
//         System.out.println("nhập dữ liệu vào file :");
//         String data = sc.nextLine();
//         try {
//             FileWriter fw = new FileWriter(file);
//             fw.write(data);
//             fw.close();
//         } catch (Exception e) {
//             System.out.println("không thể ghi file");
//         }
//         notify();
//     }

//     synchronized public void readFile() {
//         try {
//             File[] files = thumucgoc.listFiles();
//             if (files.length == 0) {
//                 System.out.println("thư mục trống");
//                 wait();
//             }
//             for (File file : files) {
//                 FileReader fr = new FileReader(file);
//                 BufferedReader br = new BufferedReader(fr);
//                 String line = "";
//                 while ((line = br.readLine()) != null) {
//                     System.out.println(line);
//                 }
//                 br.close();
//                 fr.close();
//                 File newFile = new File(thumucbk.getAbsolutePath() + "\\" + file.getName());
//                 file.renameTo(newFile);
//                 file.delete();
//             }
//             notify();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     synchronized public void checkSpace() {
//         File[] files = thumucbk.listFiles();
//         try {
//             wait();
//         } catch (InterruptedException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         }
//         long total = 0;
//         for (File file : files) {
//             try {
//                 total += Files.size(file.toPath());
//             } catch (IOException e) {
//                 // TODO Auto-generated catch block
//                 e.printStackTrace();
//             }
//         }
//         System.out.println("tổng dung lượng file trong thư mục bk : " + total);
//         if (total >= 100) {
//             System.out.println("thư mục sắp đầy");
//         }
//     }
// }