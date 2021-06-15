package com.kodigo.managmentflights.Menu;

import java.util.Scanner;

public class ManageFlights extends Options{
    // IFlightRepository repository;

    public ManageFlights(Integer code) {
        this.code = code;
        this.description = "Manage Flights.";
    }
    public void executeAction() {
        StringBuilder submenuFlights= new StringBuilder();
        submenuFlights.append("This is the submenu of Manage Flights, please select one of the options below \n")
                .append("1.Insert Flights\n")
                .append("2.Update Flight Status\n")
                .append("3.Generate Flight Reports\n")
                .append("4.Exit");

        System.out.println(submenuFlights);
        Scanner f = new Scanner(System.in);
        System.out.println("Enter one of the above options");
        String txt = f.nextLine();
        System.out.println(txt);





    }
}
