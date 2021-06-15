package com.kodigo.managmentflights.Entities;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Flight extends Entity {
    private String flightNumber;
    private Airplane airplane;
    private int airplaneId;
    private Location departure;
    private Location arrival;
    private List<FlightSchedule> schedules;

    public Flight() {
        schedules = new ArrayList<>();
    }

    public String toString() {
     StringBuilder string =new StringBuilder();
     string.append("-----------------------------------------------------------\n")
             .append(" idFlight: ")
             .append(this.getId())
             .append("\n Flight number: ")
             .append(flightNumber)
             .append("\n Airplane: ")
             .append(airplane)
             .append("\n departure from: ")
             .append(departure)
             .append("\n arrival: ")
             .append(arrival)
             .append("\n Schedules: ")
             .append(schedules)
             .append("\n-----------------------------------------------------------\n");

     return string.toString();
    }


}
