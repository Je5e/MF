package com.kodigo.managmentflights.DAL;

import com.kodigo.managmentflights.DAL.Interfaces.IFlightInMemoryRepository;
import com.kodigo.managmentflights.Entities.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightInMemoryRepositoryImp extends InMemoryRepositoryImp<Flight>
        implements IFlightInMemoryRepository<Flight> {

    public FlightInMemoryRepositoryImp() {
        // Flight
        Flight f1 = new Flight();
        f1.setFlightNumber("AA333");
        Location departureLoc = new Location();
        departureLoc.setCountry("Londres");
        departureLoc.setCity("kor");
        Location arravilLocation = new Location();
        arravilLocation.setCountry("Buenos Aires");
        arravilLocation.setCity("Cordoba");
        f1.setDeparture(departureLoc);
        f1.setArrival(arravilLocation);
        FlightSchedule fs = new FlightSchedule();
        fs.setDateDaparture(new Date("6/20/2021"));
        fs.setDateArrival(new Date("6/20/2021"));
        fs.setStatus(Status.Delay);
        f1.setSchedules(List.of(fs));
        entities.add(f1);
        Flight f2 = new Flight();
        f2.setFlightNumber("BBB222");
        Location departureLoc1 = new Location();
        departureLoc1.setCountry("El Salvador");
        departureLoc1.setCity("San Miguel");
        Location arravilLoc1 = new Location();
        arravilLoc1.setCountry("Canada");
        arravilLoc1.setCity("otawa");
        f2.setDeparture(departureLoc);
        f2.setArrival(arravilLocation);
        FlightSchedule fs1 = new FlightSchedule();
        fs1.setDateDaparture(new Date("6/15/2021"));
        fs1.setDateArrival(new Date("6/15/2021"));
        fs1.setStatus(Status.canceled);
        fs1.setComment("Bad weather!");
        f2.setSchedules(List.of(fs1));
        entities.add(f2);

        Flight f3 = new Flight();
        f3.setFlightNumber("CCC333");
        Location departureLoc2 = new Location();
        departureLoc2.setCountry("Cuba");
        departureLoc2.setCity("La Habana");
        Location arravilLoc2 = new Location();
        arravilLoc2.setCountry("Honduras");
        arravilLoc2.setCity("San Pedro");
        f3.setDeparture(departureLoc2);
        f3.setArrival(arravilLoc2);
        FlightSchedule fs2 = new FlightSchedule();
        fs2.setDateDaparture(new Date("6/15/2021"));
        fs2.setDateArrival(new Date("6/15/2021"));
        fs2.setStatus(Status.Landed);
        fs2.setComment("OK");
        f3.setSchedules(List.of(fs2));

        entities.add(f3);
    }

    public List<Flight> getFlightsByDate(Date date) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : entities) {
            for (FlightSchedule fs : flight.getSchedules()) {
                var departureDate = fs.getDateDaparture();
                var arrivelDate = fs.getDateArrival();
                if (departureDate.compareTo(date) == 0 && arrivelDate.compareTo(date) == 0) {
                    result.add(flight);
                }
            }
        }
        return result;
    }

    @Override
    public Flight getFlightById(String id) {
        Flight result=null;
        for (Flight a:entities){
            String identifier = a.getId();
            if (identifier.equalsIgnoreCase(id)){
                result = a;
                break;
            }
        }

        return result;
    }

    @Override
    public void AddFlightsArrayList(List<Flight> flights) {
        for (Flight f : flights) {
            entities.add(f);
        }

    }

}
