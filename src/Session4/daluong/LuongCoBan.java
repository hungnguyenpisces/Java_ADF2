package Session4.daluong;

public class LuongCoBan {
    public static void main(String[] args) {
        System.out.println("start main");
        Thread currentThread = Thread.currentThread();
        System.out.println("current thread: " + currentThread.getName() + " " + currentThread.getId() + "state "
                + currentThread.getState() + currentThread.getPriority());

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        MyThread myThread = new MyThread();
        myThread.start();

        MyRunable myRunable = new MyRunable();
        Thread threadRunable = new Thread(myRunable);
        threadRunable.start();
        System.out.println(threadRunable.getName() + " " + threadRunable.getId() + "state " + threadRunable.getState()
                + threadRunable.getPriority());

        System.out.println("end main");
    }
}
