package com.ratuvog.gameoflife;

public class Life {
     public int color;
     public boolean dead;
    public static final int LIFE_SIZE = 30;

    public Life(boolean dead) {
        color = 0xff000099;
        this.dead = dead;
    }
}
