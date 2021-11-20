package Session4.daluong;

public class MyRunable implements Runnable {
    @Override
    public void run() {
        System.out.println("star run thread runable");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("end run thread runable");
    }
}
