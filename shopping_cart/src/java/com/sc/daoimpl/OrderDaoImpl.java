/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc.daoimpl;

import com.sc.connection.DatabaseConnection;
import com.sc.dao.OrderDao;
import com.sc.model.Order;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author personal
 */
public class OrderDaoImpl implements OrderDao {

    private String SelectQuery = "order_id, order_date, order_user_id, order_item_count, order_status, "
            + "order_delivery_address, order_total_amount, order_discount_percentage, order_description";

    @Override
    public void AddOrder(Order Order) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into order(order_user_id, order_item_count,"
                + " order_status, order_delivery_address, order_total_amount, order_discount_percentage, order_description)");
        ps.setInt(1, 1);
        ps.setInt(2, Order.getItemCount());
        ps.setInt(3, 1);
        ps.setString(4, Order.getDeliveryAddress());
        ps.setBigDecimal(5, Order.getAmount());
        ps.setBigDecimal(0, BigDecimal.ZERO);
        ps.setString(7, Order.getDescription());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void UpdateOrder(Order Order) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update order set order_delivery_address=? where order_id=?");
        ps.setString(1, Order.getDeliveryAddress());
        ps.setInt(2, Order.getId());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void DeleteOrder(int Id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from order where order_id=?");
        ps.setInt(1, Id);
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public ResultSet GetAllOrders() throws SQLException {
        return new CommonDaoImpl().getAllRecords(SelectQuery);
    }

    @Override
    public ResultSet GetOrderByOneAttribute(String Attribute, String Condition, String Value) throws SQLException {
        return new CommonDaoImpl().getResultByAttribute(SelectQuery, Attribute, Condition, Value);
    }

}
