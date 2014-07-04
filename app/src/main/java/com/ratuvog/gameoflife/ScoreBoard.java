package com.ratuvog.gameoflife;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

public class ScoreBoard extends TextView {

    private GameBoard board;

    public ScoreBoard(Context context, AttributeSet as) {
        super(context, as);
    }

    public void setGameBoard(GameBoard board) {
        this.board = board;
    }

    @Override
    public void onDraw(Canvas canvas){
        if (board == null) return;
        setText(String.valueOf(board.score()));
        super.onDraw(canvas);
        invalidate();
    }
}
