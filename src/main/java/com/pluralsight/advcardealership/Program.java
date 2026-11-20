package com.pluralsight.advcardealership;

import com.pluralsight.advcardealership.ui.UserInterface;

public class Program {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.displayBanner();
        userInterface.display();
    }
}
