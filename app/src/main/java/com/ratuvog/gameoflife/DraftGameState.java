package com.ratuvog.gameoflife;

/**
 * Created by ratuvog on 04.07.14.
 */
public class DraftGameState extends GameState {
    public DraftGameState(GameBoard board) {
        super(board);
        board.clear();
    }

    @Override
    public GameState moveToState(int state) {
        switch (state) {
            case PLAY: return new PlayGameState(board);
            default: return this;
        }
    }

    @Override
    public Drawer getDrawer() {
        return new DraftWorldDrawer(board);
    }

    @Override
    public void onTouch(float x, float y) {
        board.reanimate(x, y);
    }
}
