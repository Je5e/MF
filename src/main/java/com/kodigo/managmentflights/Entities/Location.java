package com.kodigo.managmentflights.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class Location {
    private String countryCode;
    private String country;
    private String city;
    private String cityCode;
}
