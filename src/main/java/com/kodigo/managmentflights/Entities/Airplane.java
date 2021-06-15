package com.kodigo.managmentflights.Entities;

import lombok.*;

@Getter@Setter
public class Airplane extends Entity {
    private String airplane;
    private short  capacity;
    private String model;
    private short flyCapacity;
    private String airline;

    public Airplane() {
    }

    public Airplane(String airline, String model) {
        this.airline=airline;
        this.model=model;
    }
    public String toString() {
        StringBuilder string =new StringBuilder();
        string.append(" Model: ")
                .append(this.model)
                .append(" Airline: ")
                .append(airline).append(" Fly Capacity: ").append(this.flyCapacity).append(" Capacity: ").append(capacity);

        return string.toString();
    }
}
