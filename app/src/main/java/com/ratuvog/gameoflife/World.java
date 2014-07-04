package com.ratuvog.gameoflife;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

public class World extends SurfaceView implements SurfaceHolder.Callback {

    private DrawThread thread;
    private GameBoard board;
    private GameState currentState;

    private void initialize(Context context)
    {
        getHolder().addCallback(this);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display d = wm.getDefaultDisplay();
        Point p = new Point();
        d.getSize(p);
        Size s = new Size(p.x, p.y);
        board = new GameBoard(s);

        currentState = new DraftGameState(board);
    }

    public World(Context context) {
        super(context);
        initialize(context);
    }

    public World(Context context, AttributeSet as) {
        super(context, as);
        initialize(context);
    }

    public void setState(int state) {
        currentState = currentState.moveToState(state);
        Drawer d = currentState.getDrawer();
        if (d != null) thread.setDrawer(currentState.getDrawer());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        MotionEvent.PointerCoords coords = new MotionEvent.PointerCoords();
        event.getPointerCoords(0, coords);
        currentState.onTouch(coords.x, coords.y);
        return true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        thread = new DrawThread(getHolder(), currentState.getDrawer());
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        boolean retry = true;
        thread.setRunning(false);
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }
}
