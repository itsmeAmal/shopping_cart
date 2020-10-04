/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc.model;

import java.math.BigDecimal;

/**
 *
 * @author personal
 */
public class OrderDetails {
 
    private int Id;
    private int OderId;
    private String ItemId;
    private BigDecimal OrderQty;
    private int Status;
    private BigDecimal RetailPrice;
    private BigDecimal SellingPrice;
    private String Description;

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the OderId
     */
    public int getOderId() {
        return OderId;
    }

    /**
     * @param OderId the OderId to set
     */
    public void setOderId(int OderId) {
        this.OderId = OderId;
    }

    /**
     * @return the ItemId
     */
    public String getItemId() {
        return ItemId;
    }

    /**
     * @param ItemId the ItemId to set
     */
    public void setItemId(String ItemId) {
        this.ItemId = ItemId;
    }

    /**
     * @return the OrderQty
     */
    public BigDecimal getOrderQty() {
        return OrderQty;
    }

    /**
     * @param OrderQty the OrderQty to set
     */
    public void setOrderQty(BigDecimal OrderQty) {
        this.OrderQty = OrderQty;
    }

    /**
     * @return the Status
     */
    public int getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(int Status) {
        this.Status = Status;
    }

    /**
     * @return the RetailPrice
     */
    public BigDecimal getRetailPrice() {
        return RetailPrice;
    }

    /**
     * @param RetailPrice the RetailPrice to set
     */
    public void setRetailPrice(BigDecimal RetailPrice) {
        this.RetailPrice = RetailPrice;
    }

    /**
     * @return the SellingPrice
     */
    public BigDecimal getSellingPrice() {
        return SellingPrice;
    }

    /**
     * @param SellingPrice the SellingPrice to set
     */
    public void setSellingPrice(BigDecimal SellingPrice) {
        this.SellingPrice = SellingPrice;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
    
}
