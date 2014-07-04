package com.ratuvog.gameoflife;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class DraftWorldDrawer extends Drawer {

    protected GameBoard board;

    public DraftWorldDrawer(GameBoard board) {
        this.board = board;
    }

    public void drawBoard(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        Paint p = new Paint();
        p.setAntiAlias(true);
        for (int i = 0; i < board.rowCount(); ++i) {
            for (int j = 0; j < board.columnCount(); ++j) {
                Life l = board.get(i,j);
                if (l.dead) continue;
                p.setColor(l.color);
                canvas.drawRect(i * l.LIFE_SIZE, j * l.LIFE_SIZE,
                                (i+1) * l.LIFE_SIZE , (j+1) * l.LIFE_SIZE, p);
            }
        }
    }

    public void draw(Canvas canvas) {
        drawBoard(canvas);
    }

}
