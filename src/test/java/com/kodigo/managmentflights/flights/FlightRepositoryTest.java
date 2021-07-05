package com.kodigo.managmentflights.flights;

import com.kodigo.managmentflights.DAL.FlightInMemoryRepositoryImp;
import com.kodigo.managmentflights.DAL.Interfaces.IFlightInMemoryRepository;
import com.kodigo.managmentflights.Entities.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


 class FlightRepositoryTest {

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
       assertThat(flights.stream().count()).isEqualTo(4);
    }
}
