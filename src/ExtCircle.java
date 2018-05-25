import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ExtCircle extends Ellipse2D.Double implements ExtFigure{
    double angle = 0;
    Color color;
    public ExtCircle(double x, double y, double w, double h, double angle, Color color)
    {
        super(x, y, w, h);
        this.angle = angle % 360;
        this.color = color;
    }
}
