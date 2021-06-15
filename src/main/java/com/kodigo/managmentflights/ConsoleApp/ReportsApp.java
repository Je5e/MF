package com.kodigo.managmentflights.ConsoleApp;

import com.kodigo.managmentflights.DAL.FlightInMemoryRepositoryImp;
import com.kodigo.managmentflights.DAL.Interfaces.IFlightInMemoryRepository;
import com.kodigo.managmentflights.Entities.Flight;
import com.kodigo.managmentflights.helpers.IExporterDocument;
import com.kodigo.managmentflights.helpers.ImporterDocumentImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportsApp {
    public static void main(String[] args) {
        // Programamos para una Interfaz y no para una implementacion Inversion of Control
        // principol.

        IFlightInMemoryRepository<Flight> repo = new FlightInMemoryRepositoryImp();

       // var flights = repo.findAll().stream().toList();
        String id = "";
        /*
        for (Flight f : flights) {
            System.out.println(f.getId());
            id = f.getId();
            break;
        }*/
        var flights = repo.getFlightsByDate(new Date("06/15/2021"));
        repo .AddFlightsArrayList(flights);
         // Get Flight By Id. Report.
        //var flight = repo.getFlightById(id);
        IExporterDocument exporterDocument = new ImporterDocumentImp();
        //List<Flight> data = new ArrayList<>();
        //data.add(flight);
        exporterDocument.writeToExcelFile(flights, "report.xls");
    }
}
