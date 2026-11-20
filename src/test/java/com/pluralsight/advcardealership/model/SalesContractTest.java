package com.pluralsight.advcardealership.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SalesContractTest {

    @Test
    public void getProcessingFee_should_returnLowValueFeeForLowValueVehicle() {
        Vehicle sale = new Vehicle(1, 1, "A", "a", "AA", "a", 1, new BigDecimal("995.00"));
        Contract salesContract = new SalesContract(LocalDate.now(), "A", "a", sale, false);
        BigDecimal expectedProcessingFee = new BigDecimal("295.00");

        assertEquals(expectedProcessingFee, ((SalesContract) salesContract).getProcessingFee());
    }

    @Test
    public void getProcessingFee_should_returnHighValueFeeForHighValueVehicle() {
        Vehicle sale = new Vehicle(1, 1, "A", "a", "AA", "a", 1, new BigDecimal("10995.00"));
        Contract salesContract = new SalesContract(LocalDate.now(), "A", "a", sale, false);
        BigDecimal expectedProcessingFee = new BigDecimal("495.00");

        assertEquals(expectedProcessingFee, ((SalesContract) salesContract).getProcessingFee());
    }

    @Test
    public void getMonthlyPayment_should_returnZeroForNotIsFinanced() {
        Vehicle sale = new Vehicle(1, 1, "A", "a", "AA", "a", 1, new BigDecimal("995.00"));
        Contract salesContract = new SalesContract(LocalDate.now(), "A", "a", sale, false);
        BigDecimal expectedMonthlyPayment = BigDecimal.ZERO;

        assertEquals(expectedMonthlyPayment, salesContract.getMonthlyPayment());
    }

    @Test
    public void getTotalPrice_should_returnXForNoFinanceLowValueVehicle() {
        Vehicle sale = new Vehicle(1, 1, "A", "a", "AA", "a", 1, new BigDecimal("995.00"));
        Contract salesContract = new SalesContract(LocalDate.now(), "A", "a", sale, false);
        BigDecimal expectedTotalPrice = new BigDecimal("1439.75");

        assertEquals(expectedTotalPrice, salesContract.getTotalPrice());
    }

    @Test
    public void getTotalPrice_should_returnXForFinancedHighValueVehicle() {
        Vehicle sale = new Vehicle(1, 1, "A", "a", "AA", "a", 1, new BigDecimal("10995.00"));
        Contract salesContract = new SalesContract(LocalDate.now(), "A", "a", sale, true);
        BigDecimal expectedTotalPrice = new BigDecimal("12139.75");

        assertEquals(expectedTotalPrice, salesContract.getTotalPrice());
    }
}