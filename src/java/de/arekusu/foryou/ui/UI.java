package de.arekusu.foryou.ui;


import de.arekusu.foryou.managers.Resources;

import javax.swing.*;
import java.awt.*;

public class UI {
    public static final UI INSTANCE = new UI();

    private final JFrame frame = new JFrame("ForYou");

    public UI() {
        try {
            frame.setIconImage(Resources.getDefaultIcon());
            frame.setSize(500, 125);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

            frame.setContentPane(new JLabel(new ImageIcon(Resources.getDefaultBackground())));
            frame.setLayout(new GridBagLayout());
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;

            JLabel label = new JLabel("Previous Track: F6 || Pause Track: F7 || Next Track: F8");
            label.setForeground(Color.CYAN);
            frame.add(label, gridBagConstraints);
        }catch (Exception exception) {exception.printStackTrace();}
    }


    public void showUI() {
        frame.setVisible(true);
    }

    public void hideUI() {
        frame.setVisible(false);
    }

    public boolean isHidden() {
        return !frame.isVisible();
    }
}
