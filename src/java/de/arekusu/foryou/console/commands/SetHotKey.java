package de.arekusu.foryou.console.commands;

import de.arekusu.foryou.console.CommandExecutor;
import de.arekusu.foryou.listener.HotKeyListener;

public class SetHotKey implements CommandExecutor {
    @Override
    public void onExecute(String[] args) {
        //TODO: Set hotkeys
        if(args.length == 1) {
            switch (args[0]) {
                case "prev":
                    System.out.println("Set prev Key");
                    break;
                case "pause":
                    System.out.println("Set pause Key");
                    break;
                case "next":
                    System.out.println("Set next Key");
                    break;
                default:
                    System.out.println(">> Wrong command syntax! Please use <setHotKey [prev | pause | next]>");
                    break;
            }
        }else
            System.out.println(">> Wrong command syntax! Please use <setHotKey [prev | pause | next]>");
    }
}
