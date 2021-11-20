package Session4.daluong;

public class WithdrawThread extends Thread {
    Account shareAccount;
    String name;

    public WithdrawThread(Account shareAccount, String name) {
        super();
        this.shareAccount = shareAccount;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                shareAccount.withdraw(name, 2000);
            } else {
                shareAccount.withdraw2(name, 1000);
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
