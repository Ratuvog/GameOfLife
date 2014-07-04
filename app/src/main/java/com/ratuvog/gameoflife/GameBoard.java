package com.ratuvog.gameoflife;

import android.util.Pair;

import java.util.ArrayList;

public class GameBoard {
    private int k = Life.LIFE_SIZE;
    private int rowCount;
    private int columnCount;
    private ArrayList<ArrayList<Life>> world;

    public GameBoard(Size size) {
        rowCount = size.h/k;
        columnCount = size.w/k;
        clear();
    }

    public void clear() {
        world = new ArrayList<ArrayList<Life>>();
        for (int i = 0; i < rowCount; ++i) {
            ArrayList<Life> row = new ArrayList<Life>();
            for (int j = 0; j < columnCount; ++j) {
                row.add(new Life(true));
            }
            world.add(row);
        }
    }

    public int rowCount() {
        return rowCount;
    }

    public int columnCount() {
        return columnCount;
    }

    public Life get(int i, int j) {
        int dx = ((j) % columnCount + columnCount) % columnCount;
        int dy = ((i) % rowCount + rowCount) % rowCount;
        return world.get(dy).get(dx);
    }

    public void gameProcess() {
        ArrayList<ArrayList<Life>> newWorld = new ArrayList<ArrayList<Life>>();
        for (int i = 0; i < rowCount; ++i) {
            ArrayList<Life> row = new ArrayList<Life>();
            for (int j = 0; j < columnCount; ++j) {
                row.add(new Life(true));
            }
            newWorld.add(row);
        }

        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < columnCount; ++j) {
                int alive = aliveNeighbourCount(i, j);
                if (world.get(i).get(j).dead)
                    newWorld.get(i).get(j).dead = alive != 3;
                else
                    newWorld.get(i).get(j).dead = alive < 2 || alive > 3;
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

            if (!get(d.first + i, d.second + j).dead)
                count++;
        }
        return count;
    }

    public void reanimate(float x, float y) {
        get((int)x/k, (int)y/k).dead = false;
    }
}