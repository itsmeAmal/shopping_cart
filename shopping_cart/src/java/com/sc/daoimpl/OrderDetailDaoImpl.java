/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc.daoimpl;

import com.sc.connection.DatabaseConnection;
import com.sc.dao.OrderDetailsDao;
import com.sc.model.OrderDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author personal
 */
public class OrderDetailDaoImpl implements OrderDetailsDao {

    private String SelectQuery = "select order_detail_id, order_detail_order_id, order_detail_item_id, order_detail_qty,"
            + " order_detail_status, order_detail_retail_price, order_detail_selling_price, order_detail_description from order_detail";

    @Override
    public void AddOrderDetails(OrderDetails OrderDetails) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into order_detail (order_detail_order_id, "
                + "order_detail_item_id, order_detail_qty, order_detail_retail_price) values (?,?,?,?)");
        ps.setInt(1, OrderDetails.getOderId());
        ps.setInt(2, OrderDetails.getItemId());
        ps.setBigDecimal(3, OrderDetails.getOrderQty());
        ps.setBigDecimal(4, OrderDetails.getRetailPrice());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void UpdateOrderDetails(OrderDetails OrderDetails) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteOrderDetail(int Id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void DeleteOrderDetailAll() throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from order_detail");
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public ResultSet GetAllOrderDetails() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet GetOrderDetailsByOneAttribute(String Attribute, String Condition, String Value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
