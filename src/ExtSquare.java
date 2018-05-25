import java.awt.geom.Ellipse2D;

public class ExtSquare extends Ellipse2D.Double implements ExtFigure{
    double angle = 0;
    public ExtSquare(double x, double y, double w, double h, double angle)
    {
        super(x, y, w, h);
        this.angle = angle % 360;
    }
}
