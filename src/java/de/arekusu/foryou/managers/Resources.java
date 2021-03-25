package de.arekusu.foryou.managers;

import java.awt.*;

public class Resources {

    public static Image getDefaultIcon() {
        return Toolkit.getDefaultToolkit().getImage(Resources.class.getClassLoader().getResource("images/icon.png"));
    }

    public static Image getDefaultBackground() {
        return Toolkit.getDefaultToolkit().getImage(Resources.class.getClassLoader().getResource("images/background.png"));
    }
}
