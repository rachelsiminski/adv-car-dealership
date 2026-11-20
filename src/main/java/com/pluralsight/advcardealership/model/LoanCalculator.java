package com.pluralsight.advcardealership.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoanCalculator {
    public static BigDecimal calculateMonthlyPayment(BigDecimal amount, BigDecimal yearlyRatePercent, int months) {
        BigDecimal monthlyRate = yearlyRatePercent.divide(new BigDecimal("1200"), 20, RoundingMode.HALF_UP);
        BigDecimal growth = BigDecimal.ONE.add(monthlyRate).pow(months);

        return amount.multiply(monthlyRate)
                .multiply(growth)
                .divide(growth.subtract(BigDecimal.ONE), 2, RoundingMode.HALF_UP);
    }
}
