/*
 * CreateEnterpriseJPanel.java
 *
 * Created on September 18, 2008, 2:54 PM
 */
package UserInterface.NetworkAdmin;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.UserAccount;
import UserInterface.Validate;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author Dhaval
 */
public class CreateEnterpriseJPanel extends javax.swing.JPanel {
    JPanel userProcessContainer;
    Enterprise enterprise;
    UserAccount userAccount;

    /** Creates new form CreateEnterpriseJPanel */
    public CreateEnterpriseJPanel(JPanel userProcessContainer,UserAccount userAccount){
        initComponents();
        lblWelcome.setText("Welcome : Network Admin");
        this.userAccount = userAccount;
        this.userProcessContainer =userProcessContainer;
        typeJComboBox.removeAllItems();
        typeJComboBox.addItem(Enterprise.HOSPITAL);
        typeJComboBox.addItem(Enterprise.FDA);
        typeJComboBox.addItem(Enterprise.WHOLESALER);
        typeJComboBox.addItem(Enterprise.MANUFACTURER);
        typeJComboBox.addItem(Enterprise.RETAILPHARMACY);
        typeJComboBox.addItem(Enterprise.STATEREGULATOR);
        typeJComboBox.addItem(Enterprise.LAWENFORCEMENT);
        typeJComboBox.addItem(Enterprise.NETWORK);


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnAddNetwork = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblWelcome = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        typeJComboBox = new javax.swing.JComboBox();
        lblName1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("Create Enterprise");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        btnAddNetwork.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAddNetwork.setText("Add Enterprise");
        btnAddNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNetworkActionPerformed(evt);
            }
        });
        add(btnAddNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 160, -1));

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        lblName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblName.setText("Enterprise Name:");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 170, 30));

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 230, -1));

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblWelcome.setText("WELCOME");
        add(lblWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 270, 20));

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAdd.setText("Add Admin");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 160, -1));

        typeJComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(typeJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 230, 30));

        lblName1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblName1.setText("Select type");
        add(lblName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 170, 30));
    }// </editor-fold>//GEN-END:initComponents
    private void btnAddNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNetworkActionPerformed
    // TODO add your handling code here:
        if(!Validate.validateTextField(txtName,lblName,0))
        {
            return;
        }
        if(typeJComboBox.getSelectedItem() == null)
        {
            JOptionPane.showMessageDialog(null, "Select a type");
            return;
        }
        Network network = (Network)Business.getInstance().getNetworkDirectory().searchUser(userAccount, Network.class.getSimpleName());
        enterprise = network.getEnterpriseDirectory().newEnterprise(txtName.getText(),(String)typeJComboBox.getSelectedItem());

        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Enterprise Added "
                + "\n Do you want to add an enterprise admin?",null,JOptionPane.YES_NO_OPTION );
        if(showConfirmDialog == JOptionPane.YES_OPTION )
        {
            txtName.setText("");
            AddAdminJPanel aajp =new AddAdminJPanel(userProcessContainer,userAccount,enterprise);
            userProcessContainer.add("Add admin",aajp);
            CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
            cardLayout.next(userProcessContainer);

        }
        else
        {
            userProcessContainer.remove(this);
            CardLayout cardLayout = (CardLayout)(userProcessContainer.getLayout());
            cardLayout.previous(userProcessContainer);
        }

}//GEN-LAST:event_btnAddNetworkActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout)(userProcessContainer.getLayout());
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        AddAdminJPanel aajp =new AddAdminJPanel(userProcessContainer,userAccount,enterprise);
        userProcessContainer.add("Add admin",aajp);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddNetwork;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTextField txtName;
    private javax.swing.JComboBox typeJComboBox;
    // End of variables declaration//GEN-END:variables
}
