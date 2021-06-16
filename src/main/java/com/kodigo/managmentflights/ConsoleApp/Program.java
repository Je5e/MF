package com.kodigo.managmentflights.ConsoleApp;

import com.kodigo.managmentflights.DAL.AirplaneInMemoryRepositoryImp;
import com.kodigo.managmentflights.DAL.FlightInMemoryRepositoryImp;
import com.kodigo.managmentflights.DAL.Interfaces.IAirplaneInMemoryRepository;
import com.kodigo.managmentflights.DAL.Interfaces.IFlightInMemoryRepository;
import com.kodigo.managmentflights.Entities.Airplane;
import com.kodigo.managmentflights.Entities.Flight;
import com.kodigo.managmentflights.Menu.MainMenuOptionList;
import com.kodigo.managmentflights.Menu.Options;

import java.util.List;
import java.util.Scanner;

public class Program {
    public static IAirplaneInMemoryRepository<Airplane> repositoryAirplane =
            new AirplaneInMemoryRepositoryImp();
    static boolean salir = false;

    public static void main(String[] args) {
        iniciar();
    }

    public static void iniciar() {
        while (!Program.salir) {
            int opcionSeleccionada = mostrarMenu();
            try {
                Options o = MainMenuOptionList.getOption(opcionSeleccionada);
                o.executeAction();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            iniciar();
        }
    }

    private static int mostrarMenu() {
        int result;
        System.out.println("Opciones:");
        System.out.println("----------------------");

        List<Options> options = MainMenuOptionList.getOptions();

        for (Options op : options) {
            System.out.println(op.getCode() + " - " + op.getDescription());
        }
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite: ");
        result = sc.nextInt();

        return result;
    }

    public static void Salir() {
        salir = true;
    }
}
