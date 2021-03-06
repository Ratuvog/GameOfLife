package com.ratuvog.gameoflife;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class GameOfLife extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_of_life);

        ImageButton play = (ImageButton)findViewById(R.id.playButton);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                World w = (World)findViewById(R.id.scene);
                w.setState(GameState.PLAY);
            }
        });

        ImageButton replay = (ImageButton)findViewById(R.id.replayButton);
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                World w = (World)findViewById(R.id.scene);
                w.setState(GameState.DRAFT);
            }
        });

        ScoreBoard score = (ScoreBoard)findViewById(R.id.score);
        World w = (World)findViewById(R.id.scene);
        score.setGameBoard(w.game());
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game_of_life, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
