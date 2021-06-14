package com.kodigo.managmentflights.DAL;

import com.kodigo.managmentflights.Entities.Airplane;
import jdk.jfr.Timespan;

import java.util.List;

public class AirplaneInMemoryRepository extends InMemoryRepository<Airplane>{

    public AirplaneInMemoryRepository(){
        Airplane A1 = new Airplane();
        A1.setAirplane("Airplane1");
        A1.setCapacity((short) 45);
        A1.setModel("Jumbo");
        A1.setFlyCapacity((short) 56);
        entities.add(A1);

        Airplane A2 = new Airplane();
        A2.setAirplane("Airplane2");
        A2.setCapacity((short) 56);
        A2.setModel("Bussiness");
        A2.setFlyCapacity((short) 23);
        entities.add(A2);

        Airplane A3 = new Airplane();
        A3.setAirplane("Airplane3");
        A3.setCapacity((short) 12);
        A3.setModel("Jue");
        A3.setFlyCapacity((short) 10);
        entities.add(A3);
    }
    // Todos los metodos adicionales.
 public Airplane findAirplaneById(String id){
        Airplane result=null;
        for (Airplane a:entities){
            String identifier = a.getId();
            if (identifier.equalsIgnoreCase(id)){
                result = a;
                break;
            }
        }

        return result;
 }
}
