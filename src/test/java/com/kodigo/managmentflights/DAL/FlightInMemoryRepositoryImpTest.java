package com.kodigo.managmentflights.DAL;

import com.kodigo.managmentflights.DAL.Interfaces.IFlightInMemoryRepository;
import com.kodigo.managmentflights.Entities.Flight;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FlightInMemoryRepositoryImpTest {
    @Test
    void getFlightsByDate() {
    }
    @Test
    void itShouldCheckIfaflightIsAdded(){
        // given
        IFlightInMemoryRepository underTest= new FlightInMemoryRepositoryImp();
        Flight flight = new Flight();
        flight.setFlightNumber("8754a");
        // when
        underTest.create(flight);
        // then
        var flights = underTest.findAll();
        assertThat(flights).isEqualTo(1);
    }
}