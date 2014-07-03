package com.ratuvog.gameoflife;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class World extends View {

    public int capacity = 1000;
    public ArrayList<Life> citizens;

    public World(Context context) {
        super(context);
        initCitizens();
    }
    
    public World(Context context, AttributeSet as) {
        super(context, as);
        initCitizens();
    }

    public World(Context context, AttributeSet as, int shlyapa) {
        super(context, as, shlyapa);
        initCitizens();
    }

    private void initCitizens() {
        citizens = new ArrayList<Life>();
        for (int i = 0; i < capacity; ++i) {
            citizens.add(Life.randomLife(new Size(getWidth(), getHeight())));
        }
    }

    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        p.setAntiAlias(true);

        for (Life l : citizens) {
            p.setColor(l.color);
            canvas.drawCircle(50, 50, 10, p);
        }
    }
}
