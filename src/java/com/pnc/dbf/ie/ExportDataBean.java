/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pnc.dbf.ie;

import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author IMA-RDN
 */
@ManagedBean(name = "exportdataBean")
@SessionScoped
public class ExportDataBean implements Serializable {

    private Date startDate, endDate;
    private String units;

    public ExportDataBean() {
    }

    public void doExport() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erreur", "Essayez plus tard.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
