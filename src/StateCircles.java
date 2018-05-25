import java.awt.*;

public class StateCircles implements StateDraw {
    ContextPanel panel;

    StateCircles(ContextPanel panel) {
        this.panel = panel;
    }

    public void draw(Graphics2D g) {
        for (MovingCircle figure : panel.circles) {
            g.setColor(Color.yellow);
            g.draw(figure);
            g.setColor(figure.color);
            g.fill(figure);
        }
    }

    public void addFigure() {
        this.panel.circles.add(new MovingCircle());
    }

    public void removeFigure() {
        if (!panel.circles.isEmpty())
            panel.circles.remove(panel.circles.lastElement());
    }



}
