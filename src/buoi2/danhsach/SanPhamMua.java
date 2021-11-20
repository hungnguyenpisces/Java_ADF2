package buoi2.danhsach;

public class SanPhamMua implements Comparable<SanPhamMua>{
	private String maSp;
	private int soLuong;
	public SanPhamMua() {
		super();
	}
	public SanPhamMua(String maSp, int soLuong) {
		super();
		this.maSp = maSp;
		this.soLuong = soLuong;
	}
	public String getMaSp() {
		return maSp;
	}
	public void setMaSp(String maSp) {
		this.maSp = maSp;
	}
	public Integer getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Masp: "+ this.maSp + "; soluong: "+ this.soLuong;
	}
	@Override
	public boolean equals(Object arg0) {
		if (arg0 == null)
			return false;
		if (!(arg0 instanceof SanPhamMua))
			return false;
		if (this.maSp == null)
			return false;
		SanPhamMua other = (SanPhamMua)arg0;
		return this.maSp.equals(other.getMaSp());
	}
	@Override
	// tra ve 1 so dinh danh cua 1 doi tuong
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.maSp.hashCode();
	}
	@Override
	public int compareTo(SanPhamMua arg0) {
		// TODO Auto-generated method stub
		return arg0.getSoLuong().compareTo(this.getSoLuong());
	}
}
