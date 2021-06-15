package com.kodigo.managmentflights.Menu;

public class GenerateGeneralReports extends Options{
    public GenerateGeneralReports(Integer code) {
        this.code = code;
        this.description = "Generate General Reports.";
    }
    public void executeAction() {
        System.out.println("This is the action of the General Reports");

    }
}
