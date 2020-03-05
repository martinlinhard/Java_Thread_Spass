/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import javax.swing.JLabel;

/**
 *
 * @author martin
 */
public class Account {

	private double balance;
	private JLabel balanceLabel;

	public Account(JLabel lb) {
		this.balance = 50;
		this.balanceLabel = lb;
	}

	public boolean performTransaction(double amount) {
		System.out.println("changing balance");
		System.out.println((this.balanceLabel == null)+ "");
		this.balanceLabel.setText(this.balance + " €");
		if (amount < 0 && this.balance - amount < 0) {
			return false;
		} else {
			this.balance += amount;
			return true;
		}

	}
}
