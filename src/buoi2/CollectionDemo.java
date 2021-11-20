package buoi2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import buoi1.SLComparator;

public class CollectionDemo {
    public static void main(String[] args) {
        main_Map();
    }

    public static void main_Map() {
        // HashMap
        Map<String, Integer> mapSP = new HashMap<String, Integer>();
        mapSP.put("sp001", 1);
        mapSP.put("sp001", 10);
        mapSP.put("sp001", 9);
        mapSP.put("sp002", 8);
        mapSP.put("sp003", 7);
        mapSP.put("sp004", 6);
        mapSP.put("sp005", 5);
        mapSP.put("sp006", 4);
        mapSP.put("sp007", 3);
        mapSP.put("sp008", 2);
        mapSP.put("sp009", 1);
        // duyet map
        Set<String> keys = mapSP.keySet();
        for (String key : keys) {
            System.out.println(key + ": " + mapSP.get(key));
        }
        System.out.println();
        Set<Map.Entry<String, Integer>> entries = mapSP.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
        // sap xep
        Set<Map.Entry<String, Integer>> treeSet = new TreeSet<Map.Entry<String, Integer>>(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                });
        treeSet.addAll(entries);
        for (Map.Entry<String, Integer> entry : treeSet) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
        // săp xep
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(entries);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
        System.out.println("tree map");
        System.out.println();
        // TreeMap
        SLComparator slComparator = new SLComparator(mapSP);
        Map<String, Integer> treeMap = new TreeMap<String, Integer>(slComparator);
        treeMap.putAll(mapSP);
        Set<String> keys2 = treeMap.keySet();
        for (String key : keys2) {
            System.out.println(key + ": " + treeMap.get(key));
        }

    }

    public static void main_List() {
        List dsObj = new ArrayList();
        dsObj.add(100);
        dsObj.add(100);
        dsObj.add("hungnv");
        dsObj.add(false);

        List<String> dsSV = new ArrayList<String>();
        dsSV.add("Hung");
        dsSV.add(1, "Hung");
        dsSV.add(0, "Nguyen");

        List<String> dsSV2 = new ArrayList<String>();
        dsSV2.add("Hung");
        dsSV2.add("Nguyen");
        dsSV.addAll(dsSV2);

        System.out.println(dsSV.size());
        System.out.println("duyet xuoi");
        Iterator<String> it = dsSV.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("duyet nguoc");
        ListIterator<String> it2 = dsSV.listIterator(dsSV.size());
        while (it2.hasPrevious()) {
            System.out.println(it2.previous());
        }
    }

    // tree set
    public static void main_TreeSet_Obj() {
        Set<SanPhamMua> dsSP = new TreeSet<SanPhamMua>(new Comparator<SanPhamMua>() {
            @Override
            public int compare(SanPhamMua o1, SanPhamMua o2) {
                if (o1 == null || o2 == null)
                    return 0;
                int checkTrung = o1.getMaSP().compareTo(o2.getMaSP());
                if (checkTrung == 0) {
                    return 0;
                }
                int checkSL = o2.getSoLuong().compareTo(o1.getSoLuong());
                if (checkSL == 0) {
                    return -1;
                }
                return checkSL;
            }
        });
        System.out.println(dsSP.add(new SanPhamMua("SP001", 2)) ? "them thanh cong" : "Sp da ton tai");
        System.out.println(dsSP.add(new SanPhamMua("SP001", 3)) ? "them thanh cong" : "Sp da ton tai");
        System.out.println(dsSP.add(new SanPhamMua("SP002", 2)) ? "them thanh cong" : "Sp da ton tai");
        System.out.println(dsSP.add(new SanPhamMua("SP002", 6)) ? "them thanh cong" : "Sp da ton tai");
        System.out.println(dsSP.add(new SanPhamMua("SP003", 5)) ? "them thanh cong" : "Sp da ton tai");
        System.out.println(dsSP.add(new SanPhamMua("SP004", 5)) ? "them thanh cong" : "Sp da ton tai");
        System.out.println(dsSP.add(new SanPhamMua("SP004", 5)) ? "them thanh cong" : "Sp da ton tai");
        System.out.println(dsSP.add(new SanPhamMua("SP005", 4)) ? "them thanh cong" : "Sp da ton tai");
        System.out.println(dsSP.add(new SanPhamMua("SP006", 3)) ? "them thanh cong" : "Sp da ton tai");

        System.out.println("kich thuoc : " + dsSP.size());
        System.out.println(dsSP);
        // Iterator<SanPhamMua> it = dsSP.iterator();
        // while (it.hasNext()) {
        // System.out.println(it.next());
        // }
    }

    public static void main_Set_Obj() {
        Set<SanPhamMua> dsSP = new HashSet<SanPhamMua>();
        dsSP.add(new SanPhamMua("Iphone", 3));
        dsSP.add(new SanPhamMua("Iphone", 3));
        dsSP.add(new SanPhamMua("Iphone1", 7));
        dsSP.add(new SanPhamMua("Iphone12", 2));
        dsSP.add(new SanPhamMua("Iphone123", 3));
        dsSP.add(new SanPhamMua("Iphone1234", 9));
        dsSP.add(new SanPhamMua("Iphone12345", 7));
        dsSP.add(new SanPhamMua("Iphone123456", 6));
        dsSP.add(new SanPhamMua("Iphone1234567", 4));
        System.out.println("check contains: " + dsSP.contains(new SanPhamMua("Iphone", 3)));
        dsSP.add(new SanPhamMua("Iphone12345678", 5));
        dsSP.add(new SanPhamMua("Iphone123456789", 1));

        System.out.println("so luong spmua : " + dsSP.size());
        System.out.println();
        System.out.println("duyet iterator");
        Iterator<SanPhamMua> it = dsSP.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();
        // sap xep
        System.out.println("sap xep giam dan theo so luong mua");

        List<SanPhamMua> dsSP2 = new ArrayList<SanPhamMua>(dsSP);
        Collections.sort(dsSP2);
        for (SanPhamMua spm : dsSP2) {
            System.out.println(spm);
        }

    }

    public static void main_Set() {
        Set<String> dsMaNhomHang = new HashSet<String>();
        System.out.println(dsMaNhomHang.add("Nhom1") ? "them thanh cong" : "them that bai");
        System.out.println(dsMaNhomHang.add("Nhom5") ? "them thanh cong" : "them that bai");
        System.out.println(dsMaNhomHang.add("Nhom1") ? "them thanh cong" : "them that bai");
        System.out.println(dsMaNhomHang.add("Nhom2") ? "them thanh cong" : "them that bai");
        System.out.println(dsMaNhomHang.add("Nhom3") ? "them thanh cong" : "them that bai");
        System.out.println(dsMaNhomHang.add("Nhom4") ? "them thanh cong" : "them that bai");
        System.out.println(dsMaNhomHang.add("Nhom6") ? "them thanh cong" : "them that bai");
        System.out.println(dsMaNhomHang.add("Nhom7") ? "them thanh cong" : "them that bai");
        System.out.println(dsMaNhomHang.size());
        System.out.println(dsMaNhomHang.contains("Nhom1") ? "co" : "khong co");
        System.out.println(dsMaNhomHang.contains("Nhom2") ? "co" : "khong co");
        System.out.println(dsMaNhomHang.remove("Nhom3") ? "xoa thanh cong" : "xoa that bai");
        System.out.println(dsMaNhomHang.remove("Nhom7") ? "xoa thanh cong" : "xoa that bai");
        System.out.println(dsMaNhomHang.remove("Nhom8") ? "xoa thanh cong" : "xoa that bai");
        System.out.println("duyet foreach");
        for (String string : dsMaNhomHang) {
            System.out.println(string);
        }
        System.out.println("duyet iterator");
        Iterator<String> it = dsMaNhomHang.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        List<String> dsMaNhomHang2 = new ArrayList<String>(dsMaNhomHang);
        Collections.sort(dsMaNhomHang2);
        System.out.println("duyet sap xep ");
        for (String string : dsMaNhomHang2) {
            System.out.println(string);
        }

        System.out.println();
        Set<String> treeMaNhomHang = new TreeSet<String>(dsMaNhomHang);
        treeMaNhomHang.add("Nhom8");
        treeMaNhomHang.add("Nhom9");
        treeMaNhomHang.add("Nhom5");
        System.out.println("kich thuoc tree: " + treeMaNhomHang.size());
        System.out.println("duyet foreach tree");
        for (String string : treeMaNhomHang) {
            System.out.println(string);
        }
        System.out.println("duyet iterator tree");
        Iterator<String> it2 = treeMaNhomHang.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

    }

}
