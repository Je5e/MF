package com.kodigo.managmentflights.ConsoleApp;

import com.kodigo.managmentflights.DAL.AirplaneInMemoryRepositoryImp;
import com.kodigo.managmentflights.DAL.Interfaces.IAirplaneInMemoryRepository;
import com.kodigo.managmentflights.Entities.Airplane;

import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        IAirplaneInMemoryRepository<Airplane> repositoryAirplane =
                new AirplaneInMemoryRepositoryImp();

     Set<Airplane> airplaneList = repositoryAirplane.findAll();
        System.out.println("Id\tAirplane");
        for(Airplane airplane:airplaneList){
            System.out.println(airplane.getId()+"\t"+airplane.getAirplane());
        }

        System.out.print("FIND BY ID");
        System.out.print("Enter Id to find: ");
        String id = sc.next();
        System.out.print("Airplane finded: ");
        Airplane airplane = repositoryAirplane.findAirplaneById(id);
        System.out.println("Id\tAirplane");
        System.out.println(airplane.getId()+"\t"+airplane.getAirplane());

        System.out.print("DELETE");
        repositoryAirplane.delete(airplane);
         airplaneList = repositoryAirplane.findAll();
        System.out.println("Id\tAirplane");
        for(Airplane ai:airplaneList){
            System.out.println(ai.toString()+"\t"+ai.getAirplane());
        }

        System.out.print("UPDATE");
        System.out.print("Enter Id to UPDATE: ");
        String id1 = sc.next();
        System.out.print("Enter AIRPLANE to UPDATE: ");
        String airplaneName = sc.next();
        Airplane ai = repositoryAirplane.findAirplaneById(id1);
        ai.setAirplane(airplaneName);
        //Airplane auddated = repositoryAirplane.update(ai);

        airplaneList = repositoryAirplane.findAll();
        System.out.println("Id\tAirplane");
        for(Airplane aii:airplaneList){
            System.out.println(aii.getId()+"\t"+aii.getAirplane());
        }
    }
}
