package Session4.daluong;

public class SynchronizeMain {
    public static void main(String[] args) {
        Account myAccount = new Account(10000);
        WithdrawThread withdrawThread1 = new WithdrawThread(myAccount, "A1");
        WithdrawThread withdrawThread2 = new WithdrawThread(myAccount, "B2");
        WithdrawThread withdrawThread3 = new WithdrawThread(myAccount, "C3");

        withdrawThread1.start();
        withdrawThread3.start();
        withdrawThread2.start();
    }
}
