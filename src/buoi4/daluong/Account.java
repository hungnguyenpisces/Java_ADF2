package buoi4.daluong;

public class Account {
	public long amount;

	public Account(long amount) {
		super();
		this.amount = amount;
	}
	// rut tien
	public void withdraw(String ngRut, long sotienRut) {
		synchronized(this) {
			if (sotienRut > amount) {
				System.out.println(ngRut + " rut: " + sotienRut + ", tk co: "+amount+"; Khong du so tien");
			} else {
					System.out.println(ngRut + " rut: " + sotienRut + ", tk co: "+amount+"; thanh cong");
					amount -= sotienRut;
					System.out.println(ngRut + "; tai khoan: "+ amount);
			}
			}
	}
	public synchronized void withdraw2(String ngRut, long sotienRut) {
		if (sotienRut > amount) {
			System.out.println(ngRut + " rut: " + sotienRut + ", tk co: "+amount+"; Khong du so tien");
		} else {
			System.out.println(ngRut + " rut: " + sotienRut + ", tk co: "+amount+"; thanh cong");
			amount -= sotienRut;
			System.out.println(ngRut + "; tai khoan: "+ amount);
		}
	}
}
