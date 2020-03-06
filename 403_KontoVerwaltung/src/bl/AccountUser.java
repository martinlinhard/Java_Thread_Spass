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
import javax.swing.SwingUtilities;

/**
 *
 * @author martin
 */
public class AccountUser implements Runnable {

	private String name;
	private Account sharedAccount;
	private JTextArea output;

	public static final int TRIES = 10;
	public static final Random RANDOM = new Random();

	public AccountUser(String name, Account sharedAccount, JTextArea output) {
		this.name = name;
		this.sharedAccount = sharedAccount;
		this.output = output;
	}

	public String getName() {
		return name;
	}

	public void setSharedAccount(Account sharedAccount) {
		this.sharedAccount = sharedAccount;
	}

	public void setOutput(JTextArea output) {
		this.output = output;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public void run() {
		int deadlockCount = 0;
		for (int i = 0; i < TRIES; i++) {
			deadlockCount = 0;
			try {
				int amount = RANDOM.nextInt(41) + 10;

				if (RANDOM.nextBoolean()) {
					amount *= -1; //randomly decide whether the amount is positive / negative
				}

				synchronized (sharedAccount) {
					this.writeToOutputSYNC(this.name + " is attempting an transaction of " + amount + " €!" + "\n");
					while ((sharedAccount.getBalance() + amount) < 0 && deadlockCount < 3) {
						try {
							this.writeToOutputSYNC(name + " is waiting for other transactions.\n");
							sharedAccount.wait(2000);
							deadlockCount++;
							this.writeToOutputSYNC(name + " has finished waiting for other transactions!\n");
						} catch (InterruptedException ex) {
						}
					}

					if (deadlockCount >= 3) {
						i--;
						continue;
					}

					sharedAccount.performTransaction(amount);
					this.writeToOutputSYNC(name + " completed transaction of " + amount + " €!\n");
					sharedAccount.notifyAll();
				}

				Thread.sleep(RANDOM.nextInt(1000) + 1);
			} catch (InterruptedException ex) {
			}
		}

		this.writeToOutputSYNC("  --> " + name + " has finished all of its transactions.\n");
	}

	//This method is required since maninpulating it from without the event thread can lead to UB (=crashes...)
	private void writeToOutputSYNC(String text) {
		SwingUtilities.invokeLater(() -> {
			output.append(text);
		});
	}
}
