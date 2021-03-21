package de.arekusu.foryou.managers;

import java.awt.*;

public class Resources {
    public final static Resources INSTANCE = new Resources();


    public Image getDefaultIcon() {
        return Toolkit.getDefaultToolkit().getImage(Resources.class.getClassLoader().getResource("images/icon.png"));
    }

    public Image getDefaultBackground() {
        return Toolkit.getDefaultToolkit().getImage(Resources.class.getClassLoader().getResource("images/background.png"));
    }
}
