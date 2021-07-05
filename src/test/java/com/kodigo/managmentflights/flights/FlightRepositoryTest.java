package com.kodigo.managmentflights.flights;

import com.kodigo.managmentflights.DAL.FlightInMemoryRepositoryImp;
import com.kodigo.managmentflights.DAL.Interfaces.IFlightInMemoryRepository;
import com.kodigo.managmentflights.Entities.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

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
        var actual = underTest.findAll().size();
        int expected = 4;
       assertThat(actual).isEqualTo(expected);
    }
    @Test
     void itShouldCheckIfCanGetAFlightByDate(){
        // given
        IFlightInMemoryRepository underTest= new FlightInMemoryRepositoryImp();

        // when
       var actual= underTest.getFlightsByDate(new Date("6/20/2021")).size();

        // then
       int expected =1;
        assertThat(actual).isEqualTo(expected);
    }
}
