package com.kodigo.managmentflights.Menu;

import com.kodigo.managmentflights.ConsoleApp.Program;
import com.kodigo.managmentflights.DAL.AirplaneInMemoryRepositoryImp;
import com.kodigo.managmentflights.DAL.Interfaces.IAirplaneInMemoryRepository;
import com.kodigo.managmentflights.Entities.Airplane;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class ManageAirplanes extends Options {

    Scanner sc = new Scanner(System.in);

    public ManageAirplanes(Integer code) {
        this.code = code;
        this.description = "Manage Airplanes.";

    }

    public void executeAction() {

        int optionInput;
        do {
            System.out.println("This is the action of the Manage Airplane Menu");


            Set<Airplane> airplaneList = Program.repositoryAirplane.findAll();
            System.out.println("---------------------------------");
            System.out.println("Id\t\t\tAirplane\t\tAirline");
            System.out.println("---------------------------------");
            for (Airplane airplane : airplaneList) {
                System.out.println(airplane.getId() + "\t" + airplane.getAirplane()+"\t\t"+airplane.getAirline());
            }

            System.out.println("---------------------------------");
            optionInput = getSubOptions();

            if (optionInput != 0) {

                //tionInput);
                try {
                    if (optionInput==1){
                        InsertAirplane();
                    }else if (optionInput==2){
                        UpdateAirplane();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } while (optionInput != 0);


    }

    private void UpdateAirplane() {
        System.out.println("UPDATE");
       var airplaneList = Program.repositoryAirplane.findAll();
        System.out.println("Id\tAirplane\t\t\tAirline");
        for(Airplane aii:airplaneList){
            System.out.println(aii.getId()+"\t"+aii.getAirplane()+"\t\t"+aii.getAirline());
        }
        System.out.print("Enter Id to UPDATE: ");
        String id1 = sc.next();
        System.out.print("Enter AIRPLANE to UPDATE: ");
        String airplaneName = sc.next();
        System.out.print("Enter model to UPDATE: ");
        String airplaneModel = sc.next();
        System.out.print("Enter capacity to UPDATE: ");
        int capacity = parseInt( sc.next());
        System.out.print("Enter FlyCapaciaty to UPDATE: ");
        int Flycapacity = parseInt( sc.next());
        System.out.print("Enter Airlane to UPDATE: ");
        String airlane = sc.next();
        Airplane ai = Program.repositoryAirplane.findAirplaneById(id1);
        ai.setAirplane(airplaneName);
        ai.setCapacity(capacity);
        ai.setModel(airplaneModel);
        ai.setAirline(airlane);
        ai.setFlyCapacity(Flycapacity);
    }

    private void InsertAirplane() {

        System.out.print("Enter airplane: ");
        String airplaneName = sc.next();

        System.out.print("Enter Capacity: ");
        int airplaneCapacity = parseInt( sc.next());

        System.out.print("Enter Model: ");
        String airplaneModel = sc.next();

        System.out.print("Enter Airline: ");
        String airlane = sc.next();

        System.out.print("Enter airplane: ");
        String airplane =sc.next();

        Airplane newAirplane= new Airplane();
        newAirplane.setAirplane(airplaneName);
        //newAirplane.setFlyCapacity(capacityFly);
        newAirplane.setModel(airplaneModel);
        newAirplane.setCapacity(airplaneCapacity);
        newAirplane.setAirline(airlane);

        Program.repositoryAirplane.create(newAirplane);
    }

    int getSubOptions() {
        int op=0;


        try {
            System.out.println("1 - Insert Airplane.");
            System.out.println("2 - Update Airplane.");
            System.out.println("0 - Back");
            op = parseInt(sc.next());
        } catch (Exception e) {
            e.printStackTrace();

        }

        return op;
    }


}
