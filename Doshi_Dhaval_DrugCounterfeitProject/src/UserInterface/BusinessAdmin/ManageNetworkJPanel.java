/*
 * ManageNetworkJPanel.java
 *
 * Created on September 24, 2008, 2:40 PM
 */
package UserInterface.BusinessAdmin;

import Business.Business;
import Business.Network.Network;
import Business.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Dhaval
 */
public class ManageNetworkJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    UserAccount userAccount;

    /** Creates new form ManageNetworkJPanel */
    public ManageNetworkJPanel(JPanel userProcessContainer,UserAccount user) {
        initComponents();
        this.userProcessContainer =userProcessContainer;
        userAccount = user;
        Refresh();
    }
        private void Refresh()
        {
        int rowCount = tableNetwork.getRowCount();
        for(int i = rowCount-1; i >= 0; i--)
        {
            ((DefaultTableModel)tableNetwork.getModel()).removeRow(i);
        }

        for (Network n : Business.getInstance().getNetworkDirectory().getNetworkList())
        {
            Object row [] = new Object[2];
            row[0] = n;
            row[1] = n.getNetworkCountry();

            ((DefaultTableModel)tableNetwork.getModel()).addRow(row);
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableNetwork = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("Manage Network");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        tableNetwork.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableNetwork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Network  Name", "Network Country"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableNetwork);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 500, 90));

        btnView.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnView.setText("View Network >>");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 240, -1));

        btnCreate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCreate.setText("Create New Network ");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 110, -1));

        btnRefresh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRefresh.setMargin(new java.awt.Insets(2, 1, 2, 1));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 120, -1));
    }// </editor-fold>//GEN-END:initComponents
    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableNetwork.getSelectedRow();
        if(selectedRow < 0 || selectedRow > tableNetwork.getRowCount() )
        {
        JOptionPane.showMessageDialog(null,"Select a Row");
            return;}
        Network network = (Network)tableNetwork.getValueAt(selectedRow, 0);
        ViewNetworkJPanel vpdjp = new ViewNetworkJPanel(userProcessContainer ,network);
        userProcessContainer.add("ViewNetwork",vpdjp);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        CreateNewNetworkJPanel createNewNetworkJPanel  = new CreateNewNetworkJPanel(userProcessContainer,userAccount);
        userProcessContainer.add("CreateNewNetwork",createNewNetworkJPanel);
        CardLayout cardLayout = (CardLayout)userProcessContainer.getLayout();
        cardLayout.next(userProcessContainer);    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout)(userProcessContainer.getLayout());
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        Refresh();
}//GEN-LAST:event_btnRefreshActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tableNetwork;
    // End of variables declaration//GEN-END:variables
}
