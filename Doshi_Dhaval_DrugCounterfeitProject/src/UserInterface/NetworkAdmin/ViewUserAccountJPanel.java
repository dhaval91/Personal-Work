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
public class ViewUserAccountJPanel extends javax.swing.JPanel {
JPanel userProcessContainer;
Enterprise enterprise;


    /** Creates new form CreateProductJPanel */
    public ViewUserAccountJPanel(JPanel userProcessContainer,Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        txtName1.setText(enterprise.getEnterpriseName());
        if(!enterprise.getEd().geteList().isEmpty())
        {
            txtAdminName.setText(enterprise.getEd().geteList().get(0).getPerson().getfName());
        }
        if(!enterprise.getUad().getuList().isEmpty())
        {
            txtUsername.setText(enterprise.getUad().getuList().get(0).getUserName());
        }

   }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbllTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        txtAdminName = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblName1 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbllTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbllTitle.setText("View Admin User Account");
        jPanel1.add(lbllTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 421, -1, -1));

        lblName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblName.setText("Admin Name");
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 195, -1, 30));

        txtAdminName.setEditable(false);
        txtAdminName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAdminName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtAdminName.setEnabled(false);
        jPanel1.add(txtAdminName, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 195, 159, 30));

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUsername.setText("Username");
        jPanel1.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 251, -1, 30));

        txtUsername.setEditable(false);
        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUsername.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtUsername.setEnabled(false);
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 251, 159, 30));

        lblName1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblName1.setText("Enterprise Name:");
        jPanel1.add(lblName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 147, -1, 30));

        txtName1.setEditable(false);
        txtName1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtName1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtName1.setEnabled(false);
        jPanel1.add(txtName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 147, 159, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout cardLayout = (CardLayout)(userProcessContainer.getLayout());
        cardLayout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lbllTitle;
    private javax.swing.JTextField txtAdminName;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}