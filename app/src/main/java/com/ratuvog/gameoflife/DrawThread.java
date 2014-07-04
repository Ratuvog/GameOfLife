package com.ratuvog.gameoflife;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class DrawThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private boolean running = false;
    private Drawer drawer;

    public DrawThread(SurfaceHolder holder, Drawer drawer) {
        surfaceHolder = holder;
        this.drawer = drawer;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setDrawer(Drawer drawer) { this.drawer = drawer; }

    public void run() {
        Canvas canvas;
        while (running) {
            canvas = null;
            try {
                canvas = surfaceHolder.lockCanvas(null);
                if (canvas == null) continue;
                drawer.draw(canvas);
            } finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }


}
