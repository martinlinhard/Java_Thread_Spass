/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author martin
 */
public class Account {

	private double balance;
	private JLabel balanceLabel;

	public Account(JLabel balanceLabel) {
		this.balance = 50;
		this.balanceLabel = balanceLabel;
	}

	public double getBalance() {
		return balance;
	}

	public void performTransaction(int amount) {
		if (balance + amount < 0) {
			return; //make sure balance doesn't become negative
		}

		//valid balance --> perform transaction & print output
		balance += amount;

		SwingUtilities.invokeLater(() -> {
			balanceLabel.setText(String.format("%.2f", balance));
		});
	}

}
