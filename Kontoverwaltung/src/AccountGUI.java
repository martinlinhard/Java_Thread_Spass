
import bl.Account;
import bl.AccountListModel;
import bl.AccountUser;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martin
 */
public class AccountGUI extends javax.swing.JFrame {
	private AccountListModel acm;
	private Account acc;

	/**
	 * Creates new form AccountGUI
	 */
	public AccountGUI() {
		initComponents();
		this.acc = new Account(this.jLabel1);
		this.attachList();
	}

	private void attachList() {
		List<AccountUser> accs = new ArrayList<>();
		this.acm = new AccountListModel(accs);
		this.account_list.setModel(this.acm);
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPopupMenu1 = new javax.swing.JPopupMenu();
                m_add_user = new javax.swing.JMenuItem();
                m_perform_test = new javax.swing.JMenuItem();
                jPopupMenu2 = new javax.swing.JPopupMenu();
                m_create_account = new javax.swing.JMenuItem();
                jScrollPane1 = new javax.swing.JScrollPane();
                account_list = new javax.swing.JList<>();
                jScrollPane2 = new javax.swing.JScrollPane();
                jTextArea1 = new javax.swing.JTextArea();
                jLabel1 = new javax.swing.JLabel();

                m_add_user.setText("Add User");
                m_add_user.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                m_add_userActionPerformed(evt);
                        }
                });
                jPopupMenu1.add(m_add_user);

                m_perform_test.setText("Perform Account Test");
                m_perform_test.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                m_perform_testActionPerformed(evt);
                        }
                });
                jPopupMenu1.add(m_perform_test);

                m_create_account.setText("New Account");
                m_create_account.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                m_create_accountActionPerformed(evt);
                        }
                });
                jPopupMenu2.add(m_create_account);

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                account_list.setBorder(javax.swing.BorderFactory.createTitledBorder("Users"));
                account_list.setComponentPopupMenu(jPopupMenu1);
                jScrollPane1.setViewportView(account_list);

                getContentPane().add(jScrollPane1, java.awt.BorderLayout.LINE_START);

                jTextArea1.setColumns(20);
                jTextArea1.setRows(5);
                jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder("Log"));
                jScrollPane2.setViewportView(jTextArea1);

                getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                jLabel1.setText("638,00€");
                jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Account"));
                getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_END);

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void m_add_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_add_userActionPerformed
		String res = JOptionPane.showInputDialog("Add user...");
		AccountUser au = new AccountUser(acc, res, this.jTextArea1);
		this.acm.addUser(au);
        }//GEN-LAST:event_m_add_userActionPerformed

        private void m_create_accountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_create_accountActionPerformed
                this.acc = new Account(this.jLabel1);
        }//GEN-LAST:event_m_create_accountActionPerformed

        private void m_perform_testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_perform_testActionPerformed
		try {
			this.acm.simulate();
		} catch (InterruptedException ex) {
			System.out.println("here");
		}
        }//GEN-LAST:event_m_perform_testActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(AccountGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AccountGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AccountGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AccountGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AccountGUI().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JList<AccountUser> account_list;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JPopupMenu jPopupMenu1;
        private javax.swing.JPopupMenu jPopupMenu2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JTextArea jTextArea1;
        private javax.swing.JMenuItem m_add_user;
        private javax.swing.JMenuItem m_create_account;
        private javax.swing.JMenuItem m_perform_test;
        // End of variables declaration//GEN-END:variables
}