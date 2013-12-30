package com.pnc.dbf.system;

import com.pnc.dbf.config.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
public class Submodule {

    private final DBConnection dbConnection = new DBConnection();

    public MenuModel getSubmodules(int idModule) throws SQLException {
        MenuModel modelSubmodule = new DefaultMenuModel();
        ArrayList parameter = new ArrayList();
        parameter.add(idModule);
        ResultSet res = dbConnection.getResult("select * from t_submodule where id_module = ?", parameter);
        while (res.next()) {
            DefaultMenuItem item = new DefaultMenuItem(res.getString("submodule_name"));
            item.setCommand(res.getString("command"));
            item.setIcon(res.getString("icon"));
            modelSubmodule.addElement(item);
        }
        return modelSubmodule;
    }
}
