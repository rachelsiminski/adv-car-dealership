package com.pluralsight.advcardealership;

import com.pluralsight.advcardealership.model.Contract;
import com.pluralsight.advcardealership.model.LeaseContract;
import com.pluralsight.advcardealership.model.SalesContract;
import com.pluralsight.advcardealership.model.Vehicle;
import com.pluralsight.advcardealership.ui.UserInterface;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        Vehicle sale = new Vehicle(1, 1, "A", "a", "AA", "a", 1, new BigDecimal("995.00"));
        Vehicle lease = new Vehicle(2, 2, "A", "a", "AA", "a", 1, new BigDecimal("31,995.00"));

        Contract salesContract = new SalesContract(LocalDate.now(), "A", "a", sale, true);
        Contract leaseContract = new LeaseContract(LocalDate.now(), "A", "a", lease);

        ArrayList<Contract> tests = new ArrayList<>();
        //userInterface.displayBanner();
        //userInterface.display();
    }
}
