package buoi2.danhsach;

import java.util.ArrayList;

// import buoi1.ngoaile.ProductException;

public class GenericDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Container c1 = new Container(1);
		Container c2 = new Container("1");
		// Container c3 = new Container(new ProductException("abc"));
		if (c1.equals(c2)) {
			System.out.println("Object bang nhau");
		} else {
			System.out.println("Object khong bang nhau");
		}
		
		// cụ thể hóa - generic: áp dụng 1 kiểu cụ thể cho đối tượng khai báo kiểu tổng quát hóa
		Container2 c21 = new Container2(1); // T: Object - generics
		Container2<String> c22 = new Container2<String>(String.valueOf(111));
		Container2<Integer> c23 = null;
		if (c22.equals("111")) {
			System.out.println("Bang nhau");
		} else {
			System.out.println("Khong bang nhau");
		}
	}
	
}
// tong quat hóa - generics: tạo ra class áp dụng cho nhiều kiểu dữ liệu khác nhau
class Container2 <T>{
	private T[] list;
	private ArrayList<T> listContainers;
	// khong ap dung static
	//public static T staticObj;
	public T obj;
	public Container2 () {
		// khong khoi tao duoc generic
		//this.obj = new T();
	}
	public Container2 (T o) {
		this.obj = o;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return obj.toString();
	}
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o instanceof String) {
			System.out.println("obj: "+ this.obj.toString());
			System.out.println("obj2: "+ o.toString());
			return this.obj.toString().equals(o.toString());
		}
		return super.equals(obj);
	}
}
class Container{
	public Object obj;
	public Container(Object obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	@Override
	public boolean equals(Object o) {
		if (o == null || this == null)
			return false;
		
		Integer res = 0;
		if (((Container)o).obj instanceof String) {
			res = Integer.parseInt(((Container)o).obj.toString());
		}
		if (this.obj instanceof Integer) {
			return (res.compareTo(new Integer(this.obj.toString())) == 0);
		}
		return super.equals(obj);
	}
}
