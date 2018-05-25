import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class SquareVector extends Rectangle2D.Double implements FigureVector {
    private float angle;
    public Color color;

    SquareVector() {
        Random r = new Random();
        this.width = this.height = r.nextInt(20) + 5;
        this.angle = r.nextFloat() * 360;
        this.x = width * 3 + r.nextDouble() * (CANVAS_W - width * 6);
        this.y = height * 3 + r.nextDouble() * (CANVAS_H - height * 6);
        this.color = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
    }

    public void MoveSelf() {

        x = x + Math.cos(angle * Math.PI / 180) * SPEED;
        y = y + Math.sin(angle * Math.PI / 180) * SPEED;

        if (x <= this.width || x >= CANVAS_W - width * 2) {
            angle = 180 - angle;
        }

        if (y <= this.height || y >= CANVAS_H - height * 2) {
            angle = 360 - angle;
        }

    }
}
