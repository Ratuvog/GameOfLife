package com.ratuvog.gameoflife;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class World extends SurfaceView implements SurfaceHolder.Callback {

    private DrawThread thread;
    private GameBoard board;

    public World(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    public World(Context context, AttributeSet as) {
        super(context, as);
        getHolder().addCallback(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        MotionEvent.PointerCoords coords = new MotionEvent.PointerCoords();
        event.getPointerCoords(0, coords);
        return true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        thread = new DrawThread(getHolder(), new DraftWorldDrawer(board));
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
