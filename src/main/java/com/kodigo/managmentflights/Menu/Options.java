package com.kodigo.managmentflights.Menu;
public abstract class Options {
    protected int code;
    protected String description;

    public Options() {
    }

    public abstract void executeAction();

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}
