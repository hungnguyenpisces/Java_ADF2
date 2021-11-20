package buoi4.daluong;

public class LuongCoBan {
	// 1 chuong trình java runtime -> process jvm -> có 1 thread/luồng main
	public static void main(String[] args) {
			System.out.println("Start main thread");
			Thread currThread = Thread.currentThread();
			System.out.println("Ten thread: "+ currThread.getName() + "; state: "+ currThread.getState() + "; priority: "+currThread.getPriority() );
			
			MyRunable myRun = new MyRunable();
			// tao 1 thread moi qua Runnable
			Thread t2 = new Thread(myRun);
			t2.start();
			
			// tao ra 1 doi tuong Thread 
			MyThread t1 = new MyThread(t2);
			// start 1 thread -> start
			t1.start(); // 1 luong moi se bat dau runtime
			// t1.join() viet trong pham vi runtime cua Main: t1 phai thuc hien xong thi main moi duoc ket thuc
			try {
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("T1 priority: "+ t1.getPriority());
			
			try {
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("T2 priority: "+ t2.getPriority());
			
			System.out.println("End main thread");
			
	}

}
