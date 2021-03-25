package de.arekusu.foryou.console.commands;

import de.arekusu.foryou.console.CommandExecutor;

public class Help implements CommandExecutor {
    @Override
    public void onExecute(String args[]) {
        System.out.println(">> SetHotKey [prev | pause | next] || Change your Hotkeys!");
    }
}
