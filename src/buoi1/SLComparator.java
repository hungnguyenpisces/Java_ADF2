package buoi1;

import java.util.Comparator;
import java.util.Map;

public class SLComparator implements Comparator<String> {

    Map<String, Integer> dsMap;

    public SLComparator(Map<String, Integer> dsMap) {
        super();
        this.dsMap = dsMap;
    }

    @Override
    public int compare(String o1, String o2) {
        //sap xep theo soluong
        // Integer soLuong1 = dsMap.get(o1);
        // Integer soLuong2 = dsMap.get(o2);
        // return soLuong2.compareTo(soLuong1);
        
        //sap xep theo ten
        return dsMap.get(o1) - dsMap.get(o2);
    }

}
