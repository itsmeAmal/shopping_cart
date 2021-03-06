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

            table {
                width:100%;
            }
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            th, td {
                padding: 15px;
                text-align: left;
            }
            #t01 tr:nth-child(even) {
                background-color: #eee;
            }
            #t01 tr:nth-child(odd) {
                background-color: #fff;
            }
            #t01 th {
                background-color: black;
                color: white;
            }
        </style>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>

        <h2>Cart Items</h2>
        <%                
            ResultSet rset = new OrderDetailDaoImpl().GetAllOrderDetails();
        %>
        <table class="table">
            <tr>
                <th>Item Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>#</th>
            </tr>
            <%
                while (rset.next()) {
            %>
            <tr>
                <td><%=rset.getString("order_detail_item_name")%></td> 
                <td><%=rset.getBigDecimal("order_detail_retail_price")%></td>
                <td><%=rset.getString("order_detail_qty")%></td>
                <td>
                    <form action="DeleteItemServletController">
                        <input type="submit" value="Remove" class="btn btn-primary">
                        <input type="hidden" name="dlt" value="<%=rset.getString("order_detail_item_name")%>">
                    </form>
                </td>
            </tr> 
            <%
                }
            %>
        </table>
    </body>
</html>
