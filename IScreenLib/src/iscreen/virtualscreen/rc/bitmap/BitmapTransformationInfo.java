package iscreen.virtualscreen.rc.bitmap;

public class BitmapTransformationInfo {
    private double angle;
    private double sx, sy;

    BitmapTransformationInfo() {}

    private BitmapTransformationInfo(final double angle, final double sx, final double sy) {
        this.angle = angle;
        this.sx = sx;
        this.sy = sy;
    }

    public BitmapTransformationInfo rotate(double angle) {
        return new BitmapTransformationInfo(this.angle + angle, this.sx, this.sy);
    }

    public BitmapTransformationInfo scale(double sx, double sy) {
        return new BitmapTransformationInfo(this.angle, this.sx * sx, this.sy * sy);
    }
}
