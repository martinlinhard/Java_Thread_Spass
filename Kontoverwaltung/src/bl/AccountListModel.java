/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author martin
 */
public class AccountListModel extends AbstractListModel<AccountUser> {

	private List<AccountUser> users;
	private List<Thread> threads;

	public AccountListModel(List<AccountUser> users) {
		this.users = users;
	}

	public void simulate() throws InterruptedException {
		this.threads = new ArrayList<>();
		for (int i = 0; i < this.users.size(); i++) {
			this.threads.add(new Thread(this.users.get(i)));
			this.threads.get(i).start();
		}
	}

	@Override
	public int getSize() {
		return this.users.size();
	}

	@Override
	public AccountUser getElementAt(int i) {
		return this.users.get(i);
	}

	public void addUser(AccountUser ac) {
		this.users.add(ac);
		this.fireContentsChanged(this.users, 0, this.users.size());
	}

}
