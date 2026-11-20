package com.pluralsight.advcardealership.model;

import java.math.BigDecimal;

public abstract class Contract {
    private String dateOfContract;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;
    private BigDecimal totalPrice;
    private BigDecimal monthlyPayment;

    public Contract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, BigDecimal totalPrice, BigDecimal monthlyPayment) {
        this.dateOfContract = dateOfContract;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public abstract BigDecimal getTotalPrice();

    public abstract BigDecimal getMonthlyPayment();
}
