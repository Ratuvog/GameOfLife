package com.ratuvog.gameoflife;

import android.util.Pair;

import java.util.ArrayList;

public class GameBoard {
    private int rowCount = 480/15;
    private int columnCount = 720/15;
    private ArrayList<ArrayList<Life>> world;

    public GameBoard() {
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
        return world.get(i).get(j);
    }
}
