package com.ratuvog.gameoflife;

public class Life {
    public static final int LIFE_SIZE = 30;

    public int color;
    public boolean dead;

    private boolean prevDead = true;
    private boolean isChanged = false;

    public Life(boolean dead) {
        color = 0xff000099;
        this.dead = dead;
    }

    public void setDead(boolean dead) {
        this.prevDead = this.dead;
        this.dead = dead;
        this.isChanged = (this.dead != this.prevDead);
    }

    public boolean changed() {
        return isChanged;
    }
}
