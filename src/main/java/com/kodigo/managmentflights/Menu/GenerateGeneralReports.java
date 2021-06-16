package com.kodigo.managmentflights.Menu;

import com.kodigo.managmentflights.ConsoleApp.Program;
import com.kodigo.managmentflights.Entities.Flight;
import com.kodigo.managmentflights.Entities.FlightSchedule;
import com.kodigo.managmentflights.helpers.DocumentGeneratorImp;
import com.kodigo.managmentflights.helpers.EmailImp;
import com.kodigo.managmentflights.services.APIWeather;
import com.kodigo.managmentflights.services.APIWeatherImp;
import com.kodigo.managmentflights.services.WeatherForecast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class GenerateGeneralReports extends Options {
    Scanner scanner = new Scanner(System.in);
    WeatherForecast apiWeather=new WeatherForecast(new APIWeatherImp());
    public GenerateGeneralReports(Integer code) {
        this.code = code;
        this.description = "Generate General Reports.";
    }

    public void executeAction() {
        int optionFromInput;
        do {
            System.out.println("General reports: ");
            optionFromInput = getOptions();

            if (optionFromInput != 0) {
                try {
                    if (optionFromInput == 1) {
                        getAndGenerateFlightsByDateReport();
                    } else if (optionFromInput == 2) {
                        getAndGenerateFlightByIdReport();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } while (optionFromInput != 0);
    }
//getAndGenerateFlightByIdReport  getAndGenerateFlightsByDateReport
    private void getAndGenerateFlightsByDateReport() {
        System.out.println("Enter date to look for (mm/dd/yyy):");
        String op = scanner.next();
        try {
            var flightsAtDate =
                    ManageFlights.flightsrepository.getFlightsByDate(new Date(op));
            if (flightsAtDate != null) {

                System.out.println("Report flighst: " + op);
                for (Flight flight : flightsAtDate) {
                    System.out.println(flight.getFlightNumber());
                    System.out.println("-------------------------------");
                    System.out.println(flight.getDeparture().getCountry());
                    System.out.println(flight.getDeparture().getCity());
                    System.out.println(flight.getAirplane());
                    for (FlightSchedule flightSchedule : flight.getSchedules()) {
                        System.out.println(flightSchedule.getDateDaparture().toString());
                        System.out.println(flightSchedule.getDateArrival().toString());
                        System.out.println(flightSchedule.getStatus().toString());
                        System.out.println(flightSchedule.getComment().toString());
                    }
                }
                System.out.println("Generating report...............");
                var result = new DocumentGeneratorImp().writeToExcelFile(flightsAtDate,
                        "flighstsByDateReport.xls",apiWeather.getTempetureF());
                if (result) {
                    System.out.println("Report has been succesfull generated...");
                    System.out.println("Sending email...");
                   // scanner.next();
                    var isSended = new EmailImp().SendEmail("flighstsByDateReport.xls");
                    if (isSended) {
                        System.out.println("Email has been sent...");
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void getAndGenerateFlightByIdReport() {
        // logic here...
        System.out.println("Enter Id to look for: ");
        String op = scanner.next();
        try {
            var flight =
                    ManageFlights.flightsrepository.getFlightById(op);
            if (flight != null) {

                System.out.println("Report flighst: " + op);

                System.out.println(flight.getFlightNumber());
                System.out.println("-------------------------------");
                System.out.println(flight.getDeparture().getCountry());
                System.out.println(flight.getDeparture().getCity());
                System.out.println(flight.getAirplane());
                for (FlightSchedule flightSchedule : flight.getSchedules()) {
                    System.out.println(flightSchedule.getDateDaparture().toString());
                    System.out.println(flightSchedule.getDateArrival().toString());
                    System.out.println(flightSchedule.getStatus().toString());
                    System.out.println(flightSchedule.getComment().toString());
                }

                System.out.println("Generating report...............");
                List<Flight> format = new ArrayList<>();
                format.add(flight);


                var result = new DocumentGeneratorImp().writeToExcelFile(format,
                        "flighstsByIdReport.xls",apiWeather.getTempetureF());
                if (result) {
                    System.out.println("Report has been succesfull generated...");
                    var isSended = new EmailImp().SendEmail("flighstsByIdReport.xls");
                    if (isSended) {
                        System.out.println("Email has been sent...");
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private int getOptions() {
        int opt = 0;
        try {
            System.out.println("1 - Flights by Date.");
            System.out.println("2 - Flight by Id.");
            System.out.println("0 - Back");
            opt = parseInt(scanner.next());
        } catch (Exception e) {
            e.printStackTrace();

        }

        return opt;
    }
}
