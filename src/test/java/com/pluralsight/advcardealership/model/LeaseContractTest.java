package com.pluralsight.advcardealership.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LeaseContractTest {

    @Test
    public void getTotalPrice_should_returnExpectedTotalPrice() {
        Vehicle lease = new Vehicle(2, 2, "A", "a", "AA", "a", 1, new BigDecimal("31995.00"));
        Contract leaseContract = new LeaseContract(LocalDate.now(), "A", "a", lease);
        BigDecimal expectedTotalPrice = new BigDecimal("18237.15");

        assertEquals(expectedTotalPrice, leaseContract.getTotalPrice());
    }

}