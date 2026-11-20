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
        userInterface.displayBanner();
        userInterface.display();
    }
}
