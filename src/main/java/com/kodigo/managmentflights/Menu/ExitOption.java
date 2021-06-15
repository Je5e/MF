package com.kodigo.managmentflights.Menu;

import com.kodigo.managmentflights.ConsoleApp.Program;

public class ExitOption extends Options{
    public ExitOption(int code){
        this.code=code;
        this.description="Exit.";
    }
    @Override
    public void executeAction() {
        Program.Salir();
    }
}
