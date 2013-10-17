package iscreen;

import android.content.Context;
import android.graphics.Canvas;

import android.view.MotionEvent;
import android.view.View;

import iscreen.virtualscreen.VirtualScreen;
import iscreen.virtualscreen.VirtualScreens;
import iscreen.virtualscreen.draw.Drawer;
import iscreen.virtualscreen.rc.IScreenGlobalResources;
import iscreen.virtualscreen.rc.IScreenLocalResources;

public class IScreenView extends View {
    private VirtualScreen virtualScreen = VirtualScreens.instance.get(this.getClass());

    public IScreenView(final Context context) {
        super(context);
    }

    protected IScreenLocalResources resources() {
        return virtualScreen.resources;
    }

    protected IScreenLocalResources resources(Class<? extends View> viewClass) {
        VirtualScreen virtualScreen = VirtualScreens.instance.get(viewClass);

        return virtualScreen.resources;
    }

    protected IScreenGlobalResources globalResources() {
        return VirtualScreens.instance.resources;
    }

    @Override
    protected final void onDraw(final Canvas c) {
        virtualScreen.configure(c);

        draw(virtualScreen.drawer);
    }

    protected void draw(final Drawer drawer) {}

    @Override
    protected final void onSizeChanged(int w, int h, int oldW, int oldH) {
        virtualScreen.configure(w, h);

        resize(0.0, 0.0);
    }

    protected void resize(final double w, final double h) {}

    @Override
    public final boolean onTouchEvent(final MotionEvent e) {
        return touch(virtualScreen.transformTouch(e));
    }

    protected boolean touch(final MotionEvent e) {
        return false;
    }
}
