import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ExtSquare extends Rectangle2D.Double  implements ExtFigure{
    double angle = 0;
    Color color;
    public ExtSquare(double x, double y, double w, double h, double angle, Color color)
    {
        super(x, y, w, h);
        this.angle = angle % 360;
        this.color = color;
    }
}
