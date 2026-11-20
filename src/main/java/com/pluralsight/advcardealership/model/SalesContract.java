package com.pluralsight.advcardealership.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class SalesContract extends Contract{
    private BigDecimal processingFee;
    private final BigDecimal SALES_TAX = new BigDecimal(".05");
    private final BigDecimal RECORDING_FEE = new BigDecimal("100");
    private final BigDecimal VALUE_THRESHOLD = new BigDecimal("10000");
    private final BigDecimal HIGH_VALUE_PERCENT = new BigDecimal(".0425");
    private final BigDecimal LOW_VALUE_PERCENT = new BigDecimal(".0525");
    private final BigDecimal HIGH_VALUE_PROCESSING_FEE = new BigDecimal("495.00");
    private final BigDecimal LOW_VALUE_PROCESSING_FEE = new BigDecimal("295.00");
    private final int HIGH_VALUE_TERM = 48;
    private final int LOW_VALUE_TERM = 24;
    private boolean isFinanced;

    public SalesContract(LocalDate dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.isFinanced = isFinanced;
    }

    public BigDecimal getSALES_TAX() {
        return SALES_TAX;
    }

    public BigDecimal getRECORDING_FEE() {
        return RECORDING_FEE;
    }

    public BigDecimal getProcessingFee() {
        if (getVehicleSold().getPrice().compareTo(VALUE_THRESHOLD) < 0) {
            return LOW_VALUE_PROCESSING_FEE;
        } else {
            return HIGH_VALUE_PROCESSING_FEE;
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
        return (getVehicleSold().getPrice().multiply(SALES_TAX.add(BigDecimal.ONE))).add(getRECORDING_FEE()).add(getProcessingFee()).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        if (isFinanced) {
            if (getVehicleSold().getPrice().compareTo(VALUE_THRESHOLD) < 0) {
                return LoanCalculator.calculateMonthlyPayment(getVehicleSold().getPrice(), LOW_VALUE_PERCENT, LOW_VALUE_TERM);
            } else {
                return LoanCalculator.calculateMonthlyPayment(getVehicleSold().getPrice(), HIGH_VALUE_PERCENT, HIGH_VALUE_TERM);
            }
        } else {
            return BigDecimal.ZERO;
        }
    }
}
