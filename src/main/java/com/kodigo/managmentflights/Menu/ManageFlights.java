package com.kodigo.managmentflights.Menu;

import com.kodigo.managmentflights.ConsoleApp.Program;
import com.kodigo.managmentflights.DAL.FlightInMemoryRepositoryImp;
import com.kodigo.managmentflights.Entities.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManageFlights extends Options {
    FlightInMemoryRepositoryImp flightsrepository = new FlightInMemoryRepositoryImp();
    // IFlightRepository repository;

    public ManageFlights(Integer code) {
        this.code = code;
        this.description = "Manage Flights.";
    }

    public void executeAction() throws ParseException, IOException {
      //  System.out.println(flightsrepository.findAll());
        var flightlist = flightsrepository.findAll();
        for (Flight flight:flightlist){
            System.out.println(flight);
        }
        String submenuFlights = """
                This is the submenu of Manage Flights, please select one of the options below\s
                1.Insert Flights
                2.Update Flight Status
                3.Generate Flight Reports
                4.Exit""";
        System.out.println(submenuFlights);
        Scanner f = new Scanner(System.in);
        System.out.println("Enter one of the above options");
        String option = f.nextLine();
        int decision = validateOption(option);

        switch (decision) {
            case 0 -> {
                System.out.println("Invalid Option, you are going back to the main menu");

            }
            case 1 -> submenuInsert();
            case 2 -> updateFlight();
            case 3 -> generateFlightsReport();
            case 4 -> System.out.println("You are going back to the main menu");
        }

    }

    private void generateFlightsReport() {
    }

    private void updateFlight() {
    }

    private int validateOption(String option) {
        if (Integer.parseInt(option) > 0 && Integer.parseInt(option) < 5) {
            return Integer.parseInt(option);
        } else {
            System.out.println("That's not a valid option");
        }
        return 0;
    }

    private void submenuInsert() throws ParseException, IOException {
        String submenuFlights = """
                 This is the submenu of Manage Flights, please select one of the options below\s
                 1.Insert Flight Manually
                 2.Insert Flight from an excel
                """;
        System.out.println(submenuFlights);
        Scanner f = new Scanner(System.in);
        System.out.println("Enter one of the above options");
        String option = f.nextLine();
        switch (option) {
            case "1":
                insertFlight();
                break;
            case "2":
                insertFlights();
                break;

        }
    }

    public void insertFlight() throws ParseException {
        List<FlightSchedule> flightSchedules = new ArrayList<>();
        Flight flight = new Flight();
        Location departure = new Location();
        Location arrival = new Location();
        Airplane airplane = new Airplane();
        FlightSchedule flightSchedule = new FlightSchedule();
        flight.setFlightNumber(getTheFlightNumber());
        airplane.setAirline(getTheAirpline());
        airplane.setModel(getTheModel());
        departure.setCountry(getTheCountry(0));
        departure.setCity(getTheCity(0));
        arrival.setCountry(getTheCountry(1));
        departure.setCity(getTheCity(1));
        flightSchedule.setDateDaparture(AskForDate(0));
        flightSchedule.setDateArrival(AskForDate(1));
        flightSchedules.add(flightSchedule);
        flight.setAirplane(airplane);
        flight.setSchedules(flightSchedules);
        flight.setDeparture(departure);
        flight.setArrival(arrival);
        flightsrepository.create(flight);
    }

    private void insertFlights() throws IOException, ParseException {
        loadFlights(loadData());
    }

    public void loadFlights(Map<Integer, List<String>> data) throws ParseException {
        ArrayList<Flight> flights= new ArrayList<>();
        for (Integer key : data.keySet()) {
            Flight flight = new Flight();
            System.out.println(data.get(key).get(0) + " " +data.get(key).get(1) + " "+data.get(key).get(2)+" "+data.get(key).get(3) + " "+data.get(key).get(4)+" "+data.get(key).get(5) + " "+data.get(key).get(6));
            List<FlightSchedule> flightSchedules = new ArrayList<>();
            Airplane airplane;
            Location origin;
            Location destination;
            Date departure;
            Date arrival;
            //Data preparation
            airplane = new Airplane(data.get(key).get(1), data.get(key).get(2));
            origin = new Location(data.get(key).get(3), data.get(key).get(4));
            destination = new Location(data.get(key).get(5), data.get(key).get(6));
            SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ENGLISH);
            SimpleDateFormat def = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            DateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");
            departure = def.parse(targetFormat.format(formatter.parse(data.get(key).get(7))));
            arrival = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ENGLISH).parse(data.get(key).get(8));
            //adicion de miembros
            FlightSchedule flightSchedule = new FlightSchedule(departure, arrival);
            flightSchedules.add(flightSchedule);
            flight.setFlightNumber(data.get(key).get(0));
            flight.setAirplane(airplane);
            flight.setSchedules(flightSchedules);
            flight.setDeparture(destination);
            flight.setArrival(origin);
            flights.add(flight);
            }
        flightsrepository.AddFlightsArrayList(flights);
    }

    public Map<Integer, List<String>> loadData() throws IOException {
        FileInputStream file = new FileInputStream("flights.xlsx");
        Workbook worbook = new XSSFWorkbook(file);
        Sheet sheet = worbook.getSheetAt(0);
        Map<Integer, List<String>> data = new HashMap<>();
        int i = 0;
        for (Row row : sheet) {
            data.put(i, new ArrayList<>());
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING:
                        data.get(i).add(cell.getRichStringCellValue().getString());
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            data.get(i).add(cell.getDateCellValue() + "");

                        } else {
                            data.get(i).add(cell.getNumericCellValue() + "");
                        }
                        break;
                    case BOOLEAN:
                        data.get(i).add(cell.getBooleanCellValue() + "");
                        break;
                    case FORMULA:
                        data.get(i).add(cell.getCellFormula() + "");
                        break;

                    default:
                        data.get(i).add("");
                }

            }
            i++;
        }
        return data;
    }

    public String getTheFlightNumber() {
        Scanner f = new Scanner(System.in);
        System.out.println("Enter the number of the flight");
        String txt = f.nextLine();
        return txt;
    }

    public String getTheAirpline() {
        Scanner f = new Scanner(System.in);
        System.out.println("Enter airline of the flight");
        String txt = f.nextLine();
        return txt;
    }

    public String getTheModel() {
        Scanner f = new Scanner(System.in);
        System.out.println("Enter the model of the airplane of the flight");
        String txt = f.nextLine();
        return txt;
    }

    public String getTheCountry(int decision) {
        Scanner f = new Scanner(System.in);
        if (decision == 1) {
            System.out.println("Enter the arrival country");
        } else {
            System.out.println("Enter the departure country");
        }
        String txt = f.nextLine();
        return txt;
    }

    public String getTheCity(int decision) {

        Scanner f = new Scanner(System.in);
        if (decision == 1) {
            System.out.println("Enter the arrival city");
        } else {
            System.out.println("Enter the departure city");
        }
        String txt = f.nextLine();
        return txt;
    }

    public Date AskForDate(int decition) throws ParseException {
        Scanner f = new Scanner(System.in);
        if (decition == 1) {
            System.out.println("Enter the arrival date dd/mm/yyyy");
        } else if (decition == 0) {
            System.out.println("Enter the departure date dd/mm/yyyy");
        } else {
            System.out.println("Enter a valid Date");
        }
        String txt = f.nextLine();
        String d = validate(txt);
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(d);
        return date;
    }

    private String validate(String txt) throws ParseException {
        Pattern pattern = Pattern.compile("([0-9/0-9/0-9])");
        Matcher matcher = pattern.matcher(txt);
        boolean matchFound = matcher.find();
        if (matchFound) {
            return txt;
        } else {
            return String.valueOf(AskForDate(3));
        }
    }
}
