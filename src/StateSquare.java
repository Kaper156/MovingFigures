import java.awt.*;

public class StateSquare implements StateDraw {
    ContextPanel panel;

    StateSquare(ContextPanel panel) {
        this.panel = panel;
    }

    public void draw(Graphics2D g) {
        for (SquareVector figure : panel.squares) {
            g.setColor(Color.green);
            g.draw(figure);
            g.setColor(figure.color);
            g.fill(figure);
        }
    }

    public void addFigure() {
        this.panel.squares.add(new SquareVector());
    }

    public void removeFigure() {
        if (!panel.squares.isEmpty())
            panel.squares.remove(panel.squares.lastElement());
    }
}
