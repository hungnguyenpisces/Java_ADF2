package buoi4.daluong;

public class WithdrawThread extends Thread{
	Account shareAcc;
	String name;
	public WithdrawThread(Account shareAcc, String name) {
		super();
		this.shareAcc = shareAcc;
		this.name = name;
	}
	@Override
	public void run() {
		for(int i=0; i < 5; i++) {
			shareAcc.withdraw(name, 2000);
		}
	}
}
