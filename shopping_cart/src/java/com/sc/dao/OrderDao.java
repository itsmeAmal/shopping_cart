/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc.dao;

import com.sc.model.Order;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author personal
 */
public interface OrderDao {
    
    public void AddOrder(Order Order)throws SQLException;
    
    public void UpdateOrder(Order Order)throws SQLException;
    
    public void DeleteOrder(int Id)throws SQLException;
    
    public ResultSet GetAllOrders()throws SQLException;
    
    public ResultSet GetOrderByOneAttribute(String Attribute, String Condition, String Value)throws SQLException;
    
}
