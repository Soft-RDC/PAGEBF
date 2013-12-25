package com.pnc.dbf.user;

import com.pnc.dbf.config.DBConnection;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "signInBean", eager = true)
@SessionScoped

public class SignInBean implements Serializable {

    private String userName;
    private String password;
    private String profile;
    private int idUser, idProfile;
    private DBConnection dbConnection = new DBConnection();

    public SignInBean() {
    }

    public String logInUser() {
        String query = "select * from t_user where username = ? and password = ?";
        ArrayList parameter = new ArrayList();
        parameter.add(getUserName());
        parameter.add(getPassword());
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if (!isValideUserName()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Nom d'utilisateur incorrect", ""
                        + "Le nom d'utilisateur saisi n'existe pas dans l'annuaire !!!"));
            } else {
                idUser = getIdUserFromDB();
                if (getStatus() == 0) {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Compte bloqué", ""
                            + "Votre compte a été bloqué, veuillez contacter l'administrateur du système ..."));
                } else {
                    ResultSet res = dbConnection.getResult(query, parameter);
                    if (res.next()) {
                        idProfile = res.getInt("id_profile");
                        profile = getProfileDB();
                        setAttempt(0);
                        updateLastVisiteDate();
                        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenu", ""
                                + "Bonjour " + res.getString(4) + " " + res.getString(5)));
                        if (isNewUser()) {
                            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Changer votre Mot de passe", ""
                                    + "Vous devez changer votre mot de passe car vous utilisez encore celui "
                                    + "reçu auprès de l'administrateur"));
                        }
                        return "home/home";
                    } else {
                        int attempt = getAttempt() + 1;
                        if ((3 - attempt) <= 0) {
                            setStatus(0);
                            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Compte bloqué", ""
                                    + "Votre compte a été bloqué, veuillez contacter l'administrateur du système ..."));
                        } else {
                            setAttempt(attempt);
                            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Mot de passe incorrect", ""
                                    + "Le mot de passe saisi n'est pas valide ! Il vous reste " + (3 - attempt) + " tentatives"));
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SignInBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private int updateLastVisiteDate() throws SQLException {
        String query = "update t_user set last_visit_date = ? where id_user = ?";
        ArrayList parameter = new ArrayList();
        parameter.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new DateFormatSymbols()).format(new Date()));
        parameter.add(idUser);
        return dbConnection.setUpdateDB(query, parameter);
    }

    private boolean isValideUserName() throws SQLException {
        String query = "select * from t_user where username = ?";
        ArrayList parameter = new ArrayList();
        parameter.add(userName);
        ResultSet res = dbConnection.getResult(query, parameter);
        return res.next();
    }

    private boolean isNewUser() throws SQLException {
        String query = "select * from t_user where id_user = ? and new_user = ?";
        ArrayList parameter = new ArrayList();
        parameter.add(idUser);
        parameter.add(1);
        ResultSet res = dbConnection.getResult(query, parameter);
        return res.next();
    }

    private int setAttempt(int attempt) throws SQLException {
        String query = "update t_user set attempt = ? where id_user = ?";
        ArrayList parameter = new ArrayList();
        parameter.add(attempt);
        parameter.add(idUser);
        return dbConnection.setUpdateDB(query, parameter);
    }

    private int getAttempt() throws SQLException {
        String query = "select attempt from t_user where id_user = ?";
        ArrayList parameter = new ArrayList();
        parameter.add(idUser);
        ResultSet res = dbConnection.getResult(query, parameter);
        while (res.next()) {
            return Integer.parseInt(res.getString(1));
        }
        return 0;
    }

    private int getIdUserFromDB() throws SQLException {
        String query = "select id_user from t_user where username = ?";
        ArrayList parameter = new ArrayList();
        parameter.add(getUserName());
        ResultSet res = dbConnection.getResult(query, parameter);
        while (res.next()) {
            return Integer.parseInt(res.getString(1));
        }
        return 0;
    }

    private int getStatus() throws SQLException {
        String query = "select status from t_user where id_user = ?";
        ArrayList parameter = new ArrayList();
        parameter.add(idUser);
        ResultSet res = dbConnection.getResult(query, parameter);
        while (res.next()) {
            return Integer.parseInt(res.getString(1));
        }
        return 1;
    }

    private int setStatus(int status) throws SQLException {
        String query = "update t_user set status = ? where id_user = ?";
        ArrayList parameter = new ArrayList();
        parameter.add(status);
        parameter.add(idUser);
        return dbConnection.setUpdateDB(query, parameter);
    }

    private String getProfileDB() throws SQLException {
        String query = "select profile_name from t_profile where id_profile = ?";
        ArrayList parameter = new ArrayList();
        parameter.add(idProfile);
        ResultSet res = dbConnection.getResult(query, parameter);
        while (res.next()) {
            return res.getString(1);
        }
        return null;
    }

    public DBConnection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }
}
