package com.pluralsight.advcardealership.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SalesContract extends Contract{
    private BigDecimal salesTax = new BigDecimal(".05");
    private BigDecimal recordingFee = new BigDecimal("100.00");
    private BigDecimal processingFee;
    private boolean isFinanced;

    public SalesContract(LocalDate dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, BigDecimal salesTax, BigDecimal recordingFee, BigDecimal processingFee, boolean isFinanced) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.isFinanced = isFinanced;
    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(BigDecimal salesTax) {
        this.salesTax = salesTax;
    }

    public BigDecimal getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(BigDecimal recordingFee) {
        this.recordingFee = recordingFee;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return null;
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        return null;
    }
}
