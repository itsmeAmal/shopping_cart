/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc.model;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author personal
 */
public class Order {
    
    private int Id;
    private Date Date;
    private int UserId;
    private int ItemCount;
    private int OrderStatus;
    private String DeliveryAddress;
    private BigDecimal Amount;
    private BigDecimal Percentage;
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
     * @return the Date
     */
    public Date getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(Date Date) {
        this.Date = Date;
    }

    /**
     * @return the UserId
     */
    public int getUserId() {
        return UserId;
    }

    /**
     * @param UserId the UserId to set
     */
    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    /**
     * @return the ItemCount
     */
    public int getItemCount() {
        return ItemCount;
    }

    /**
     * @param ItemCount the ItemCount to set
     */
    public void setItemCount(int ItemCount) {
        this.ItemCount = ItemCount;
    }

    /**
     * @return the OrderStatus
     */
    public int getOrderStatus() {
        return OrderStatus;
    }

    /**
     * @param OrderStatus the OrderStatus to set
     */
    public void setOrderStatus(int OrderStatus) {
        this.OrderStatus = OrderStatus;
    }

    /**
     * @return the DeliveryAddress
     */
    public String getDeliveryAddress() {
        return DeliveryAddress;
    }

    /**
     * @param DeliveryAddress the DeliveryAddress to set
     */
    public void setDeliveryAddress(String DeliveryAddress) {
        this.DeliveryAddress = DeliveryAddress;
    }

    /**
     * @return the Amount
     */
    public BigDecimal getAmount() {
        return Amount;
    }

    /**
     * @param Amount the Amount to set
     */
    public void setAmount(BigDecimal Amount) {
        this.Amount = Amount;
    }

    /**
     * @return the Percentage
     */
    public BigDecimal getPercentage() {
        return Percentage;
    }

    /**
     * @param Percentage the Percentage to set
     */
    public void setPercentage(BigDecimal Percentage) {
        this.Percentage = Percentage;
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
