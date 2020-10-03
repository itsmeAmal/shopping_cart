/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc.daoimpl;

import com.sc.connection.DatabaseConnection;
import com.sc.controller.CommonConstants;
import com.sc.controller.Validations;
import com.sc.dao.commonDao;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 4m4l
 */
public class CommonDaoImpl implements commonDao {

    private String selectQuerty2 = "select current_stock_id, current_stock_item_id, current_stock_qty, item_id, item_name, item_code, item_barcode,"
            + " item_reorder_level, item_status_1, item_status_2, item_status_3, item_selling_price, item_category, item_sub_category,"
            + " item_purchasing_price from  current_stock left join item on current_stock_item_id = item_id";

    @Override
    public ResultSet getAllRecords(String selectQuery) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement(selectQuery);
        ResultSet rset = ps.executeQuery();
        return rset;
    }

    @Override
    public ResultSet getResultByAttribute(String selectQuery, String attribute, String condition, String value) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement(selectQuery + CommonConstants.sql.WHERE + attribute
                + condition + CommonConstants.sql.PARAMETER);
        ps.setString(1, value);
        ResultSet rset = ps.executeQuery();
        return rset;
    }

    public ResultSet getResultByAttributesWithJoinOperator(String selectQuery,
            ArrayList<String[]> attributeConditionValueList, String operator) throws SQLException {

        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps;
        int noOfConditions = attributeConditionValueList.size();
        if (noOfConditions == 0) {
            ps = con.prepareStatement(selectQuery);
        } else {
            String query = selectQuery + CommonConstants.sql.WHERE + attributeConditionValueList.get(0)[0]
                    + attributeConditionValueList.get(0)[1] + CommonConstants.sql.PARAMETER;

            for (int i = 1; i < noOfConditions; i++) {
                query = query + operator + attributeConditionValueList.get(i)[0]
                        + attributeConditionValueList.get(i)[1] + CommonConstants.sql.PARAMETER;
            }

            ps = con.prepareStatement(query);

            for (int i = 0; i < noOfConditions; i++) {
                ps.setString(i + 1, attributeConditionValueList.get(i)[2]);
            }
        }
        ResultSet rst = ps.executeQuery();
        return rst;
    }

    public void addCurrentStockRecord(String itemId, String qty, int type) throws SQLException {
        BigDecimal quantity = Validations.getBigDecimalOrZeroFromString(qty);
        if (type == 1) {
        } else if (type == 2) {
            quantity = (quantity.multiply(new BigDecimal(-1)));
        }
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into current_stock (current_stock_item_id, current_stock_qty) values (?,?)");
        ps.setInt(1, Validations.getIntOrZeroFromString(itemId));
        ps.setBigDecimal(2, quantity);
        ps.executeUpdate();
        ps.close();
    }

    public ResultSet getItemProfitsByDate(String fromDate, String toDate) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("SELECT invoice_detail_item_id, item_barcode, invoice_date, invoice_detail_item_qty, invoice_detail_selling_price, "
                + " invoice_detail_purchase_price, truncate((invoice_detail_item_qty*(invoice_detail_selling_price-invoice_detail_purchase_price)),2) as profit "
                + " FROM invoice_detail left join invoice on invoice_detail_invoice_no=invoice_id left join item on invoice_detail_item_id=item_id"
                + " where invoice_date between ? and ?");
        ps.setString(1, fromDate);
        ps.setString(2, toDate);
        return ps.executeQuery();
    }
}
