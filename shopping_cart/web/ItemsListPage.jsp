<%-- 
    Document   : ItemsListPage
    Created on : Oct 3, 2020, 9:51:30 AM
    Author     : personal
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="com.sc.daoimpl.ItemDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Items</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <style>
            .button {
                background-color: #4CAF50; /* Green */
                border: none;
                color: white;
                padding: 20px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
            }
            .button2 {border-radius: 4px;}
        </style>
    </head>
    <body>
        <div class="w3-container w3-teal">
            <h1>Items</h1>
        </div>
        <div class="w3-container">
            <h2>Add Items To Cart</h2>
            <table class="table">
                <thead>
                    <%
                        ResultSet rset = new ItemDaoImpl().GetAllItems();
                        int i = 0;
                    %>
                    <tr style="background-color: #000000; color: white">
                        <th>#</th>
                        <th>Item Name, Brand and Category</th>
                        <th>Price</th>
                        <th>Qty</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        while (rset.next()) {
                    %>
                    <tr class="info" style="height: 40px; top: 0px;">
                <form action="MyCartServletController">
                    <td><%= ++i%></td>
                    <td>
                        <%= rset.getString("item_name")%><br>
                        <h3> <%= rset.getString("item_brand")%></h3><br>
                        <h6> <%= rset.getString("item_model")%></h6><br>
                        <input type="hidden" value="<%= rset.getInt("item_id")%>" name="hid_item_id">
                    </td>
                    <td>
                        <h4> <%= rset.getString("item_price")%></h4>
                    </td>
                    <td>
                        <h6> <input type="text" class="form-control" name="item_qty" placeholder="Item Quantity"></h6><br>
                    </td>
                    <td>
                        <input class="btn btn-primary" type="submit" value="Add to cart" style="position: relative; width: 100px; left: 0px" placeholder="Qty">               
                        <input type="hidden"  value="<%= rset.getString("item_price")%>" name="hid_id">               
                        <input type="hidden"  value=" <%= rset.getString("item_name")%>" name="hid_name">               
                        <input type="hidden"  value="<%= rset.getString("item_price")%>" name="hid_price">      
                    </td>
                </form>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
        <form action="MyCart.jsp">
            <div style="position: absolute; left: 73%; top: 55px; width: 100px; height: 50px;">
                <input class="btn btn-warning" value="My Cart" name="add_to_cart" type="submit"  style="position: relative; width: 100px; left: 210px" placeholder="Qty">               
            </div>
        </form>
    </body>
</html>
