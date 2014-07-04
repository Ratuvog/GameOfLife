package com.ratuvog.gameoflife;

public class GameState {

    protected GameBoard board;
    public static final int DRAFT = 0x00;
    public static final int PLAY = 0x01;

    public GameState(GameBoard board) {
        this.board = board;
    }

    public GameState moveToState(int state) {
        return this;
    }

    public Drawer getDrawer() {
        return null;
    }

    public void onTouch(float x, float y) {

    }

    public String message() {
        return null;
    }
}
