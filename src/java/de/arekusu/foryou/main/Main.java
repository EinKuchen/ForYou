package de.arekusu.foryou.main;

import de.arekusu.foryou.console.Console;
import de.arekusu.foryou.listener.HotKeyListener;
import de.arekusu.foryou.ui.SystemTray;
import de.arekusu.foryou.ui.UI;

public class Main {
    public static void main(String[] args) {
        if(!args[0].equals("-settings")) {
            HotKeyListener.initialize();
            SystemTray.INSTANCE.createTray();
            UI.INSTANCE.showUI();
        }else
            Console.INSTANCE.initialize();

    }
}
