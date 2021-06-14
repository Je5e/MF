package com.kodigo.managmentflights.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Flight extends Entity {
    private String flightNumber;
    private Airplane airplane;
    private Location departure;
    private Location arrival;
    private List<FlightSchedule> schedules;

    public Flight() {
        schedules = new ArrayList<>();
    }
}
