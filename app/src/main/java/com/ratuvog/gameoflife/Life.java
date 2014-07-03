package com.ratuvog.gameoflife;

public class Life {
     public int x;
     public int y;
     public int color;

    public Life() {
        y = 0;
        x = 0;
        color = 0x0;
    }

    static public Life randomLife(Size worldSize) {
        Life l = new Life();
        l.x = (int)(Math.random() * (double)worldSize.w);
        l.y = (int)(Math.random() * (double)worldSize.h);
        l.color = (int)(Math.random() * 0xffffffff);
        return l;
    }
}
