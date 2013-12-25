package com.pnc.dbf.config;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection implements Serializable {

    Connection con;

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_dbf_pnc", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return con;
    }

    public ResultSet getResult(String query) throws SQLException {
        PreparedStatement ps = con.prepareStatement(query);
        return ps.executeQuery();
    }

    public ResultSet getResult(String query, ArrayList parameter) throws SQLException {
        PreparedStatement ps = con.prepareStatement(query);
        for (int i = 0; i < parameter.size(); i++) {
            ps.setString(i + 1, parameter.get(i).toString());
        }
        return ps.executeQuery();
    }

    public int setUpdateDB(String query, ArrayList parameter) throws SQLException {
        PreparedStatement ps = con.prepareStatement(query);
        for (int i = 0; i < parameter.size(); i++) {
            ps.setString(i + 1, parameter.get(i).toString());
        }
        return ps.executeUpdate();
    }
}
