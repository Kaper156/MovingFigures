import java.awt.geom.Rectangle2D;

public class ExtCircle extends Rectangle2D.Double implements ExtFigure{
    double angle = 0;
    public ExtCircle(double x, double y, double w, double h, double angle)
    {
        super(x, y, w, h);
        this.angle = angle % 360;
    }
}
