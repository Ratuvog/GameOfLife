package com.ratuvog.gameoflife;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

public class World extends View {

    public static int capacity = 1000;
    public List<Life> citizens;

    public class Size {
        public int w,h;
        public Size(View v) {
            w = v.getWidth();
            h = v.getHeight();
        }

    }

    public World(Context context) {
        super(context);
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
        for (int i = 0; i < capacity; ++i) {
            citizens.add(Life.randomLife(new Size(this)));
        }
    }

    protected void onDraw(Canvas canvas) {
        Paint p = new Paint();
        p.setAntiAlias(true);

        for (int i = 0; i < capacity; ++i) {
            Life l = citizens.get(i);
            p.setColor(l.color);
            canvas.drawCircle(50, 50, 10, p);
        }
    }
}
