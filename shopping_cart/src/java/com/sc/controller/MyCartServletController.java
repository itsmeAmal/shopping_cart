/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc.controller;

import com.sc.daoimpl.ItemDaoImpl;
import com.sc.daoimpl.OrderDetailDaoImpl;
import com.sc.model.OrderDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
@WebServlet(name = "MyCartServletController", urlPatterns = {"/MyCartServletController"})
public class MyCartServletController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String Id = request.getParameter("hid_id");
            String Name = request.getParameter("hid_name");
            String Price = request.getParameter("hid_price");
            String Qty = request.getParameter("item_qty");
            
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setItemId(Name);
            orderDetails.setOrderQty(Validations.getBigDecimalOrZeroFromString(Qty));
            orderDetails.setRetailPrice(Validations.getBigDecimalOrZeroFromString(Price));
            orderDetails.setSellingPrice(Validations.getBigDecimalOrZeroFromString(Price));
            orderDetails.setStatus(1);
            
            new OrderDetailDaoImpl().AddOrderDetails(orderDetails);
            
            response.sendRedirect("ItemsListPage.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(MyCartServletController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
