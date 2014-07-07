package com.ratuvog.gameoflife;

public class Life {
    public static final int LIFE_SIZE = 40;

    public int color = 0xff000099;
    public boolean dead;

    public Life(boolean dead) {
        this.dead = dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
