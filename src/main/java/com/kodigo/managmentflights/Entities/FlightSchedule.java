package com.kodigo.managmentflights.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor@NoArgsConstructor@Setter@Getter
public class FlightSchedule extends Entity {
    private Date dateDaparture;
    private Date dateArrival;
    private Date RealDeparture;
    private Date RealArrival;
    Status status;
    private String Comment;
    public FlightSchedule(Date departure, Date arrival){
        this.dateDaparture=departure;
        this.dateArrival=arrival;
    }
    public String toString() {
        StringBuilder string =new StringBuilder();
        string.append(" Status: ")
                .append(this.status)
                .append(" Departure Date: ")
                .append(this.dateDaparture)
                .append(" Arrival Date: ")
                .append(dateArrival)
                .append("\n");

        return string.toString();
    }
}
