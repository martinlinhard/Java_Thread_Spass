/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

/**
 *
 * @author martin
 */
public class NameThread implements Runnable {

	private StringBuilder sb = new StringBuilder(10_000_000);

	@Override
	public void run() {
		for (int i = 0; i < 100_000; i++) {
			//synchronized (sb) { //objekt wird gelockt
				sb.append(Thread.currentThread().getName());
			//}
		}
	}

	public StringBuilder getSb() {
		return sb;
	}

	public static void main(String[] args) {
		NameThread nt = new NameThread();
		Thread thread1 = new Thread(nt, "hallo");
		Thread thread2 = new Thread(nt, "hey");
		Thread thread3 = new Thread(nt, "hi");

		thread1.start();
		thread2.start();
		thread3.start();
		
		long start = System.currentTimeMillis();

		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException e) {

		}
		
		long dur = System.currentTimeMillis() - start;
		System.out.println("Duration: " + dur);
		System.out.println(nt.getSb().substring(0, 1_000));
	}

}
