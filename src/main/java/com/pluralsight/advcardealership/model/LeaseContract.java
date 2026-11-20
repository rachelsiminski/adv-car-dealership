package com.pluralsight.advcardealership.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class LeaseContract extends Contract {
    private final BigDecimal END_VALUE_MODIFIER = new BigDecimal(".50");
    private final BigDecimal LEASING_FEE = new BigDecimal(".07");
    private final BigDecimal LEASING_PERCENT = new BigDecimal("4.00");
    private BigDecimal expectedEndValue;
    private BigDecimal leaseFee;
    private final int LEASING_TERM = 36;


    public LeaseContract(LocalDate dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }

    public BigDecimal getExpectedEndValue() {
        return getVehicleSold().getPrice().multiply(END_VALUE_MODIFIER);
    }

    public void setExpectedEndValue(BigDecimal expectedEndValue) {
        this.expectedEndValue = expectedEndValue;
    }

    public BigDecimal getLeaseFee() {
        return getVehicleSold().getPrice().multiply(LEASING_FEE);
    }

    public void setLeaseFee(BigDecimal leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return getExpectedEndValue().add(getLeaseFee()).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        return LoanCalculator.calculateMonthlyPayment(getTotalPrice(), LEASING_PERCENT, LEASING_TERM);
    }
}
