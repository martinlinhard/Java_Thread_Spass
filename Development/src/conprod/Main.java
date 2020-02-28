/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conprod;

/**
 *
 * @author martin
 */
public class Main {

	private static final int AMOUNT = 5;

	public static void main(String[] args) {
		Stack s = new Stack(5);
		Producer p = new Producer(s, AMOUNT);
		Consumer c = new Consumer(s, AMOUNT);

		Thread pThread = new Thread(p);
		Thread cThread = new Thread(c);

		pThread.start();
		cThread.start();
	}
	
}
