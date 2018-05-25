import java.awt.*;
import java.util.Random;

public class StateCircles implements StateDraw {
    ContextPanel panel;

    StateCircles(ContextPanel panel) {
        this.panel = panel;
    }

    public void draw(Graphics2D g) {
        for (ExtCircle figure : panel.circles) {
            g.setColor(Color.yellow);
            g.draw(figure);
            g.setColor(figure.color);
            g.fill(figure);
        }
    }

    public void addFigure() {
        Random r = new Random();
        double width, height ;
        width = height = r.nextInt(20) + 5;
        double angle = r.nextFloat() * 360;
        double x = width * 3 + r.nextDouble() * (panel.getWidth() - width * 6);
        double y = height * 3 + r.nextDouble() * (panel.getHeight() - height * 6);
        Color color = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());

        this.panel.circles.add(new ExtCircle(
                x,y, width, height,
                angle, color
        ));
    }

    public void removeFigure() {
        if (!panel.circles.isEmpty())
            panel.circles.remove(panel.circles.lastElement());
    }
}
