/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package conprod;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author martin
 */
public class Producer implements Runnable {
	
	private Stack stack;
	private int cnt;
	private static final Random random = new Random();
	
	public Producer(Stack stack, int cnt) {
		this.stack = stack;
		this.cnt = cnt;
	}
	
	@Override
	public void run() {
		System.out.println("Producer started");
		for (int i =0;i < this.cnt;i++) {
			synchronized (stack) {
				while(stack.isFull()) {
					System.out.println("stack is full");
					try {
						System.out.println("Producer has to wait");
						stack.wait(); //releases lock for "stack" --> enable consumer to access the stack
						System.out.println("Finished waiting");
					} catch (InterruptedException ex) {
					}
				}
				System.out.println("Producer pushes to stack");
				stack.push(random.nextInt(100));
				stack.notify(); //tell the consumer that there is a new element on the (possibly empty) stack
				System.out.println(stack);
			}
			try {
				Thread.sleep(random.nextInt(1_000));
			} catch (InterruptedException ex) {
			}
		}
	}
}
