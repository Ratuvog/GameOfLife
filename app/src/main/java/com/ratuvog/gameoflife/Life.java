package com.ratuvog.gameoflife;

public class Life {
     public int color;
     public boolean dead;
     public int size = 30;

    public Life(boolean dead) {
        color = 0xff000099;
        this.dead = dead;
    }

    static public Life randomLife() {
        Life l = new Life(true);
        //l.color = (int)(Math.random() * (float)0xffffff) + 0xff000000;
        l.dead = (int)(Math.random() * (float)1000) % 41 == 0;
        return l;
    }
}
