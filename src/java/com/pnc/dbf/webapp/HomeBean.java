package com.pnc.dbf.webapp;

import com.pnc.dbf.config.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
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
            DefaultMenuItem item = new DefaultMenuItem(res.getString("module_name"));
            item.setCommand(res.getString("command"));
            item.setIcon(res.getString("icon"));
            item.setAjax(false);
            item.setOnclick("selectComponentLink(this)");
            item.setStyleClass("#{navigationContext.getMenuitemStyleClass('" + res.getString("command") + "')}");
            model.addElement(item);
        }
    }

    private void addMessage(FacesMessage.Severity severity, String title, String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, title, message));
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
}
