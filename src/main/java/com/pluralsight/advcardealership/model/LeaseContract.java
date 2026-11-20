package com.pluralsight.advcardealership.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LeaseContract extends Contract {
    private BigDecimal expectedEndValue;
    private BigDecimal leaseFee;

    public LeaseContract(LocalDate dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, BigDecimal expectedEndValue, BigDecimal leaseFee) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.expectedEndValue = expectedEndValue;
        this.leaseFee = leaseFee;
    }

    public BigDecimal getExpectedEndValue() {
        return getVehicleSold().getPrice().multiply(new BigDecimal(".5"));
    }

    public void setExpectedEndValue(BigDecimal expectedEndValue) {
        this.expectedEndValue = expectedEndValue;
    }

    public BigDecimal getLeaseFee() {
        return getVehicleSold().getPrice().multiply(new BigDecimal(".07"));
    }

    public void setLeaseFee(BigDecimal leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return getExpectedEndValue().add(getLeaseFee());
    }

    public BigDecimal getMonthlyPayment() {
        return null;
    }
}
