<%-- 
    Document   : MyCart
    Created on : Oct 4, 2020, 8:54:19 AM
    Author     : personal
--%>

<%@page import="com.sc.daoimpl.OrderDetailDaoImpl"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            table {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {background-color: #f2f2f2;}
        </style>
    </head>
    <body>

        <h2>Cart Items</h2>
        <%                ResultSet rset = new OrderDetailDaoImpl().GetAllOrderDetails();
        %>
        <table>
            <tr>
                <th>Item Name</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
            <%
                while (rset.next()) {
            %>
            <tr>
                <td><%=rset.getString("order_detail_item_name")%>         </td> 
                <td><%=rset.getBigDecimal("order_detail_retail_price")%>  </td>
                <td><%=rset.getString("order_detail_item_name")%>         </td>
            </tr> 
            <%
                }
            %>
        </table>

    </body>
</html>
