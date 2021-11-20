package Session3;

import java.io.File;

public class FileDescription {
    public static void main(String[] args) {
        String rootPath = "D:\\GitHub\\JAVA";
        String path2 = "baitapjava";
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path: " + projectPath);
        File projectFile = new File(projectPath);
        System.out.println("Project File exists: " + projectFile.exists());
        File anyFile = new File(path2);
        System.out.println("Any File exists: " + anyFile.exists());
        System.out.println("Thu muc? " + projectFile.isDirectory() + " hoac file? " + projectFile.isFile());
        System.out.println("size " + projectFile.getTotalSpace() / 1024 / 1024 / 1024 + " used "
                + projectFile.getUsableSpace() / 1024 / 1024 / 1024);
        File[] listFiles = projectFile.listFiles();
        for (File file : listFiles) {
            System.out.println((file.isDirectory() ? "+ " : "- ") + file.getName());
        }
    }
}
