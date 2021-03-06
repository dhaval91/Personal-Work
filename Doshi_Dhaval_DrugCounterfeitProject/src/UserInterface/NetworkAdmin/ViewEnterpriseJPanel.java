/*
 * CreateProductJPanel.java
 *
 * Created on September 18, 2008, 2:54 PM
 */
package UserInterface.NetworkAdmin;

import Business.Enterprise.Enterprise;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Dhaval
 */
public class ViewEnterpriseJPanel extends javax.swing.JPanel {
JPanel userProcessContainer;
Enterprise enterprise;


    /** Creates new form CreateProductJPanel */
    public ViewEnterpriseJPanel(JPanel userProcessContainer,Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        txtName.setText(enterprise.getEnterpriseName());


        txtName.setEditable(false);


   }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbllTitle = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbllTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbllTitle.setText("View Enterprise Detail");
        add(lbllTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 20, -1, -1));

        lblName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblName.setText("Enterprise Name:");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 30));

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtName.setEnabled(false);
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 159, 30));

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 258, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout)(userProcessContainer.getLayout());
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lbllTitle;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
