/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author personal
 */
public interface ItemDao {

    public ResultSet GetAllItems() throws SQLException;

    public ResultSet GetItemByOneAttribute(String Attribute, String Condition, String Value) throws SQLException;

}
