package com.kodigo.managmentflights.DAL;

import com.kodigo.managmentflights.Entities.Flight;
import com.kodigo.managmentflights.Entities.FlightSchedule;
import jdk.jfr.Timespan;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightInMemoryRepository extends InMemoryRepository<Flight> {

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
