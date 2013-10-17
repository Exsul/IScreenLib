package iscreen.virtualscreen;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.MotionEvent;
import iscreen.virtualscreen.draw.Drawer;
import iscreen.virtualscreen.rc.IScreenLocalResources;

public class VirtualScreen {
    public final Drawer drawer = new Drawer();
    public final IScreenLocalResources resources = new IScreenLocalResources();

    public void configure(final Resources resources) {
        this.resources.configure(resources);
    }

    public void configure(final Canvas c) {
        drawer.configure(c);
    }

    public void configure(final int w, final int h) {

    }

    public MotionEvent transformTouch(final MotionEvent motionEvent) {
        return motionEvent;
    }

    public double w() {
        return 0.0;
    }

    public double h() {
        return 0.0;
    }
}
