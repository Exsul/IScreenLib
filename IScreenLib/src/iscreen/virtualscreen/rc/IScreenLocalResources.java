package iscreen.virtualscreen.rc;

import android.graphics.Bitmap;
import iscreen.virtualscreen.rc.bitmap.BitmapTransformationInfo;

import java.util.HashMap;
import java.util.Map;

public class IScreenLocalResources extends IScreenResources {
    private Map<Integer, Map<BitmapTransformationInfo, Bitmap>> bitmaps = new HashMap<Integer, Map<BitmapTransformationInfo, Bitmap>>();

    public void loadBitmap(final int id, final double widthInPercents) {
    }

    public void loadBitmap(final int id, final BitmapTransformationInfo bitmapTransformationInfo) {

    }
}
