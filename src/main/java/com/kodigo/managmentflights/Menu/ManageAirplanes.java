package com.kodigo.managmentflights.Menu;

import com.kodigo.managmentflights.DAL.AirplaneInMemoryRepository;
import com.kodigo.managmentflights.Entities.Airplane;

import java.util.Scanner;
import java.util.Set;

public class ManageAirplanes extends  Options{

    public ManageAirplanes(Integer code) {
        this.code = code;
        this.description = "Manage Flights.";
    }
    public void executeAction() {
        System.out.println("This is the action of the Manage Airplane Menu");
        AirplaneInMemoryRepository repository = new AirplaneInMemoryRepository();

        Set<Airplane> airplaneList = repository.findAll();
        System.out.println("Id\tAirplane");
        for(Airplane airplane:airplaneList){
            System.out.println(airplane.getId()+"\t"+airplane.getAirplane());
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("FIND BY ID");
        System.out.print("Enter Id to find: ");
        String id = sc.next();
        System.out.print("Airplane finded: ");
        Airplane airplane = repository.findAirplaneById(id);
        System.out.println("Id\tAirplane");
        System.out.println(airplane.getId()+"\t"+airplane.getAirplane());

        System.out.print("DELETE");
        repository.delete(airplane);
        airplaneList = repository.findAll();
        System.out.println("Id\tAirplane");
        for(Airplane ai:airplaneList){
            System.out.println(ai.toString()+"\t"+ai.getAirplane());
        }

        System.out.print("UPDATE");
        System.out.print("Enter Id to UPDATE: ");
        String id1 = sc.next();
        System.out.print("Enter AIRPLANE to UPDATE: ");
        String airplaneName = sc.next();
        Airplane ai = repository.findAirplaneById(id1);
        ai.setAirplane(airplaneName);
        //Airplane auddated = repository.update(ai);

        airplaneList = repository.findAll();
        System.out.println("Id\tAirplane");
        for(Airplane aii:airplaneList){
            System.out.println(aii.getId()+"\t"+aii.getAirplane());
        }
    }
}
