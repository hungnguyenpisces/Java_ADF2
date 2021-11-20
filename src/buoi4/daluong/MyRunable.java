package buoi4.daluong;

public class MyRunable implements Runnable{
	@Override
	public void run() {
		System.out.println("Start thread t2");
		for(int i=10; i< 20; i++) {
			System.out.println(i);
			// chủ động thread/ luồng đi ngủ/ sleep 1 thời gian, hết thời gian đó lại trở lại runable - thực hiện tiếp
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("End thread t2");
	}

}
