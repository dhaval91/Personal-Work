/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BusinessAdminWorkAreaJPanel.java
 *
 * Created on Nov 2, 2012, 5:59:07 PM
 */
package UserInterface.LicensingManager;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.License;
import Business.Organization.Organization;
import Business.UserAccount;
import Business.WorkRequest.*;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dhaval
 */
public class DrugWorkQueueJPanel extends javax.swing.JPanel {

    //private Enterprise enterprise;
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;


    /** Creates new form BusinessAdminWorkAreaJPanel */
    public DrugWorkQueueJPanel(JPanel upc,  UserAccount ua) {
        initComponents();
        userProcessContainer = upc;
        userAccount = ua;
        refreshWorkRequestTable();
    }
    private void refreshWorkRequestTable()
    {
        int r = tableRequest.getRowCount();
        DefaultTableModel m = (DefaultTableModel)tableRequest.getModel();

        for(int  i = r-1;i>=0;i--)
        {
            m.removeRow(i);
        }
        Organization o = (Organization) Business.getInstance().getNetworkDirectory().searchUser(userAccount, Organization.class.getSimpleName());
        for(WorkRequest wr : o.getWorkQueue().getQueue())
        {
            if(wr.getType() == WorkRequest.type.RequestDrugLicense)
            {
            LicenseDrugWorkRequest w = (LicenseDrugWorkRequest)wr;
            Object row[] = new Object[5];
            row[0]= w;
            row[1]= w.getDrug().getId();
            row[2]= w.getRequestDate();
            row[3]= w.getReceiver();
            row[4]= w.getStatus();

            m.addRow(row);
            }
        }

    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnMyQueue = new javax.swing.JButton();
        btnGrantLicense = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRequest = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Licensing Manager Organization Queue");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 470, -1));

        btnMyQueue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMyQueue.setText("Add to my Work Queue");
        btnMyQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyQueueActionPerformed(evt);
            }
        });
        add(btnMyQueue, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 240, -1));

        btnGrantLicense.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGrantLicense.setText("Grant License");
        btnGrantLicense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrantLicenseActionPerformed(evt);
            }
        });
        add(btnGrantLicense, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 240, -1));

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 120, -1));

        tableRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Drug Name", "Drug ID", "Date Requested", "Receiving Manager", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableRequest);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 560, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void btnMyQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyQueueActionPerformed
        // TODO add your handling code here:
        int r = tableRequest.getSelectedRow();
        if(r<0){
            JOptionPane.showMessageDialog(null,"No row selected");
            return;
        }
        WorkRequest req = (WorkRequest)tableRequest.getValueAt(r, 0);
        req.setReceiver(userAccount);
        req.setStatus(WorkRequest.status.ProcessingLicense);
        refreshWorkRequestTable();
        JOptionPane.showMessageDialog(null, "Added to my queue");
    }//GEN-LAST:event_btnMyQueueActionPerformed

    private void btnGrantLicenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrantLicenseActionPerformed
        // TODO add your handling code here:
        int r = tableRequest.getSelectedRow();
        if(r<0)
        {
            JOptionPane.showMessageDialog(null, "No row selected");
            return;
        }

        LicenseDrugWorkRequest req = (LicenseDrugWorkRequest)tableRequest.getValueAt(r, 0);
        if(req.getReceiver()== userAccount )
        {
            req.setStatus(WorkRequest.status.GrantedLicense);
            License license = new License();
            license.setLicense(Boolean.TRUE);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            license.setIssueDate(c.getTime());
            c.add(Calendar.YEAR, 1);
            license.setExpiryDate(c.getTime());
            req.getDrug().setLicense(license);
            refreshWorkRequestTable();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Not your work");
        }
    }//GEN-LAST:event_btnGrantLicenseActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);

    }//GEN-LAST:event_backJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnGrantLicense;
    private javax.swing.JButton btnMyQueue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableRequest;
    // End of variables declaration//GEN-END:variables
}
