package Session3;

import java.io.File;

public class FileManager {
    public static void main(String[] args) {
        String rootPath = System.getProperty("user.dir");
        File dir = new File(rootPath);
        travelDir(dir, "");
    }

    public static void travelDir(File file, String indent) {
        if (file == null || file.exists() == false) {
            return;
        }
        if (file.isDirectory()) {
            System.out.println(indent + "+ " + file.getName());
            File[] listFiles = file.listFiles();
            for (File f : listFiles) {
                travelDir(f, indent + "\t");
            }
        } else {
            System.out.println(indent + "- " + file.getName());
        }
    }
}
