package buoi2.danhsach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionDemo {

	public static void main(String[] args) {
		//java.util.Collections: class hỗ trợ thao tác trên tập hợp ( tập các method static)
		//java.util.Collection: interface cây phân cấp kiểu danh sách/ tập hợp
		// List: danh sach chua phan tu theo thu tu (index) và chứa các phần tử có thể trùng nhau
		//main_List();
		// Set: danh sách chứa các phần tử không theo thứ tự và không trùng nhau.
		//main_Set();
		//main_Set_Object();
		//main_TreeSet_Object();
		// Map: danh sách chứa các phần tử theo cặp<Key , Value>, Key là duy nhất, muốn lấy Value thì phải thông qua Key
		main_Map();
	}
	public static void main_Map() {
		Map<String, Integer> map_SpMua = new HashMap<String, Integer>();
		// them 1 phan tu vao map -> key chưa tồn tại trong các keys của map
		System.out.println(map_SpMua.put("Sp001", 2)==null?"Them moi phan tu thanh cong":"Cap nhat phan tu thanh cong");
		System.out.println(map_SpMua.put("Sp002",1)==null?"Them moi phan tu thanh cong":"Cap nhat phan tu thanh cong");
		System.out.println(map_SpMua.put("Sp003",5)==null?"Them moi phan tu thanh cong":"Cap nhat phan tu thanh cong");
		System.out.println(map_SpMua.put("Sp004",3)==null?"Them moi phan tu thanh cong":"Cap nhat phan tu thanh cong");
		System.out.println(map_SpMua.put("Sp005",2)==null?"Them moi phan tu thanh cong":"Cap nhat phan tu thanh cong");
		// cap nhat lại phân tử với value mới khi key tồn tại
		System.out.println(map_SpMua.put("Sp001", 5)==null?"Them moi phan tu thanh cong":"Cap nhat phan tu thanh cong");
		// xoa 1 phan tử
		System.out.println(map_SpMua.remove("Sp006")!=null?"Xóa thanh cong": "Phan tu khong ton tai");
		// check xem key ton tai trong map?
		System.out.println(map_SpMua.containsKey("Sp001")?"Ton tai key=sp001 trong map":"Khong ton tai key=sp001 trong map");
		System.out.println(map_SpMua.containsValue(1)?"Ton tai value = 1 trong map":"Khong ton tai value = 1 trong map");
		// lay gia tri cua 1 phan tu trong map -> theo key
		System.out.println("Gia tri cua phan tu voi key=sp001: "+ map_SpMua.get("Sp001"));
		// kich thuoc cua map: size
		System.out.println("Kich thuoc: "+ map_SpMua.size());
		// duyet map:
		// duyet qua tap Set voi cac phan tu la key cua map
		System.out.println("Duyet Map qua key: ");
		Set<String> setKeys = map_SpMua.keySet();
		for(String key : setKeys) {
			System.out.println("Key: "+ key + "; value: "+ map_SpMua.get(key));
		}
		// duyet Map thong qua tap Set cac phan tu la <Key,Value>
		System.out.println("Duyet Set cac phan tu Entry<Key,Value>: ");
		Set<Map.Entry<String, Integer>> setMap =  map_SpMua.entrySet();
		for(Map.Entry<String, Integer> item : setMap) {
			System.out.println("Key: "+ item.getKey() + "; value: "+ item.getValue());
		}
		Set<Map.Entry<String, Integer>> treeSet = new TreeSet<Map.Entry<String,Integer>>(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			// giam dan theo value cua Map
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				int ssSoLuong = obj2.getValue().compareTo(obj1.getValue());
				if (ssSoLuong == 0)
					return -1;
				return ssSoLuong;
			}
		});
		// them toan bo phan tu cua collection khac vao collection hien tai
		treeSet.addAll(setMap);
		// duyet TreeSet
		System.out.println("Ds Map sap xep giam dan theo soluong: ");
		for(Map.Entry<String, Integer> item : treeSet) {
			System.out.println("Key: "+ item.getKey() + "; value: "+ item.getValue());
		}
		// TreeMap: sap xep
		//Map<String, Integer> tree_SpMua = new TreeM
		
		SoLuongComparator comparatorValue = new SoLuongComparator(map_SpMua);
		Map<String, Integer> tree_SpMua = new TreeMap<String, Integer>(comparatorValue);
		tree_SpMua.putAll(map_SpMua);
		// hien thi phan tu cua treemap
		System.out.println("TreeMap sap xep giam dan theo so luong: ");
		Set<String> tree_Keys = tree_SpMua.keySet();
		for(String key: tree_Keys) {
			System.out.println("Key: "+ key + "; value: "+ tree_SpMua.get(key));
		}
	}
	public static void main_TreeSet_Object() {
		// TreeSet: dựa vào hàm compareTo / compare để check trùng và sắp xếp đối tượng trong ds
		Set<SanPhamMua> treeSPMua = new TreeSet<SanPhamMua>(new Comparator<SanPhamMua>() {
			// ket qua: =0: o1 va o2 trung nhau
			// != 0: sap xep doi tuong trong ds
			@Override
			public int compare(SanPhamMua arg0, SanPhamMua arg1) {
				if (arg0 == null || arg1 == null)
					return 0;
				// check trung
				int checkTrung = arg0.getMaSp().compareTo(arg1.getMaSp());
				if (checkTrung == 0)
					return 0;
				// sap xep
				int checkSLuong = arg1.getSoLuong().compareTo(arg0.getSoLuong());
				if (checkSLuong == 0)
					return -1;
				return checkSLuong;
			}
		});
		System.out.println(treeSPMua.add(new SanPhamMua("SP001", 2))?" Them thanh cong":"SP da ton tai trong danh sach");
		System.out.println(treeSPMua.add(new SanPhamMua("SP001", 2))?" Them thanh cong":"SP da ton tai trong danh sach");
		System.out.println(treeSPMua.add(new SanPhamMua("SP002", 2))?" Them thanh cong":"SP da ton tai trong danh sach");
		System.out.println(treeSPMua.add(new SanPhamMua("SP002", 2))?" Them thanh cong":"SP da ton tai trong danh sach");
		System.out.println(treeSPMua.add(new SanPhamMua("SP003", 1))?" Them thanh cong":"SP da ton tai trong danh sach");
		System.out.println(treeSPMua.add(new SanPhamMua("SP004", 5))?" Them thanh cong":"SP da ton tai trong danh sach");
		System.out.println(treeSPMua.add(new SanPhamMua("SP005", 3))?" Them thanh cong":"SP da ton tai trong danh sach");
		System.out.println("Kich thuoc cua treeSet: "+ treeSPMua.size());
		System.out.println("Sap xep giam dan theo sluong mua: ");
		for(SanPhamMua sp : treeSPMua) {
			System.out.println(sp);
		}
	}
	public static void main_Set_Object() {
		// HashSet: dua ham equals va ham hashCode cua doi tuong để check trùng
		Set<SanPhamMua> dsSPMua = new HashSet<SanPhamMua>();
		System.out.println(dsSPMua.add(new SanPhamMua("SP001", 2))?" Them thanh cong":"SP da ton tai trong danh sach");
		System.out.println("Check contains SanPhamMua(\"SP001\", 2): "+dsSPMua.contains(new SanPhamMua("SP001", 2)) );
		System.out.println(dsSPMua.add(new SanPhamMua("SP001", 2))?" Them thanh cong":"SP da ton tai trong danh sach");
		System.out.println(dsSPMua.add(new SanPhamMua("SP002", 4))?" Them thanh cong":"SP da ton tai trong danh sach");
		System.out.println(dsSPMua.add(new SanPhamMua("SP002", 4))?" Them thanh cong":"SP da ton tai trong danh sach");
		System.out.println(dsSPMua.add(new SanPhamMua("SP003", 1))?" Them thanh cong":"SP da ton tai trong danh sach");
		System.out.println(dsSPMua.add(new SanPhamMua("SP004", 5))?" Them thanh cong":"SP da ton tai trong danh sach");
		System.out.println(dsSPMua.add(new SanPhamMua("SP004", 5))?" Them thanh cong":"SP da ton tai trong danh sach");
		System.out.println("So luong spmua: "+ dsSPMua.size());
		System.out.println("Ds sp mua chua sap xep: ");
		for(SanPhamMua sp : dsSPMua) {
			System.out.println(sp);
		}
		List<SanPhamMua> listSPMua = new ArrayList<SanPhamMua>(dsSPMua);
		Collections.sort(listSPMua); // comparable hoac comparator
		System.out.println("Sap xep giam dan so luong mua: ");
		for(SanPhamMua sp : listSPMua) {
			System.out.println(sp);
		}
	}
	public static void main_Set() {
		Set<String> dsMaNhomHang = new HashSet<String>();
		// them 1 phan tu vao
		dsMaNhomHang.add("SS");
		System.out.println(dsMaNhomHang.add("DT")?" Them thanh cong":"DT da ton tai trong danh sach");
		System.out.println(dsMaNhomHang.add("DT")?" Them thanh cong":"DT da ton tai trong danh sach");
		System.out.println(dsMaNhomHang.add("MT")?" Them thanh cong":"MT da ton tai trong danh sach");
		System.out.println(dsMaNhomHang.add("MT")?" Them thanh cong":"MT da ton tai trong danh sach");
		System.out.println(dsMaNhomHang.add("TB")?" Them thanh cong":"TB da ton tai trong danh sach");
		// kich thuoc cua set
		System.out.println("Kich thuoc cua ds: "+ dsMaNhomHang.size());
		// xoa 1 phan tu cua set: remove
		System.out.println(dsMaNhomHang.remove("MMT")?"Xoa thanh cong":"MMT khong ton tai trong danh sach");
		// duyet set
		System.out.println("Duyet Set foreach: ");
		for(String tmp : dsMaNhomHang) {
			System.out.print(tmp + "   ");
		}
		System.out.println();
		System.out.println("Duyet Set iterator: ");
		Iterator<String> iteHashSet = dsMaNhomHang.iterator();
		while (iteHashSet.hasNext()) {
			String tmp = iteHashSet.next();
			System.out.print(tmp + "  ");
		}
		System.out.println();
		List<String> listDsMaNhomHang = new ArrayList<String>(dsMaNhomHang);
		// sap xep
		Collections.sort(listDsMaNhomHang);
		System.out.println("Sap xep tang dan ma nhom hang foreach: ");
		for(String tmp : listDsMaNhomHang) {
			System.out.print(tmp + "   ");
		}
		System.out.println();
		
		// Set có sắp xếp
		Set<String> treeMaNhomHang = new TreeSet<String>(dsMaNhomHang);
		System.out.println("Kich thuoc cua tree: "+ treeMaNhomHang.size());
		// duyet
		System.out.println("Duyet TreeSet iterator: ");
		Iterator<String> iteTreeSet = treeMaNhomHang.iterator();
		while (iteTreeSet.hasNext()) {
			String tmp = iteTreeSet.next();
			System.out.print(tmp + "  ");
		}
		System.out.println();
	}
	public static void main_List() {
		List dsdoituong = new ArrayList(); // cac phan tu : object
		// thêm 1 phần tử:
		dsdoituong.add(100);
		dsdoituong.add(100);
		dsdoituong.add("Dungpt");
		dsdoituong.add(11.1f);
		dsdoituong.add(true);
		// cu the hoa kieu phan tu
		List<String> listTenSv = new ArrayList<String>();
		// them 1 phan tu
		listTenSv.add("Hai");
		listTenSv.add(1, "Ngoc");
		// them 1 ds khac vao ds hien tai
		List<String> listTenSvChirld = new ArrayList<String>();
		listTenSvChirld.add("AA");
		listTenSvChirld.add("BB");
		listTenSv.addAll(listTenSvChirld);
		listTenSv.add("Hai");
		listTenSv.add("Ngoc");
		// kich thuoc ds
		System.out.println("Kich thuoc: "+ listTenSv.size());
		// duyet:
		// for i -> index
		
		// foreach
		
		// iterator
		System.out.println("Duyet iterator: ");
		Iterator<String> iter = listTenSv.iterator();
		while (iter.hasNext()) {
			// lay tung phan tu trong con duyet
			String item = iter.next();
			System.out.print(item + "\t");
		}
		System.out.println();
		// listiterator
		System.out.println("Duyet listiterator (duyet nguoc): ");
		ListIterator<String> listIter = listTenSv.listIterator(listTenSv.size());
		while (listIter.hasPrevious()) {
			String item = listIter.previous();
			System.out.print(item + "\t");
		}
		// chứa: contains
		System.out.println("phần tử Dung có trong ds: "+ listTenSv.contains("Dung"));
		// xóa: remove
		listTenSv.remove("Huyen");
		// lay 1 phần tử theo index: get
		System.out.println("Lấy phần tử đàu tiên trong ds: "+ listTenSv.get(0));
		// cập nhật phần tử theo index: set
		listTenSv.set(1, "Anh");
		listTenSv.add(1,"XXX");
		System.out.println("Duyet iterator: ");
		iter = listTenSv.iterator();
		while (iter.hasNext()) {
			// lay tung phan tu trong con duyet
			String item = iter.next();
			System.out.print(item + "\t");
		}
	}
}
