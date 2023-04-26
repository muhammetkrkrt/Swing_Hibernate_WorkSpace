/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.muhammetkarakurt.bankamatik.entity;

/**
 *
 * @author Muhammet Karakurt
 */
public class Account {
    private long id ;
    private String accountNo;
    private double balance;
    private long userId;
    private String password;
    
    
    public Account() {
    }

    public Account(long id, String accountNo, double balance, long userId, String password) {
        this.id = id;
        this.accountNo = accountNo;
        this.balance = balance;
        this.userId = userId;
        this.password = password;
    }

    public Account(long id, String accountNo, double balance, long userId) {
        this.id = id;
        this.accountNo = accountNo;
        this.balance = balance;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", accountNo=" + accountNo + ", balance=" + balance + ", userId=" + userId + ", password=" + password + '}';
    }
    


    
    
    
}
