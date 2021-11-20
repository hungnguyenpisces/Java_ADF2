package buoi3.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteObject {
	public static void main(String[] args) {
		File fileobject = new File("book.txt");
		// ghi file object = output
		// b1: tao stream ket noi voi file + b3: close stream
		try (
				ObjectOutputStream  oos = new ObjectOutputStream(new FileOutputStream(fileobject));
				){
			Book conan = new Book(1, "conan");
			String str = 1 + ","+ "conan";
			List<Book> list = new ArrayList<Book>();
			list.add(new Book(1,"conan"));
			list.add(new Book(1,"conan"));
			list.add(new Book(1,"conan"));
			// b2: ghi file
			oos.writeObject(list); // conan instanceof Serializable: true
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("Ghi file thanh cong.");
		// 
		
		// doc file object = input
		// b1: tao stream ket noi voi file
		// b2: doc file
		// b3: close stream
		try(
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileobject));
				){
			// b2: doc file
			Object obj = ois.readObject();
			if (obj instanceof Book) {
				Book bo = (Book)obj;
				System.out.println(bo);
			} else if (obj instanceof ArrayList) {
				List<Book> listbook = (ArrayList<Book>)obj;
				for(Book b : listbook) {
					System.out.println(b);
				}
			}
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
class Book implements Serializable{
	private int id;
	// transient: ngawn can tuần tự hóa cho thuộc tinh cua doi tuong
	private transient float price;
	private  String name;
	public Book(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Book[id: "+ id + "; name: "+ name+ "]";
	}
}
