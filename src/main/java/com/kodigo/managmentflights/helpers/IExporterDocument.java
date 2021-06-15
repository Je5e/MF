package com.kodigo.managmentflights.helpers;

import com.kodigo.managmentflights.Entities.Flight;

import java.util.List;

public interface IExporterDocument {

    boolean writeToExcelFile(List<Flight> flightList, String filePath);
}
