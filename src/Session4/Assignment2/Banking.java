package Session4.Assignment2;

public class Banking {
    public static void main(String[] args) {
        Account acc1 = new Account(10000);

        NoLe nl1 = new NoLe(acc1, "Trụ Cột");
        ChuNo cn1 = new ChuNo(acc1, "NÓC NHÀ");
        ChuNo cn2 = new ChuNo(acc1, "Tàu Há Mồm");
        nl1.start();
        cn1.start();
        cn2.start();

    }

}

class NoLe extends Thread {
    Account shareAccount;
    String name;

    public NoLe(Account shareAccount, String name) {
        super();
        this.shareAccount = shareAccount;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            shareAccount.deposit(name, 1000);
            // shareAccount.withdraw(name, 100);
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ChuNo extends Thread {
    Account shareAccount;
    String name;

    public ChuNo(Account shareAccount, String name) {
        super();
        this.shareAccount = shareAccount;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            long amount;
            if (name.charAt(0) == 'T') {
                amount = (long) (Math.random() * 100);
            } else {
                amount = (long) (Math.random() * 3000);
            }
            shareAccount.withdraw(name, amount);
            try {
                sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Account {
    public long balance;

    public Account(long balance) {
        super();
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public synchronized void withdraw(String ngRut, long amount) {
        if (amount > balance) {
            System.out.println(ngRut + " rút: " + amount + " tk có: " + balance
                    + " => số dư không đủ, HẾT TIỀN RỒI TRỤ CỘT ƠI");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            balance -= amount;
            System.out.println(ngRut + " rut: " + amount + "  => rút thành công => số tiền còn lại " + balance);
        }
    }

    public synchronized void deposit(String ngNap, long amount) {
        balance += amount;
        System.out.println(ngNap + " nap: " + amount + " tk có: " + balance);
        if (balance >= 3000) {
            System.out.println("lại có tiền rồi đó mấy mẹ, tiêu vừa thôi".toUpperCase());
            notify();
        }
    }
}