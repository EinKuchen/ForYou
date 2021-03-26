package de.arekusu.foryou.main;

import de.arekusu.foryou.console.Console;
import de.arekusu.foryou.listener.HotKeyListener;
import de.arekusu.foryou.managers.Config;
import de.arekusu.foryou.ui.SystemTray;
import de.arekusu.foryou.ui.UI;

public class Main {

    public static final String VERSION = "1.1";

    public static void main(String[] args) {
        HotKeyListener.initialize();
        Config.load();
        if(args.length == 0) {
            SystemTray.INSTANCE.createTray();
            UI.INSTANCE.showUI();
        }else
            new Console();

    }
}
