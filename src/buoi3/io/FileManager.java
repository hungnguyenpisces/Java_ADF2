package buoi3.io;

import java.io.File;

/*
 * Quản lý các thư mục con và tệp con + thực thi
 * */
public class FileManager {

	public static void main(String[] args) {
		String rootPath = System.getProperty("user.dir");
		File dir = new File(rootPath);
		travelDir(dir, 0);
		
	}
	// Hàm đệ quy: là hàm gọi tới chính nó để thực hiện lại cùng hành vi nhiều lần
	// tránh đệ quy vô hạn: luôn phải có lệnh kết thúc/ điểm dừng của hàm
	public static void travelDir(File file, int level) {
		if (file== null || file.exists() == false || level < 0) {
			return;
		}
		// xác định khoảng trắng trước tên:
		StringBuilder space = new StringBuilder("");
		for (int i=0; i< level; i++) {
			space.append("   ");
		}
		
		if (file.isDirectory()) {
			File[] listFile = file.listFiles();
			System.out.println( space.toString()+"+ "+ file.getName());
			for(File fi : listFile) {
				// gọi đệ quy về hàm chính nó để thực hiện lại các công việc của hàm
				travelDir(fi, level+1);
			}
		} else {
			// kết thúc của lặp đệ quy: 
			System.out.println(space.toString()+"- "+ file.getName());
		}
	}

}
