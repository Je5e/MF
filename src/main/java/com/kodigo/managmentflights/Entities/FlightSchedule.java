package com.kodigo.managmentflights.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor@NoArgsConstructor@Setter@Getter
public class FlightSchedule {
    private Date dateDaparture;
    private Date dateArrival;
    private Date RealDeparture;
    private Date RealArrival;
    Status status;
    private String Comment;
}
