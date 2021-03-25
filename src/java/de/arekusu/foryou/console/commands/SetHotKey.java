package de.arekusu.foryou.console.commands;

import de.arekusu.foryou.console.CommandExecutor;
import de.arekusu.foryou.listener.HotKeyListener;
import de.arekusu.foryou.managers.HotKey;
import org.jnativehook.keyboard.NativeKeyEvent;

public class SetHotKey implements CommandExecutor {
    private enum HotKeys {
        PREV,
        PAUSE,
        SKIP
    }

    @Override
    public void onExecute(String[] args) {
        //TODO: Set hotkeys
        if(args.length == 1) {
            switch (args[0]) {
                case "prev":
                    record(HotKeys.PREV);
                    break;
                case "pause":
                    record(HotKeys.PAUSE);
                    break;
                case "next":
                    record(HotKeys.SKIP);
                    break;
                default:
                    System.out.println(">> Wrong command syntax! Please use <setHotKey [prev | pause | next]>");
                    break;
            }
        }else
            System.out.println(">> Wrong command syntax! Please use <setHotKey [prev | pause | next]>");
    }

    public synchronized void record(HotKeys hotKey) {
        int old = HotKeyListener.getLastKeyPressed();

        System.out.println(" ");
        System.out.println(">> Press new HotKey for the " + hotKey.name() + " Key!");
        while (old == HotKeyListener.getLastKeyPressed()) {
            try {
                wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int newKey = HotKeyListener.getLastKeyPressed();

        switch (hotKey) {
            case PREV:
                HotKey.INSTANCE.setPreviousKey(newKey);
                break;
            case PAUSE:
                HotKey.INSTANCE.setPauseKey(newKey);
                break;
            case SKIP:
                HotKey.INSTANCE.setSkipKey(newKey);
                break;
        }

        System.out.println(">> Changed " + hotKey.name() + " to " + NativeKeyEvent.getKeyText(newKey));
        System.out.println(" ");
    }
}
