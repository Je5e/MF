package com.kodigo.managmentflights.ConsoleApp;

import com.kodigo.managmentflights.DAL.AirplaneInMemoryRepository;
import com.kodigo.managmentflights.DAL.IRepository;
import com.kodigo.managmentflights.Entities.Airplane;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        AirplaneInMemoryRepository repository = new AirplaneInMemoryRepository();
        Set<Airplane> airplaneList = repository.findAll();
        System.out.println("Id\tAirplane");
        for(Airplane airplane:airplaneList){
            System.out.println(airplane.getId()+"\t"+airplane.getAirplane());
        }

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
            System.out.println(ai.getId()+"\t"+ai.getAirplane());
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
