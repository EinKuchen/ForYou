package de.arekusu.foryou.console;

import de.arekusu.foryou.console.commands.Help;
import de.arekusu.foryou.console.commands.SetHotKey;
import de.arekusu.foryou.main.Main;
import de.arekusu.foryou.managers.Config;

import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private final HashMap<String, CommandExecutor> commands = new HashMap<>();
    private static boolean consoleMode;


    public Console() {
        Scanner input = new Scanner(System.in);
        consoleMode = true;

        System.out.println("\n" +
                " ___  __   __          __       \n" +
                "|__  /  \\ |__)    \\ / /  \\ |  | \n" +
                "|    \\__/ |  \\     |  \\__/ \\__/ \n" +
                "                                \n");
        System.out.println("Version: " + Main.VERSION);
        System.out.println(">> Type <Help> for more information!");
        System.out.println(">> Please use <Exit> for quiting this command line to prevent errors!");

        registerCommand("Help", new Help());
        registerCommand("SetHotKey", new SetHotKey());
        registerCommand("reset", args -> {
            Config.delete();
            System.out.println(">> Configuration files deleted!");
        });
        registerCommand("Exit", args -> {
            Config.save();
            System.exit(0);
        });

        while(true) {
            System.out.println(" ");
            System.out.print("|>");

            String inputString = input.nextLine();
            String command = inputString.split(" ")[0].toLowerCase();
            String args[] = new String[0];

            if(inputString.split(" ", 2).length > 1) {
                args = inputString.split(" ", 2)[1].split(" ");
            }

            System.out.println(" ");
            if(commands.get(command) != null)
                commands.get(command).onExecute(args);
        }
    }

    public void registerCommand(String name, CommandExecutor command) {
        commands.put(name.toLowerCase(), command);
    }

    public static boolean isConsoleMode() {
        return consoleMode;
    }
}
