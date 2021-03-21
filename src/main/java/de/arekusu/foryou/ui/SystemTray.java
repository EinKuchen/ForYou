package de.arekusu.foryou.ui;

import de.arekusu.foryou.managers.Resources;

import java.awt.*;

public class SystemTray {
    public static final SystemTray INSTANCE = new SystemTray();

    private java.awt.SystemTray tray;
    private TrayIcon trayIcon = new TrayIcon(Resources.INSTANCE.getDefaultIcon(), "ForYou", null);
    private PopupMenu menu = new PopupMenu();

    public SystemTray() {
        trayIcon.setImageAutoSize(true);
        tray = java.awt.SystemTray.getSystemTray();
    }


    public void createTray() {
        try {
            MenuItem show = new MenuItem("Fenster öffnen");
            MenuItem close = new MenuItem("Beenden");

            show.addActionListener(e -> UI.INSTANCE.showUI());
            close.addActionListener(e -> System.exit(0));
            menu.add(show);
            menu.addSeparator();
            menu.add(close);

            trayIcon.setPopupMenu(menu);
            tray.add(trayIcon);
        }catch (Exception exception) {exception.printStackTrace();}
    }
}
