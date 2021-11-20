package buoi2;

public class SanPhamMua implements Comparable<SanPhamMua> {
    private String maSP;
    private int soLuong;

    public SanPhamMua() {
    }

    public SanPhamMua(String maSP, int soLuong) {
        this.maSP = maSP;
        this.soLuong = soLuong;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "SanPhamMua{" + "maSP='" + maSP + '\'' + ", soLuong=" + soLuong + '}';
    }

    @Override
    public boolean equals(Object argO) {
        if (argO == null || !(argO instanceof SanPhamMua))
            return false;
        if (this.maSP == null)
            return false;

        SanPhamMua that = (SanPhamMua) argO;
        return this.maSP.equals(that.maSP);
    }

    @Override
    public int hashCode() {
        return maSP.hashCode();
    }

    @Override
    public int compareTo(SanPhamMua other) {

        return other.getSoLuong().compareTo(this.getSoLuong());
    }
}
