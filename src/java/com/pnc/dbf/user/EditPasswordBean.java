package com.pnc.dbf.user;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class EditPasswordBean implements Serializable {

    @ManagedProperty(value = "#{signInBean}")
    private SignInBean signInBean;
    private String oldPwd;
    private String newPwd;
    private String repeatPwd;

    public EditPasswordBean() {
    }

    public void updatePassword() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        if (oldPwd.equals(signInBean.getPassword())) {
            if (newPwd.equals(repeatPwd)) {
                if (!oldPwd.equals(newPwd)) {
                    signInBean.setPassword(modifyPwdDB());
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, ""
                    + "Mise à jour effectuée", "Le mot de passe a été mise à jour avec succès"));
                } else {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ""
                            + "Mot de passe", "L'ancien et le nouveau mot de passe ne peuvent pas être identique"));
                }
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ""
                        + "Mots de passe non identique", "Le mot de passe saisi et celui répété ne sont pas identique"));
            }
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ""
                    + "Ancien Mot de passe incorrect", "L'ancien mot de passe saisi n'est pas valide"));
        }
    }

    public void closeEditPassword() {
        RequestContext.getCurrentInstance().closeDialog(null);
    }

    public void openEditPasswordDialog() {
        Map<String, Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 240);
        options.put("contentWidth", 500);
        RequestContext.getCurrentInstance().openDialog("/user/editPassword", options, null);
    }

    private String modifyPwdDB() throws SQLException {
        String query = "update t_user set password = ?, new_user = ? where id_user = ?";
        ArrayList parameter = new ArrayList();
        parameter.add(newPwd);
        parameter.add(0);
        parameter.add(signInBean.getIdUser());
        signInBean.getDbConnection().setUpdateDB(query, parameter);
        return newPwd;
    }

    public SignInBean getSignInBean() {
        return signInBean;
    }

    public void setSignInBean(SignInBean signInBean) {
        this.signInBean = signInBean;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getRepeatPwd() {
        return repeatPwd;
    }

    public void setRepeatPwd(String repeatPwd) {
        this.repeatPwd = repeatPwd;
    }
}
