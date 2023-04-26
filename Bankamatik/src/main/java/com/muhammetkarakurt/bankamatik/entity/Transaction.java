/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.muhammetkarakurt.bankamatik.entity;

import java.util.Date;

/**
 *
 * @author Muhammet Karakurt
 */
public class Transaction {
    
    private long id ;
    private long receiverId;
    private long senderId;
    private double changeAmount;
    private String descreption;
    private Date transactionDate;

    public Transaction(long id, long receiverId, long senderId, double changeAmount, String descreption, Date transactionDate) {
        this.id = id;
        this.receiverId = receiverId;
        this.senderId = senderId;
        this.changeAmount = changeAmount;
        this.descreption = descreption;
        this.transactionDate = transactionDate;
    }

    public Transaction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public double getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(double changeAmount) {
        this.changeAmount = changeAmount;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", receiverId=" + receiverId + ", senderId=" + senderId + ", changeAmount=" + changeAmount + ", descreption=" + descreption + ", transactionDate=" + transactionDate + '}';
    }
    
    
    
}
