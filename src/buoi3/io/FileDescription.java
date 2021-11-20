package buoi3.io;

import java.io.File;

public class FileDescription {

	public static void main(String[] args) {
		String rootPath = "D:\\WORK\\Java\\Course\\SEM2\\VietnamACCP6678_CLassroom\\Professional Programming in Java";
		String path2 = "baitapjava";
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		// File ánh xạ tới 1 thư mục (chứa thư mục con và file) hoặc 1 tệp/ file (chỉ chứa data) trên thiết bị
		File projectFile = new File(projectPath);
		System.out.println("Ton tai?: "+ projectFile.exists());
		File anoFile = new File(path2);
		System.out.println("Anonymous Ton tai?: "+ anoFile.exists());
		System.out.println("Thu muc?"+projectFile.isDirectory() + " hoac file? "+ projectFile.isFile() );
		System.out.println("Ten: "+ projectFile.getName() );
		System.out.println("Duong dan: "+ projectFile.getParent());
		System.out.println("Size: "+ projectFile.getTotalSpace() + "; user: "+ projectFile.getUsableSpace());
		// lay ds File (đại diện thư mục / tệp con cấp 1) mà thư mục đang chứa
		File[] chirld = projectFile.listFiles();
		for(File fi : chirld) {
			System.out.println(( fi.isDirectory() ?"+":"-" ) + fi.getName());
		}
		
	}

}
