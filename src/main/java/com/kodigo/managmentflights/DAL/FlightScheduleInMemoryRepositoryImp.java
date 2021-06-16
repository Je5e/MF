package com.kodigo.managmentflights.DAL;

import com.kodigo.managmentflights.DAL.Interfaces.IFlighScheduleInMemoryRepository;
import com.kodigo.managmentflights.Entities.FlightSchedule ;

public class FlightScheduleInMemoryRepositoryImp  extends InMemoryRepositoryImp<FlightSchedule>
        implements IFlighScheduleInMemoryRepository<FlightSchedule> {
    public FlightSchedule findFlightScheduleById(String id) {
        FlightSchedule result = null;
        for (FlightSchedule a : entities) {
            String identifier = a.getId();
            if (identifier.equalsIgnoreCase(id)) {
                result = a;
                break;
            }
        }
        return result;
    }
}
