/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkAreas;

import Business.UserAccount;
import Business.Views.EnterpriseAdminView;
import Business.Views.Views;
import javax.swing.JPanel;

/**
 *
 * @author Dhaval
 */
public class EnterpriseAdminWorkArea extends WorkArea{

    @Override
    public Views createView(JPanel userProcessContainer, UserAccount user) {
        return new EnterpriseAdminView(userProcessContainer, user);
    }

}
