package com.kodigo.managmentflights.DAL.Interfaces;

import com.kodigo.managmentflights.DAL.Interfaces.Base.IRepository;
import com.kodigo.managmentflights.Entities.Airplane;
import com.kodigo.managmentflights.Entities.Entity;

public interface IAirplaneInMemoryRepository extends IRepository<Airplane> {
  Airplane findAirplaneById(String id);
}
