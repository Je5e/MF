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

        return "-----------------------------------------------------------\n" +
                " idFlight: " +
                this.getId() +
                "\n Flight number: " +
                flightNumber +
                "\n Airplane: " +
                airplane +
                "\n departure from: " +
                departure +
                "\n arrival: " +
                arrival +
                "\n Schedules: " +
                schedules +
                "\n-----------------------------------------------------------\n";
    }


}
