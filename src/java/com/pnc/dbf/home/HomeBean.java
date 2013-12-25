package com.pnc.dbf.home;

import com.pnc.dbf.config.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
public class HomeBean {

    private final DBConnection dbConnection = new DBConnection();
    private MenuModel model = new DefaultMenuModel();

    public HomeBean() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        ValueBinding binding = context.getApplication().createValueBinding("#{signInBean.idProfile}");

        ArrayList parameter = new ArrayList();
        parameter.add(Integer.parseInt(binding.getValue(context).toString()));
        ResultSet res = dbConnection.getResult("select * from t_module inner join t_access on "
                + "t_access.id_module = t_module.id_module where id_profile = ?", parameter);
        while (res.next()) {
            DefaultSubMenu subMenu = new DefaultSubMenu(res.getString(2));
            parameter.clear();
            parameter.add(res.getString(1));
            ResultSet ress = dbConnection.getResult("select * from t_submodule where id_module = ?", parameter);
            while (ress.next()) {
                DefaultMenuItem item = new DefaultMenuItem(ress.getString("submodule_name"));
                item.setCommand(ress.getString("command"));
                item.setIcon(ress.getString("icon"));
                subMenu.addElement(item);
            }
            model.addElement(subMenu);
        }
    }

    private void addMessage(FacesMessage.Severity severity, String title, String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, title, message));
    }

    public String signOut() {
        HttpServletRequest origRequest = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        String url = origRequest.getRequestURL().toString();
        url = url.substring(0, url.length() - url.lastIndexOf("GEBF"));
        if (!url.contains("GEBF")) {
            url += "GEBF/";
        } else {
            url += "/";
        }
        if (url.endsWith("//")) {
            url = url.substring(0, url.length() - 1);
        }
        return url;
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
}
