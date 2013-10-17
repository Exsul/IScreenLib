package iscreen.virtualscreen;

import android.content.res.Resources;
import android.view.View;
import iscreen.virtualscreen.rc.IScreenGlobalResources;

import java.util.HashMap;
import java.util.Map;

public class VirtualScreens {
    public static VirtualScreens instance = new VirtualScreens();

    private final Map<Class<? extends View>, VirtualScreen> virtualScreensMap = new HashMap<Class<? extends View>, VirtualScreen>();

    public final IScreenGlobalResources resources = new IScreenGlobalResources();

    public VirtualScreen get(final Class<? extends View> viewClass) {
        VirtualScreen virtualScreen = virtualScreensMap.get(viewClass);

        if (virtualScreen == null) {
            virtualScreen = new VirtualScreen();

            virtualScreensMap.put(viewClass, virtualScreen);
        }

        return virtualScreen;
    }

    public void remove(final Class<? extends View> viewClass) {
        virtualScreensMap.remove(viewClass);
    }

    public void configure(final Resources resources) {
        this.resources.configure(resources);
    }

    private VirtualScreens() {}
}
