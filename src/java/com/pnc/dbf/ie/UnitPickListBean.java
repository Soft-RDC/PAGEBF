/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pnc.dbf.ie;

import com.pnc.dbf.config.DBConnection;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DualListModel;

/**
 *
 * @author IMA-RDN
 */
@ManagedBean(name = "unitpicklistbean")
@SessionScoped
public class UnitPickListBean implements Serializable {

    private DualListModel<String> unit;
    private DBConnection dbConnection = new DBConnection();

    public UnitPickListBean() {
        try {
            List<String> unitSource = new ArrayList<String>();
            List<String> unitTarget = new ArrayList<String>();
            FacesContext context = FacesContext.getCurrentInstance();
            String query = "SELECT * FROM t_unites";
            ResultSet res = dbConnection.getResult(query);
            while (res.next()) {
                unitSource.add(res.getString("unitname"));
            }
            unit = new DualListModel<>(unitSource, unitTarget);
        } catch (SQLException ex) {
            Logger.getLogger(UnitPickListBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public DualListModel<String> getUnit() {
        return unit;
    }

    public void setUnit(DualListModel<String> unit) {
        this.unit = unit;
    }

}
