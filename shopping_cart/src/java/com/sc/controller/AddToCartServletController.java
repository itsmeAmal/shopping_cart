/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc.controller;

import com.sc.daoimpl.OrderDaoImpl;
import com.sc.daoimpl.OrderDetailDaoImpl;
import com.sc.model.Order;
import com.sc.model.OrderDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author personal
 */
@WebServlet(name = "AddToCartServletController", urlPatterns = {"/AddToCartServletController"})
public class AddToCartServletController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String item1 = request.getParameter("item_1");
        String item2 = request.getParameter("item_2");
        String item3 = request.getParameter("item_3");

        String value1 = request.getParameter("value_1");
        String value2 = request.getParameter("value_2");
        String value3 = request.getParameter("value_3");

        String qty1 = request.getParameter("qty_1");
        String qty2 = request.getParameter("qty_2");
        String qty3 = request.getParameter("qty_3");

        Order order = new Order();
        order.setAmount(Validations.getBigDecimalFromString(item1));

        OrderDetailDaoImpl orderDetailDaoImpl = new OrderDetailDaoImpl();
        try {
            orderDetailDaoImpl.DeleteOrderDetailAll();    // delete this line after merging with other part of project
        } catch (SQLException ex) {
            Logger.getLogger(AddToCartServletController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 3; i++) {  // remove for loop after merging with other part of project
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setItemId(1);
            orderDetails.setOrderQty(Validations.getBigDecimalOrZeroFromString(qty1));
            orderDetails.setRetailPrice(Validations.getBigDecimalOrZeroFromString(value1));
            orderDetails.setSellingPrice(Validations.getBigDecimalOrZeroFromString(value1));
            orderDetails.setStatus(1);
            try {
                new OrderDetailDaoImpl().AddOrderDetails(orderDetails);
            } catch (SQLException ex) {
                Logger.getLogger(AddToCartServletController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.sendRedirect("ItemsListPage.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
