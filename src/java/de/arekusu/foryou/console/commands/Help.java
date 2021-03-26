package de.arekusu.foryou.console.commands;

import de.arekusu.foryou.console.CommandExecutor;

public class Help implements CommandExecutor {
    @Override
    public void onExecute(String args[]) {
        System.out.println(">> [List of all Commands]");
        System.out.println(">> Help                            || Shows you a list of all commands.");
        System.out.println(">> Exit                            || Quit the settings command line and save made changes.");
        System.out.println(">> Reset                           || Delete configs and regenerate after launch of the application.");
        System.out.println(">> SetHotKey [prev | pause | next] || Let you change your HotKeys.");
    }
}
