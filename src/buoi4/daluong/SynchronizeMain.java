package buoi4.daluong;

public class SynchronizeMain {

	public static void main(String[] args) {
		Account myAccount = new Account(10000);
		WithdrawThread t1 = new WithdrawThread(myAccount, "T1");
		WithdrawThread t2 = new WithdrawThread(myAccount, "T2");
		WithdrawThread t3 = new WithdrawThread(myAccount, "T3");
		t1.start();
		t2.start();
		t3.start();
	}

}
