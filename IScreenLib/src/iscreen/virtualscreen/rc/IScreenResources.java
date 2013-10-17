package iscreen.virtualscreen.rc;

import android.content.res.Resources;

public class IScreenResources {
    private Resources resources;

    public void configure(final Resources resources) {
        this.resources = resources;
    }

    protected Resources resources() {
        return resources;
    }
}
