package de.arekusu.foryou.console.commands;

import de.arekusu.foryou.console.CommandExecutor;

public class Help implements CommandExecutor {
    @Override
    public void onExecute(String args[]) {
        System.out.println(" ");
        System.out.println(">> [List of all Commands]");
        System.out.println(">> Help                            || Shows you a list of all commands.");
        System.out.println(">> Exit                            || Quit the settings command line.");
        System.out.println(">> SetHotKey [prev | pause | next] || Let you change your HotKeys.");
        System.out.println(" ");
    }
}
