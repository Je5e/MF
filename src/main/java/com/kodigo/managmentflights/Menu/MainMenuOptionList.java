package com.kodigo.managmentflights.Menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainMenuOptionList {
    static List<Options> options = new ArrayList();

    public MainMenuOptionList() {
    }

    public static Options getOption(int codigo) {
        Options result = null;
        Iterator var2 = options.iterator();

        while(var2.hasNext()) {
            Options op = (Options)var2.next();
            if (op.code == codigo) {
                result = op;
                break;
            }
        }

        return result;
    }

    public static List<Options> getOptions() {
        return options;
    }

    static {
        options.add(new ManageFlights(1));
        options.add(new ManageAirplanes(2));
        options.add(new GenerateGeneralReports(3));
        options.add(new ExitOption(4));
    }
}
