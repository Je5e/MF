package com.kodigo.managmentflights.DAL.Interfaces;

import com.kodigo.managmentflights.DAL.Interfaces.Base.IRepository;
import com.kodigo.managmentflights.Entities.Entity;
import com.kodigo.managmentflights.Entities.Flight;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IFlightInMemoryRepository extends IRepository<Flight> {

     List<Flight> getFlightsByDate(Date date);
     Flight getFlightById(String id);
     void AddFlightsArrayList(List<Flight> flights);
}
