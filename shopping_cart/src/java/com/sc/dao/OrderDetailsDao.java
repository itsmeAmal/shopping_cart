/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc.dao;

import com.sc.model.OrderDetails;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author personal
 */
public interface OrderDetailsDao {
    
    public void AddOrderDetails(OrderDetails OrderDetails)throws SQLException;
    
    public void UpdateOrderDetails(OrderDetails OrderDetails)throws SQLException;
    
    public void DeleteOrderDetail(int Id)throws SQLException;
    
    public ResultSet GetAllOrderDetails()throws SQLException;
    
    public ResultSet GetOrderDetailsByOneAttribute(String Attribute, String Condition, String Value) throws SQLException;

}
