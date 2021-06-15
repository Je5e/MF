package com.kodigo.managmentflights.DAL;

import com.kodigo.managmentflights.Entities.Airplane;
import com.kodigo.managmentflights.Entities.Flight;
import com.kodigo.managmentflights.Entities.FlightSchedule;
import jdk.jfr.Timespan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightInMemoryRepository extends InMemoryRepository<Flight> {
    public FlightInMemoryRepository(){
        Flight F1 = new Flight();
        F1.setFlightNumber("FG1");
        flights.add(F1);

        Flight F2 = new Flight();
        F1.setFlightNumber("FG2");
        entities.add(F1);

        Flight F3 = new Flight();
        F1.setFlightNumber("FG3");
        entities.add(F1);
    }
    public List<Flight> getFlightsByDate(Date date) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : entities) {
            for (FlightSchedule fs : flight.getSchedules()) {
                var departureDate = fs.getDateDaparture();
                var arrivelDate = fs.getDateArrival();
                if (departureDate.equals(date) && arrivelDate.equals(date)) {
                    result.add(flight);
                }
            }
        }
        return result;
    }
}
