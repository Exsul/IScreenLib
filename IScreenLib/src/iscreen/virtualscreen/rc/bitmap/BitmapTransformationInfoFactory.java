package iscreen.virtualscreen.rc.bitmap;

public class BitmapTransformationInfoFactory {
    public BitmapTransformationInfo identity() {
        return new BitmapTransformationInfo();
    }

    public BitmapTransformationInfo rotation(final BitmapTransformationInfo transform, final double angle) {
        return transform.rotate(angle);
    }

    public BitmapTransformationInfo scale(final BitmapTransformationInfo transform, final double sx, final double sy) {
        return transform.scale(sx, sy);
    }
}
