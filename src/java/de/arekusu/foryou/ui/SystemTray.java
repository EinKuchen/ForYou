package de.arekusu.foryou.ui;

import de.arekusu.foryou.managers.Resources;

import java.awt.*;
import java.awt.event.*;

public class SystemTray {
    public static final SystemTray INSTANCE = new SystemTray();

    private final java.awt.SystemTray tray;
    private final TrayIcon trayIcon = new TrayIcon(Resources.getDefaultIcon(), "ForYou", null);
    private final PopupMenu menu = new PopupMenu();

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

            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getButton() != 1) return;
                    if(UI.INSTANCE.isHidden()) {
                        UI.INSTANCE.showUI();
                    }else
                        UI.INSTANCE.hideUI();
                }
            });
            trayIcon.setPopupMenu(menu);
            tray.add(trayIcon);
        }catch (Exception exception) {exception.printStackTrace();}
    }
}
