package Session4.daluong;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("star run thread");
        for (int i = 0; i < 15; i++) {
            System.out.println(i);
        }
        System.out.println("end run thread");
    }
}
