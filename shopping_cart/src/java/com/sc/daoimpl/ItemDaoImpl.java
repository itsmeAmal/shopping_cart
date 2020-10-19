package com.sc.daoimpl;

import com.sc.dao.ItemDao;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDaoImpl implements ItemDao {

    private String SelectQuery = "select item_id, item_name, item_brand, "
            + " item_model, item_serial_no, item_price, item_status, item_description_1 from item";

    @Override
    public ResultSet GetAllItems() throws SQLException {
        return new CommonDaoImpl().getAllRecords(SelectQuery);
    }

    @Override
    public ResultSet GetItemByOneAttribute(String Attribute, String Condition, String Value) throws SQLException {
        return new CommonDaoImpl().getResultByAttribute(SelectQuery, Attribute, Condition, Value); 
    }

}
