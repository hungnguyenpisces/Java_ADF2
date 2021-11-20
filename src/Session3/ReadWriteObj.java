package Session3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class ReadWriteObj {
    public static void main(String[] args) {
        File fileObj = new File("book.txt");
        // chiều ghi
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileObj));) {
            Book conan = new Book(1, "Conan");
            oos.writeObject(conan);
            List<Book> books = List.of(new Book(2, "Book2"), new Book(3, "Book3"), new Book(4, "Book4"),
                    new Book(5, "Book5"));
            oos.writeObject(books);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Done");
        }
        System.out.println("ghi file thanh cong");

        // chiều đọc
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileObj));) {
            Book conan = (Book) ois.readObject();
            System.out.println(conan);
            List<Book> books = (List<Book>) ois.readObject();
            for (Book book : books) {
                System.out.println(book);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}

class Book implements Serializable {
    private int id;
    private String name;

    public Book(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book [id= " + id + ", name= " + name + "]";
    }
}