package Session4.daluong;

public class Account {
    public long balance;

    public Account(long balance) {
        super();
        this.balance = balance;
    }

    public synchronized void withdraw(String ngRut, long amount) {
        if (amount > balance) {
            System.out.println(ngRut + " rut: " + amount + " tk có: " + balance + " => tien khong du");
        } else {
            System.out.println(ngRut + " rut: " + amount + " tk có: " + balance + " => rut thanh cong");
            balance -= amount;
            System.out.println(ngRut + " da rut, so tien con lai " + balance);
        }
    }

    public void withdraw2(String ngRut, long amount) {
        synchronized (this) {
            if (amount > balance) {
                System.out.println(ngRut + " rut: " + amount + " tk có: " + balance + " => tien khong du");
            } else {
                System.out.println(ngRut + " rut: " + amount + " tk có: " + balance + " => rut thanh cong");
                balance -= amount;
                System.out.println(ngRut + " da rut, so tien con lai " + balance);
            }
        }
    }
}
