package com.kodigo.managmentflights.DAL.Interfaces;


import com.kodigo.managmentflights.DAL.Interfaces.Base.IRepository;
import com.kodigo.managmentflights.Entities.Entity;
import com.kodigo.managmentflights.Entities.FlightSchedule;

public interface IFlighScheduleInMemoryRepository  extends IRepository<FlightSchedule> {
    FlightSchedule findFlightScheduleById(String id);
}
