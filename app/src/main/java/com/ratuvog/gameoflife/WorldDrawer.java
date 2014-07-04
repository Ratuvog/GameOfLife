package com.ratuvog.gameoflife;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Pair;

import java.util.ArrayList;
import java.util.Timer;

public class WorldDrawer extends DraftWorldDrawer {

    private int frame = 1;
    private Timer timer;

    public WorldDrawer(GameBoard board)
    {
        super(board);
    }

    public void draw(Canvas canvas) {
        Timer t;

        drawBoard(canvas);
        board.gameProcess();
    }
}
