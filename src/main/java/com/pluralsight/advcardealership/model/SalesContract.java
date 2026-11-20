package com.pluralsight.advcardealership.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.pluralsight.advcardealership.model.LoanCalculator.calculateMonthlyPayment;

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
        if (getVehicleSold().getPrice().compareTo(new BigDecimal("10000.00")) <= 0) {
            return new BigDecimal("295.00");
        } else {
            return new BigDecimal("495.00");
        }
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
        return (getVehicleSold().getPrice().multiply(salesTax)).add(getRecordingFee()).add(getProcessingFee());
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        if (isFinanced) {
            if (getVehicleSold().getPrice().compareTo(new BigDecimal("10000.00")) < 0) {
                calculateMonthlyPayment(getVehicleSold().getPrice(), new BigDecimal(".0525"), 24);
            } else {
                calculateMonthlyPayment(getVehicleSold().getPrice(), new BigDecimal(".0425"), 48);
            }
        } else {
            return new BigDecimal("0.00");
        }
        return null;
    }
}
