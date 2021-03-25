package de.arekusu.foryou.console;

import de.arekusu.foryou.console.commands.Help;
import de.arekusu.foryou.console.commands.SetHotKey;

import java.util.HashMap;
import java.util.Scanner;

public class Console {
    public static final Console INSTANCE = new Console();

    private final HashMap<String, CommandExecutor> commands = new HashMap<>();
    private boolean consoleMode;


    public void initialize() {
        Scanner input = new Scanner(System.in);
        consoleMode = true;

        System.out.println("\n" +
                " ___  __   __          __       \n" +
                "|__  /  \\ |__)    \\ / /  \\ |  | \n" +
                "|    \\__/ |  \\     |  \\__/ \\__/ \n" +
                "                                \n");

        System.out.println(">> Type <Help> for more information!");

        registerCommand("help", new Help());
        registerCommand("setHotKey", new SetHotKey());

        while(true) {
            String inputString = input.nextLine().toLowerCase();
            String command = inputString.split(" ")[0];
            String args[] = new String[0];

            if(inputString.split(" ", 2).length > 1) {
                args = inputString.split(" ", 2)[1].split(" ");
            }

            if(commands.get(command) != null)
                commands.get(command).onExecute(args);
        }
    }

    public void registerCommand(String name, CommandExecutor command) {
        commands.put(name.toLowerCase(), command);
    }

    public boolean isConsoleMode() {
        return consoleMode;
    }
}