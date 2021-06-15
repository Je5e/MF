package com.kodigo.managmentflights.Menu;

import java.io.IOException;
import java.text.ParseException;

public abstract class Options {
    protected int code;
    protected String description;

    public Options() {
    }

    public abstract void executeAction() throws ParseException, IOException;

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}
