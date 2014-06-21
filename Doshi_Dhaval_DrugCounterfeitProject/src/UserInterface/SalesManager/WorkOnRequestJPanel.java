/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BusinessAdminWorkAreaJPanel.java
 *
 * Created on Nov 2, 2012, 5:59:07 PM
 */
package UserInterface.SalesManager;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Enterprise.InventoryCatalog;
import Business.Enterprise.ManufacturerEnterprise;
import Business.Enterprise.WholesalerEnterprise;
import Business.InventoryItem;
import Business.Order;
import Business.OrderItem;
import Business.UserAccount;
import Business.WorkRequest.*;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dhaval
 */
public class WorkOnRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    Order request;

    /** Creates new form BusinessAdminWorkAreaJPanel */
    public WorkOnRequestJPanel(JPanel upc, Order req, UserAccount ua) {
        initComponents();

        this.request = req;
        userProcessContainer = upc;
        userAccount = ua;
        Refresh(req);
       // txtName.setText(request.getDrug().getBrandName());
       // txtQuantity.setText(String.valueOf(request.getQuantity()));

    }
private void Refresh(Order order){
         int rowCount = itemListTable.getRowCount();
        for(int i = rowCount-1; i >= 0; i--)
        {
            ((DefaultTableModel)itemListTable.getModel()).removeRow(i);
        }

        for (OrderItem orderItem : order.getOrderList())
        {
            Object row [] = new Object[4];
            row[0]=orderItem;
            row[1]=orderItem.getPrice();
            row[2]=orderItem.getQuantity();
            row[3]=orderItem.getPrice()*orderItem.getQuantity();
            ((DefaultTableModel)itemListTable.getModel()).addRow(row);
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

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemListTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("Work On Request");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        itemListTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        itemListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Price", "Quantity", "Total Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(itemListTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 450, 90));

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 235, -1, -1));

        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSubmit.setText("Request Shippment");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        request.setStatus(WorkRequest.status.ShippingRequested);
        request.setResloveDate(new Date());
        ManufacturerEnterprise me = null;
        WholesalerEnterprise we = null;
        ShipWorkRequest req = null;
        Enterprise enterprise = (Enterprise) Business.getInstance().getNetworkDirectory().searchUser(userAccount, Enterprise.class.getSimpleName());

        if(enterprise.getInventoryCatalog().checkAvailibility(request)) {
            for(OrderItem or: request.getOrderList())
            {
                InventoryItem item = enterprise.getInventoryCatalog().findItem(or.getDrug());
                int quantity = 0;
                if(item.getAvail()>= or.getQuantity())
                {
                    item.setAvail(quantity - or.getQuantity());
                }

           }
        }
        else
                {
                    JOptionPane.showMessageDialog(null, "Drugs not available");
                    return;
                }
        if(enterprise.getClass()== ManufacturerEnterprise.class)
        {
            me = (ManufacturerEnterprise)enterprise;
            req = (ShipWorkRequest)me.getShippmentManagementOrganization().getWorkQueue().newWorkRequest(WorkRequest.type.ShipWorkRequest);

        }
        else{
            we = (WholesalerEnterprise)enterprise;
            req = (ShipWorkRequest)we.getShippmentManagementOrganization().getWorkQueue().newWorkRequest(WorkRequest.type.ShipWorkRequest);

        }

        req.setSender(userAccount);
        //req.setDrug(request.getDrug());
        //req.setQuantity(request.getQuantity());
        req.setOrder(request);

        userAccount.getSendWorkQueue().addWorkRequest(req);
        JOptionPane.showMessageDialog(null, "Shippment Requested");

    }//GEN-LAST:event_btnSubmitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JTable itemListTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}