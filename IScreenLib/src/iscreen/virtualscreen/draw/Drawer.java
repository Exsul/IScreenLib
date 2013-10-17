package iscreen.virtualscreen.draw;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Drawer {
    private Canvas c = null;

    public void configure(final Canvas c) {
        this.c = c;
    }

    public void drawBitmap(final int id, final double x, final double y) {}

    public void drawText(final String text, final double x, final double y, final Paint p) {}
}
