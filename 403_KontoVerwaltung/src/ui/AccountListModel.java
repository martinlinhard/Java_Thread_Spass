/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import bl.AccountUser;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author martin
 */
public class AccountListModel extends AbstractListModel<AccountUser>{
    private List<AccountUser> users = new ArrayList<>();
    
    @Override
    public int getSize() {
        return users.size();
    }

    @Override
    public AccountUser getElementAt(int index) {
        return users.get(index);
    }

    public void addUser(AccountUser user){
        users.add(user);
        this.fireContentsChanged(users, 0, users.size());
    }
    
    public List<AccountUser> getUsers(){
        return users;
    }
}
