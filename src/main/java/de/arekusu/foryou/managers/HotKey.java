package de.arekusu.foryou.managers;

import org.jnativehook.keyboard.NativeKeyEvent;

public class HotKey {
    public static final HotKey INSTANCE = new HotKey(NativeKeyEvent.VC_F6, NativeKeyEvent.VC_F7, NativeKeyEvent.VC_F8);

    private int previousKey;
    private int pauseKey;
    private int skipKey;

    public HotKey(int previousKey, int pauseKey, int skipKey) {
        this.previousKey = previousKey;
        this.pauseKey = pauseKey;
        this.skipKey = skipKey;
    }


    public void setPreviousKey(int previousKey) {
        this.previousKey = previousKey;
    }

    public void setPauseKey(int pauseKey) {
        this.pauseKey = pauseKey;
    }

    public void setSkipKey(int skipKey) {
        this.skipKey = skipKey;
    }

    public int getPreviousKey() {
        return previousKey;
    }

    public int getPauseKey() {
        return pauseKey;
    }

    public int getSkipKey() {
        return skipKey;
    }
}
