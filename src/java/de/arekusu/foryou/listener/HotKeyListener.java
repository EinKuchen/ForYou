package de.arekusu.foryou.listener;

import de.arekusu.foryou.console.Console;
import de.arekusu.foryou.managers.HotKey;
import de.arekusu.foryou.managers.Media;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HotKeyListener implements NativeKeyListener {

    private static int lastKeyCodePressed;

    public static void initialize() {
        try {
            Logger.getLogger(GlobalScreen.class.getPackage().getName()).setLevel(Level.OFF);
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(new HotKeyListener());
        } catch (NativeHookException exception) {exception.printStackTrace();}
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        if(Console.INSTANCE.isConsoleMode()) lastKeyCodePressed = nativeKeyEvent.getKeyCode();

        if(nativeKeyEvent.getKeyCode() == HotKey.INSTANCE.getPreviousKey()) {
            Media.previous();
            return;
        }
        if(nativeKeyEvent.getKeyCode() == HotKey.INSTANCE.getPauseKey()) {
            Media.pause();
            return;
        }
        if(nativeKeyEvent.getKeyCode() == HotKey.INSTANCE.getSkipKey()) {
            Media.skip();
            return;
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    public static int getLastKeyCodePressed() {
        return lastKeyCodePressed;
    }
}
