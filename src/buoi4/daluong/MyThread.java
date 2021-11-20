package buoi4.daluong;

public class MyThread extends Thread{
	Thread other;
	public MyThread(Thread other) {
		this.other = other;
	}
	@Override
	public void run() {
		if (other != null) {
			// luong other duoc uu tien thuc thi / ket thuc truoc luong hien tai
			try {
				other.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Start thread t1");
		for (int i=0; i< 10; i++) {
			System.out.println(i);
		}
		System.out.println("End thread t1");
	}
}
