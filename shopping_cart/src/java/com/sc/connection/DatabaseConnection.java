/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 4m4l
 */
public class DatabaseConnection {

    private static Connection con = null;

    public static Connection getDatabaseConnection() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            con = DriverManager.getConnection("jdbc:mysql://db2.devart.lk:3306/__da_ars_pos", "ARS_POS", Loading.getDbPassword());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_cart", "root", "1234");
            return con;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
