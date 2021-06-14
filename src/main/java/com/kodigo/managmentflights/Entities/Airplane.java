package com.kodigo.managmentflights.Entities;

import lombok.*;

@Data
public class Airplane extends Entity {
    private String airplane;
    private short  capacity;
    private String model;
    private short flyCapacity;
}
