/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package bl;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author martin
 */
public class AccountUser implements Runnable {

	public static final int TRIES = 10;
	public static final Random random = new Random();

	private Account commonAcc;
	private String name;
	private JTextArea output;

	public AccountUser(Account commonAcc, String name, JTextArea area) {
		this.commonAcc = commonAcc;
		this.name = name;
		this.output = area;
	}

	@Override
	public void run() {
		for (int i = 0; i < TRIES; i++) {
			int amount = random.nextInt(41) + 10;
			if (random.nextBoolean()) {
				amount = amount * -1;
			}
			synchronized (this.commonAcc) {
				System.out.println("helloo");
				while (!this.commonAcc.performTransaction(amount)) {
					try {
						this.output.append(this.name + " is waiting for transaction...");
						this.commonAcc.wait(2000);
						this.output.append(this.name + " finished waiting for transaction...");
					} catch (InterruptedException ex) {
						System.out.println("hallo elias es geht nt");
					}
				}
				this.output.append(this.name + " performed transaction of " + amount + " €");
				this.commonAcc.notifyAll();
			}
		}
	}

	@Override
	public String toString() {
		return this.name;
	}

}
