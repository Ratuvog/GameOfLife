package com.ratuvog.gameoflife;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Pair;

import java.util.ArrayList;

public class WorldDrawer extends Drawer {

    private int rowCount = 480/15;
    private int columnCount = 720/15;
    private ArrayList<ArrayList<Life>> world;
    private int frame = 1;

    public WorldDrawer() {
        initialize();
    }

    private void initialize() {
        world = new ArrayList<ArrayList<Life>>();
        for (int i = 0; i < rowCount; ++i) {
            ArrayList<Life> row = new ArrayList<Life>();
            for (int j = 0; j < columnCount; ++j) {
                row.add(new Life(true));
            }
            world.add(row);
        }

        ArrayList<Pair<Integer, Integer>> dir = new ArrayList<Pair<Integer, Integer>>();
        dir.add(new Pair<Integer,Integer>(10, 10));
        dir.add(new Pair<Integer,Integer>(11, 10));
        dir.add(new Pair<Integer,Integer>(12, 10));
        dir.add(new Pair<Integer,Integer>(12, 11));
        dir.add(new Pair<Integer,Integer>(12, 12));

        for(Pair<Integer,Integer> d : dir) {
            world.get(d.first).get(d.second).dead = false;
        }

    }

    public void draw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        Paint p = new Paint();
        p.setAntiAlias(true);
        for (int i = 0; i < rowCount; ++i) {
            ArrayList<Life> row = world.get(i);
            for (int j = 0; j < columnCount; ++j) {
                Life l = row.get(j);
                if (l.dead) continue;
                p.setColor(l.color);
                canvas.drawRect(i * l.size, j * l.size, i * l.size + l.size, j * l.size + l.size, p);
            }
        }
        if (frame % 50 == 0) {
            gameProcess();
        }
        frame++;
    }

    private void gameProcess() {
        ArrayList<ArrayList<Life>> newWorld = world;
        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < columnCount; ++j) {
                int alive = aliveNeighbourCount(i, j);
                newWorld.get(i).get(j).dead = !(alive >= 2 && alive <= 3);
            }
        }
        world = newWorld;
    }

    private int aliveNeighbourCount(int i, int j) {
        int count = 0;
        ArrayList<Pair<Integer, Integer>> dir = new ArrayList<Pair<Integer, Integer>>();
        dir.add(new Pair<Integer,Integer>(1, 0));
        dir.add(new Pair<Integer,Integer>(1, 1));
        dir.add(new Pair<Integer,Integer>(1, -1));
        dir.add(new Pair<Integer,Integer>(0, 1));
        dir.add(new Pair<Integer,Integer>(0, -1));
        dir.add(new Pair<Integer,Integer>(-1, 0));
        dir.add(new Pair<Integer,Integer>(-1, 1));
        dir.add(new Pair<Integer,Integer>(-1, -1));

        for(Pair<Integer,Integer> d : dir) {
            if (i + d.first >= 0 && i + d.first < rowCount &&
                    j + d.second >= 0 && j + d.second < columnCount) {
                if (!world.get(i+d.first).get(j+d.second).dead)
                    count++;
            }
        }
        return count;
    }
}