package com.ratuvog.gameoflife;

public class PlayGameState extends GameState {
    public PlayGameState(GameBoard board) {
        super(board);
    }

    @Override
    public GameState moveToState(int state) {
        switch (state) {
            case DRAFT: return new DraftGameState(board);
            default: return this;
        }
    }

    @Override
    public Drawer getDrawer() {
        return new WorldDrawer(board);
    }

    @Override
    public void onTouch(float x, float y) { }

    @Override
    public String message() {
        return "Life is started!";
    }

}
