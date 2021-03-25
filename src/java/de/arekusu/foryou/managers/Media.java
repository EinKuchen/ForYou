package de.arekusu.foryou.managers;

import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;

public class Media {

    public static void previous() {
        GlobalScreen.postNativeEvent(new NativeKeyEvent(2401, 0, 177, 57360, NativeKeyEvent.CHAR_UNDEFINED));
    }

    public static void pause() {
        GlobalScreen.postNativeEvent(new NativeKeyEvent(2401, 0, 179, 57378, NativeKeyEvent.CHAR_UNDEFINED));
    }

    public static void skip() {
        GlobalScreen.postNativeEvent(new NativeKeyEvent(2401, 0, 176, 57369, NativeKeyEvent.CHAR_UNDEFINED));
    }
}
